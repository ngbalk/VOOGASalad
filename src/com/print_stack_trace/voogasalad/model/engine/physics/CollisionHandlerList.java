package com.print_stack_trace.voogasalad.model.engine.physics;

import java.util.Map;

import com.print_stack_trace.voogasalad.model.engine.physics.PhysicsEngine.CollisionResult;

public class CollisionHandlerList {
	public enum UserDefinedCollisionParams {
		PointsAwarded,
		DamageDealt
	}
	
	public static CollisionHandler collisionEngineFromParams(CollisionResult baseHandler, UserDefinedCollisionParams paramType, int param) {
		//return new CollisionHandler() {
			//TODO: Impliment
		//};
		return null;
	}
}
