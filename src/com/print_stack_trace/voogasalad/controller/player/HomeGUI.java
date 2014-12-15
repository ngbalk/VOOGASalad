package com.print_stack_trace.voogasalad.controller.player;
import com.print_stack_trace.voogasalad.controller.ViewController;
import com.print_stack_trace.voogasalad.controller.guiElements.layout.AbstractGUI;
import com.print_stack_trace.voogasalad.model.engine.GameEngine;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HomeGUI extends AbstractGUI implements ViewController{
	GameEngine myGameEngine;
	public HomeGUI(double width, double height) {
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
		
		Image background = new Image("../LevelImages/overworld_bg.png");
		ImageView bg = new ImageView(background);
		myRoot.getChildren().add(bg);
		
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
