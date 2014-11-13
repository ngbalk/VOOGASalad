package com.print_stack_trace.voogasalad.controller.player;

import com.print_stack_trace.voogasalad.controller.ViewController;
import com.print_stack_trace.voogasalad.guiElements.AbstractGUI;
import com.print_stack_trace.voogasalad.model.engine.GameEngine;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;

public class GamePlayer implements ViewController{
	private Group myRoot;
	private GameEngine myGameEngine;
	
	public Group initialize(GameEngine gameEngine) {
		myGameEngine = gameEngine;
		myRoot = new Group();
		//Add behavior for menu buttons later
		
		ToolBar toolBar = new ToolBar();
		Button newGameButton= new Button("New Game");
		Button loadGameButton = new Button("Load Game");
		Button helpButton = new Button("Help");
		
		toolBar.getItems().addAll(newGameButton, loadGameButton, helpButton);
		myRoot.getChildren().add(toolBar);															
		return myRoot;
	}

	
}
