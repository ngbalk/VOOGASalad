package com.print_stack_trace.voogasalad.model.engine.physics;

import com.print_stack_trace.voogasalad.model.CollisionEffects;
import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.physics.PhysicsEngine.CollisionResult;

public interface CollisionHandler {
	public boolean haveCollided(SpriteCharacteristics s1, SpriteCharacteristics s2);
	public void applyCollisionEffects(SpriteCharacteristics s1, SpriteCharacteristics s2);
}
