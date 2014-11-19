package com.print_stack_trace.voogasalad.model.engine.runtime;

import java.util.Map;

import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.environment.Goal;

public class RuntimeModel {

	//-------------------VARIABLES-------------------//

	public Map<Integer, SpriteCharacteristics> spriteMap;
	public Goal myGoal;

	//-------------------CONSTRUCTORS-------------------//

	/**
	 * Constructor
	 */
	public RuntimeModel() {
		//TODO: Implement
	}	
	
	//-------------------ACCESSORS-------------------//
	
	public Map<Integer, SpriteCharacteristics> getSpriteMap() {
		return spriteMap;
	}

	public Goal getMyGoal() {
		//consider returning a string instead of the entire goal
		return myGoal;
	}
	
}
