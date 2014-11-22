package com.print_stack_trace.voogasalad.model.engine.runtime;

import com.print_stack_trace.voogasalad.model.engine.authoring.LevelModel;

public abstract class AbstractRuntimeEngine {
	protected LevelModel currentLevel;
	
	public AbstractRuntimeEngine(LevelModel currentLevel) {
		this.currentLevel = currentLevel;
	}
	public abstract void update();
	public abstract RuntimeModel getStatus();
}
