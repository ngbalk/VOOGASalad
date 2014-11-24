package com.print_stack_trace.voogasalad.model.engine.physics;

import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeSpriteCharacteristics;

public interface SoloPhysicsHandler {
	public void applyPhysics(RuntimeSpriteCharacteristics obj, int framesPerSecond);
}
