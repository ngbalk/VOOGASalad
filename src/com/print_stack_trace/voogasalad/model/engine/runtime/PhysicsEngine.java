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
	private CollisionResult[][] decisionMatrix;
	private Map<CollisionResult , CollisionHandler> handlerMap;
	private SoloPhysicsHandler soloHandler;
	
	public enum CollisionResult {
		ObjectOneFullDisplacement,
		ObjectTwoFullDisplacement,
		ObjectBothFullDisplacement,
		ObjectBothNoDisplacement,
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
	
	private void collisionHandler(SpriteCharacteristics s1, SpriteCharacteristics s2) {
		CollisionResult result = getResultOfCollision(s1, s2);
		CollisionHandler handler = getHandlerForResult(result);
		handler.applyResult(result, s1, s2);
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
