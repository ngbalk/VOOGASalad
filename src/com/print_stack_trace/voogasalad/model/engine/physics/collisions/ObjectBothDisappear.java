package com.print_stack_trace.voogasalad.model.engine.physics.collisions;

import com.print_stack_trace.voogasalad.model.engine.physics.CollisionHandler;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeModel;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeSpriteCharacteristics;

public class ObjectBothDisappear extends CollisionHandler {

	@Override
	public void applyCollisionEffects(RuntimeSpriteCharacteristics s1,
			RuntimeSpriteCharacteristics s2, RuntimeModel currentRuntime) {
		// TODO Auto-generated method stub
		s1.toggleInteractive(false);
		s1.setAlpha(0.0f);
		s1.flagForRemoval();
		s2.toggleInteractive(false);
		s2.setAlpha(0.0f);
		s2.flagForRemoval();
	}

    @Override
    public boolean shouldStick (RuntimeSpriteCharacteristics s1, RuntimeSpriteCharacteristics s2) {
        return true;
    }

}
