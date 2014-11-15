package com.print_stack_trace.voogasalad.controller.player;

import java.io.File;

import com.print_stack_trace.voogasalad.controller.ViewController;
import com.print_stack_trace.voogasalad.guiElements.AbstractGUI;
import com.print_stack_trace.voogasalad.model.engine.GameEngine;
import com.print_stack_trace.voogasalad.model.engine.authoring.LevelModel;
import com.print_stack_trace.voogasalad.model.data.GameData;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

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
		
		loadGameButton.setOnAction(e -> selectLevelFile());
		//Image background = new Image(getClass().getResourceAsStream("../ObjectImages/mushroom.png"));
		//ImageView bg = new ImageView(new Image("../LevelImages/overworld_bg.png"));
		//bg.setImage(new Image(getClass().getResourceAsStream("../images/boss.png")));
		//myRoot.getChildren().add(bg);
		
		toolBar.getItems().addAll(newGameButton, loadGameButton, helpButton);
		myRoot.getChildren().add(toolBar);															
		return myRoot;
	}

	private Object selectLevelFile() {
		FileChooser fc = new FileChooser();
		File levelFile = fc.showOpenDialog(new Stage()); 
		//LevelModel lm = com.print_stack_trace.voogasalad.model.data.GameData.loadLevel(null);
		return null;
	}

	
}
