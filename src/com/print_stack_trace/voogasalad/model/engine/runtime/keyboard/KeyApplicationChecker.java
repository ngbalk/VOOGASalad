package com.print_stack_trace.voogasalad.model.engine.runtime.keyboard;

import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeEngine;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeSpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.runtime.keyboard.KeyApplicatorFacotry.KeyResult;

public class KeyApplicationChecker {

	public static boolean doesKeyApply(KeyResult key, RuntimeSpriteCharacteristics s){
		if(key.equals(KeyResult.Up) && !s.isColliding) return false;
		return true;
	}
	
}
