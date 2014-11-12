package com.print_stack_trace.voogasalad.controller.player;

import com.print_stack_trace.voogasalad.controller.ViewController;
import com.print_stack_trace.voogasalad.model.engine.GameEngine;

import javafx.scene.Group;

public class GamePlayer implements ViewController {
	private Group root = new Group();
	private GameEngine gameEngine;
	
	public Group initialize(GameEngine gameEngine) {
		this.gameEngine = gameEngine;
		//TODO: Implement
		return root;
	}
}
