package com.print_stack_trace.voogasalad.model.engine.physics;

import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.physics.PhysicsEngine.CollisionResult;

public interface CollisionHandler {
	public void applyResult(CollisionResult result, SpriteCharacteristics s1, SpriteCharacteristics s2);
}
