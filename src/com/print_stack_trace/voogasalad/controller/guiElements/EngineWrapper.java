package com.print_stack_trace.voogasalad.controller.guiElements;

import com.print_stack_trace.voogasalad.model.engine.GameEngine;

public class EngineWrapper {
	private GameEngine myEngine;
	public EngineWrapper(GameEngine engine){
		myEngine=engine;
	}
	public void updateEngine(GameObject myObject){
		myEngine.updateObject(myObject.getId(), myObject.getCharacteristics());
	}
}
