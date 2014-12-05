package com.print_stack_trace.voogasalad.model.engine.physics.collisions;

import com.print_stack_trace.voogasalad.model.engine.physics.CollisionHandler;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeModel;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeSpriteCharacteristics;

public class ObjectBothNoDisplacement extends CollisionHandler {

	@Override
	public void applyCollisionEffects(RuntimeSpriteCharacteristics s1,
			RuntimeSpriteCharacteristics s2, RuntimeModel currentRuntime) {
		s1.v_x = -s1.v_x;
		s2.v_x = -s2.v_x;
		s1.v_y = -s1.v_y;
		s2.v_y = -s2.v_y;
		s1.setDecelerationConstant(1.0f);
		s2.setDecelerationConstant(1.0f);
	}

}
