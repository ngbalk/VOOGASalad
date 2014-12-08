package com.print_stack_trace.voogasalad.model.engine.physics.collisions;

import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeModel;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeSpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionHandler;

public class ObjectBothFullDisplacement extends CollisionHandler {

	@Override
	public void applyCollisionEffects(RuntimeSpriteCharacteristics s1,
			RuntimeSpriteCharacteristics s2, RuntimeModel currentRuntime) {
		s1.v_x = -s1.v_x;
		s2.v_x = -s2.v_x;
		//s1.setDecelerationConstant(0.1f);
		//s2.setDecelerationConstant(0.1f);
	}

}
