/**
 * @author Zachary Podbela
 * @author Pranava Raparla
 * Date Created: 11/11/14
 * Date Modified: 11/23/14
 */
package com.print_stack_trace.voogasalad.model.engine.physics;

import java.util.Collection;
import java.util.Map;

import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionFactory.CollisionResult;
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
	}
	
	public void animateAll(Collection<RuntimeSpriteCharacteristics> allObjects, int framesPerSecond) {
		for(RuntimeSpriteCharacteristics obj : allObjects) {
			soloHandler.applyPhysics(obj, framesPerSecond);
		}
		
		RuntimeSpriteCharacteristics[] array = (RuntimeSpriteCharacteristics[]) allObjects.toArray();
		for(int i = 0; i < array.length; i++) {
			RuntimeSpriteCharacteristics s1 = array[i];
			for(int j = i+1; j < array.length; j++) {
				RuntimeSpriteCharacteristics s2 = array[j];
				if(CollisionDetector.haveCollided(s1, s2)) {
					collisionHandler(s1, s2);
				}	
			}
		}
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
	private void collisionHandler(RuntimeSpriteCharacteristics s1, RuntimeSpriteCharacteristics s2) {
		CollisionResult result = getResultOfCollision(s1, s2);
		CollisionHandler handler = getHandlerForResult(result);
		handler.applyCollisionEffects(s1, s2);
	}
	
	private CollisionResult getResultOfCollision(RuntimeSpriteCharacteristics s1, RuntimeSpriteCharacteristics s2) {
		return decisionMatrix[s1.objectType.ordinal()][s2.objectType.ordinal()];
	}
	
	public void setResultOfCollision(CollisionResult result, SpriteType s1, SpriteType s2) {
		 decisionMatrix[s1.ordinal()][s2.ordinal()] = result;
	}
	
	private CollisionHandler getHandlerForResult(CollisionResult result) {
		return handlerMap.get(result);
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
