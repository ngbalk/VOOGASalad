package com.print_stack_trace.voogasalad.controller.player;

import com.print_stack_trace.voogasalad.controller.TabController;
import com.print_stack_trace.voogasalad.model.engine.GameEngine;

import javafx.scene.Group;

public class GamePlayer implements TabController {
	private Group root = new Group();
	private GameEngine gameEngine;
	
	public Group initialize(GameEngine gameEngine) {
		this.gameEngine = gameEngine;
		//TODO: Implement
		return root;
	}
	
	/**
	 * uses the engine to update the players view
	 */
	public void updateScene(){
		
	}
}
