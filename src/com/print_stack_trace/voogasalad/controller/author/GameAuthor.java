package com.print_stack_trace.voogasalad.controller.author;

import com.print_stack_trace.voogasalad.controller.TabController;
import com.print_stack_trace.voogasalad.model.engine.GameEngine;

import javafx.scene.Group;

public class GameAuthor implements TabController {
	private Group root = new Group();
	private GameEngine gameEngine;
	
	public Group initialize(GameEngine gameEngine) {
		this.gameEngine = gameEngine;
		//TODO: Implement
		return root;
	}
	
	
}