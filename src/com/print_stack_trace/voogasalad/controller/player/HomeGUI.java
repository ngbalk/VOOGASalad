package com.print_stack_trace.voogasalad.controller.player;

import com.print_stack_trace.voogasalad.controller.TabController;
import com.print_stack_trace.voogasalad.guiElements.AbstractGUI;
import com.print_stack_trace.voogasalad.model.engine.GameEngine;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ToolBar;

public class HomeGUI extends AbstractGUI implements TabController{
	GameEngine myGameEngine;
	public HomeGUI(Number width, Number height) {
		super(width, height);
	}
	private Group myRoot;
	public Group initialize(GameEngine gameEngine){
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
	@Override
	protected void setBorderAndBackgroundStyle(Node stylePane) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void setStyle(Node stylePane) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void setBorderStyle(Node stylePane) {
		// TODO Auto-generated method stub
		
	}

	
}
