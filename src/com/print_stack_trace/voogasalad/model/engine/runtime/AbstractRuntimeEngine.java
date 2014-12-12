package com.print_stack_trace.voogasalad.model.engine.runtime;

import com.print_stack_trace.voogasalad.model.engine.authoring.GameWorldModel;
import com.print_stack_trace.voogasalad.model.engine.authoring.LevelModel;

public abstract class AbstractRuntimeEngine {
	protected LevelModel currentLevel;
	protected GameWorldModel gameWorld;
	
	public AbstractRuntimeEngine(LevelModel currentLevel) {
		this.currentLevel = currentLevel;
	}
	
	public AbstractRuntimeEngine(GameWorldModel gameWorld) {
	    this.gameWorld = gameWorld;
	}
	
	public abstract void update();
	public abstract RuntimeModel getStatus();
}
