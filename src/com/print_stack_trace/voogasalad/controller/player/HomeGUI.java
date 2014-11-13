package com.print_stack_trace.voogasalad.controller.player;

import com.print_stack_trace.voogasalad.model.engine.GameEngine;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ToolBar;

public class HomeGUI {
	private Group myRoot;
	public Group initialize(GameEngine gameEngine){
		myRoot = new Group();
		//Add behavior for menu buttons later
		
		ToolBar toolBar = new ToolBar();
		Button newGameButton= new Button("New Game");
		Button loadGameButton = new Button("Load Game");
		Button helpButton = new Button("Help");
		newGameButton.setOnAction(e->System.out.println("this"));
		
		toolBar.getItems().addAll(newGameButton, loadGameButton, helpButton);
		myRoot.getChildren().add(toolBar);															
		return myRoot;
	}

	
}
