package com.print_stack_trace.voogasalad.model.engine.runtime.keyboard;

import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeEngine;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeSpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.runtime.keyboard.KeyApplicatorFactory.KeyResult;

public class KeyApplicationChecker {

	public static boolean doesKeyApply(KeyResult key, RuntimeSpriteCharacteristics s){
		if(key.equals(KeyResult.Up) && !s.isColliding && !s.canDoubleJump()) return false;
		if(key.equals(KeyResult.Down) && s.isColliding) return false;
		if(key.equals(KeyResult.Up) && s.isCollidingHorizontally) return false;
		if((key.equals(KeyResult.Right) || key.equals(KeyResult.Left)) && s.isCollidingHorizontally) return false;

		return true;
	}
	
}
