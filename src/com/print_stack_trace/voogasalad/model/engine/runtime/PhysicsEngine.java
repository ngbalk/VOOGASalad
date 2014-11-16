/**
 * @author Zachary Podbela
 * @author Pranava Raparla

 * Date Created: 11/11/14
 * Date Modified: 11/11/14
 */
package com.print_stack_trace.voogasalad.model.engine.runtime;

import java.util.Collection;
import java.util.Map;

import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;

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
	
	public enum CollisionResult {
		ObjectOneFullDisplacement,
		ObjectTwoFullDisplacement,
		ObjectBothFullDisplacement,
		ObjectBothNoDisplacement,
		NoAction
	};
	
	public PhysicsEngine() {
		decisionMatrix = new CollisionResult[MATRIX_SIZE][MATRIX_SIZE];
	}
	
	public void animateAll(Collection<SpriteCharacteristics> allObjects) {
		for(SpriteCharacteristics obj : allObjects) {
			soloHandler.applyPhysics(obj);
		}
		/*
			TODO: Detect Collisions
			If a collision is detected, call the private method collisionHandler(SpriteCharacteristics s1, SpriteCharacteristics s2)
			with the two colliding SpriteCharactoristicObjects. It would be best to put the collision detection logic in a new class
			(maybe even static since instance vars may not be needed);.
			
			Ideal Example
			if(CollisionDetector.isIntersecting(SpriteCharacteristics s1, SpriteCharacteristics s2)) {
				collisionHandler(SpriteCharacteristics s1, SpriteCharacteristics s2);
			}
		*/
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
	private void collisionHandler(SpriteCharacteristics s1, SpriteCharacteristics s2) {
		CollisionResult result = getResultOfCollision(s1, s2);
		CollisionHandler handler = getHandlerForResult(result);
		handler.applyCollisionEffects(s1, s2);
	}
	
	private CollisionResult getResultOfCollision(SpriteCharacteristics s1, SpriteCharacteristics s2) {
		return decisionMatrix[s1.objectType.ordinal()][s2.objectType.ordinal()];
	}
	
	public void setResultOfCollision(CollisionResult result, SpriteCharacteristics s1, SpriteCharacteristics s2) {
		 decisionMatrix[s1.objectType.ordinal()][s2.objectType.ordinal()] = result;
	}
	
	private CollisionHandler getHandlerForResult(CollisionResult result) {
		return handlerMap.get(result);
	}
	
	public void setHandlerForResult(CollisionResult result, CollisionHandler handler) {
		handlerMap.put(result, handler);
	}
}
