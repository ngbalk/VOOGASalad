package com.print_stack_trace.voogasalad.model.engine.physics.collisions;

import com.print_stack_trace.voogasalad.model.engine.physics.CollisionHandler;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeModel;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeSpriteCharacteristics;

public class PacmanCollision extends CollisionHandler{

	private boolean eating;
	
	@Override
	public void applyCollisionEffects(RuntimeSpriteCharacteristics s1,
			RuntimeSpriteCharacteristics s2, RuntimeModel currentRuntime) {
		if(s1.getPower()){
			s1.setAlpha(0.0f);
			s1.flagForRemoval();
		}
		else{
			s2.setAlpha(0.0f);
			s2.flagForRemoval();
		}
	}

	@Override
	public boolean shouldStick(RuntimeSpriteCharacteristics s1,
			RuntimeSpriteCharacteristics s2) {
		// TODO Auto-generated method stub
		return false;
	}

}
