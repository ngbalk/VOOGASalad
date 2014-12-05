/**
 * @author Zachary Podbela
 * @author Pranava Raparla
 * Date Created: 11/11/14
 * Date Modified: 11/23/14
 */
package com.print_stack_trace.voogasalad.model.engine.physics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionFactory.CollisionResult;
import com.print_stack_trace.voogasalad.model.engine.physics.SoloPhysicsGenerator.ProgramPhysicEngine;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeModel;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeSpriteCharacteristics;

public class PhysicsEngine {
	private static final int MATRIX_SIZE = SpriteType.values().length;
	
	/**
	 * The decision Matrix is the basis for determining HOW to handle a given collision.
	 * 
	 *	 								SpriteType
	 *			 			|	A	|	B	|	C	|	D	|
	 *				 	A	|Explode|		|		|		|
	 *  SpriteType	 	B	|		|Allow	|Disp2	|		|
	 *					C	|		|Disp1	|		|		|
	 *					D	|		|		|		|		|
	 *
	 * Given two objects that have collided, we can lookup their types in the table
	 * and get back a CollisionResult describing how the collision should play out.
	 * For example, if a sprite of type A collides with another sprite of type A,
	 * we know we must apply an "explode" type collision to them both.
	 */
	private CollisionResult[][] decisionMatrix;
	
	private Map<CollisionResult , CollisionHandler> handlerMap;
	private SoloPhysicsHandler soloHandler;
	
	public PhysicsEngine() {
		decisionMatrix = new CollisionResult[MATRIX_SIZE][MATRIX_SIZE];
		//Defaults
		for(int i = 0; i < MATRIX_SIZE; i++) {
			for(int j = 0; j < MATRIX_SIZE; j++) {
				decisionMatrix[i][j] = CollisionResult.NoAction;
			}
		}
		soloHandler = SoloPhysicsGenerator.getProgramPhysicEngine(ProgramPhysicEngine.EarthPhysicsEngine);
	}
	
	/**
	 * Public method for animating the level.
	 * The lifecycle is as follows:
	 * 		1. Objects are animated within their own scope according to "world" 
	 * 		(or global) physics. This includes gravity, drag/wind, and intensity
	 * 		2. All objects are checked for collisions using the CollisionDetector.
	 * 		Once it has been confirmed that two RuntimeSpriteCharacteristics are
	 * 		colliding, we call on the private helper method collisionHandler();
	 * 		3. Delete objects from the level that have been flagged for removal.
	 * @param 	allObjects
	 * 		a Collection of RuntimeSpriteCharacteristics that contains all of the
	 * 		objects in a level.
	 * @param 	framesPerSecond
	 * 		an int representing the current frames per second the front end is
	 * 		calling update at. Important for physics related calculations (such
	 * 		as how gravity translates to position).
	 * @see	CollisionDetector, RuntimeSpriteCharacteristics
	 */
	public void animateAll(RuntimeModel currentRuntime, int framesPerSecond) {
		Collection<RuntimeSpriteCharacteristics> allObjects = currentRuntime.getRuntimeSpriteMap().values();
		for(RuntimeSpriteCharacteristics obj : allObjects) {
			if(obj.interactive) soloHandler.applyPhysics(obj, framesPerSecond);
		}
		
		
		Object[] array = allObjects.toArray();
		for(int i = 0; i < array.length; i++) {
			RuntimeSpriteCharacteristics s1 = (RuntimeSpriteCharacteristics) array[i];
			for(int j = i+1; j < array.length; j++) {
				RuntimeSpriteCharacteristics s2 = (RuntimeSpriteCharacteristics) array[j];
				if(CollisionDetector.haveCollided(s1, s2)) {
					//collisionHandler(s1, s2, currentRuntime);
				}	
			}
		}
		
		Collection<RuntimeSpriteCharacteristics> toRemove = new ArrayList<RuntimeSpriteCharacteristics>();
		for(RuntimeSpriteCharacteristics obj : allObjects) {
			if (obj.shouldBeRemoved()) toRemove.add(obj);
		}
		allObjects.removeAll(toRemove);
	}
		
	/**
	 * Private method to assist in the proper collision handling lifecycle.
	 * Once it has been confirmed that two SpriteCharacteristics are colliding, 
	 * we must determine what collision should occur given the types of colliding
	 * objects and then apply the collision to the objects.
	 * the following events happen:
	 * 		1. The decisionMatrix is used to get the proper CollisionResult for 
	 * 		the colliding types of SpriteCharacteristics.
	 * 		2. The handlerMap is used to get the proper CollisionHandler subclass
	 * 		for applying the CollisionResult received in step 1.
	 * 		3. Call the .applyResult method on the CollisionResult subclass
	 * 		received in step 2 to animate, transform, or change the states of the
	 * 		colliding objects.
	 * @param 	s1
	 * 		a SpriteCharacteristics instance representing one of the colliding objects
	 * @param 	s2	
	 * 		a SpriteCharacteristics instance representing the other colliding object
	 * @see	CollisionHandler, SpriteCharacteristics
	 */
	private void collisionHandler(RuntimeSpriteCharacteristics s1, RuntimeSpriteCharacteristics s2, RuntimeModel currentRuntime) {
		CollisionResult result = getResultOfCollision(s1, s2);
		CollisionHandler handler = getHandlerForResult(result);
		handler.applyCollisionEffects(s1, s2, currentRuntime);
	}
	
	private CollisionResult getResultOfCollision(RuntimeSpriteCharacteristics s1, RuntimeSpriteCharacteristics s2) {
		return decisionMatrix[s1.objectType.ordinal()][s2.objectType.ordinal()];
	}
	
	public void setResultOfCollision(CollisionResult result, SpriteType s1, SpriteType s2) {
		 decisionMatrix[s1.ordinal()][s2.ordinal()] = result;
	}
	
	private CollisionHandler getHandlerForResult(CollisionResult result) {
		CollisionHandler ret = handlerMap.get(result);
		if(ret == null) {
			ret = CollisionFactory.buildCollisionHandler(result);
			setHandlerForResult(result, ret);
		}
		return ret;
	}
	
	public void setHandlerForResult(CollisionResult result, CollisionHandler handler) {
		handlerMap.put(result, handler);
	}
	
	public SoloPhysicsHandler getSoloHandler() {
		return soloHandler;
	}

	public void setSoloHandler(SoloPhysicsHandler soloHandler) {
		this.soloHandler = soloHandler;
	}
}
