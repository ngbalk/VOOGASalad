package com.print_stack_trace.voogasalad.model.engine;

import com.print_stack_trace.voogasalad.model.LevelModel;
import com.print_stack_trace.voogasalad.model.RuntimeModel;

public class GameEngine {
	private LevelModel currentLevel;
	
	//-------------------CONSTRUCTORS-------------------//
	
	/**
	 * Constructor Method.
	 */
	public GameEngine() {
		//TODO: Implement Constructor
	}
	
	//-------------------PUBLIC METHODS-------------------//
	
	public RuntimeModel getStatus() {
		RuntimeModel ret = new RuntimeModel();
		/*TODO: Implement -- this is looks like an accessor to everyone else but
		 *a RuntimeModel should be created at the time it is called and built 
		 *from all of the various at time of call. */
		return ret;
	}
	
	//-------------------ACCESSORS-------------------//
	
	public LevelModel getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(LevelModel currentLevel) {
		this.currentLevel = currentLevel;
		loadLevel(currentLevel);
	}
	
	//-------------------PRIVATE METHODS-------------------//
	
	private void loadLevel(LevelModel level) {
		//TODO: Implement -- Will be used for setLevel but also reseting level.
	}
}
