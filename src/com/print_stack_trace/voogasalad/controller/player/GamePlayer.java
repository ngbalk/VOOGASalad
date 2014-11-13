package com.print_stack_trace.voogasalad.controller.player;

import com.print_stack_trace.voogasalad.controller.TabController;
import com.print_stack_trace.voogasalad.model.engine.GameEngine;

import javafx.scene.Group;
import javafx.scene.Scene;

public class GamePlayer implements TabController {
	private Group root = new Group();
	private GameEngine gameEngine;
	
	public Group initialize(GameEngine gameEngine) {
		this.gameEngine = gameEngine;
		HomeGUI homeGUI = new HomeGUI();
		return homeGUI.initialize(gameEngine);
	}
	
}
