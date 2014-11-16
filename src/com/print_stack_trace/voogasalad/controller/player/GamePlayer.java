package com.print_stack_trace.voogasalad.controller.player;

import java.awt.List;
import java.io.File;
import java.util.ArrayList;

import com.print_stack_trace.voogasalad.controller.ViewController;
import com.print_stack_trace.voogasalad.guiElements.AbstractGUI;
import com.print_stack_trace.voogasalad.model.engine.GameEngine;
import com.print_stack_trace.voogasalad.model.engine.authoring.LevelModel;
import com.print_stack_trace.voogasalad.model.data.GameData;
import com.print_stack_trace.voogasalad.model.data.HighScore;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
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
		Button pauseButton = new Button("Pause Game");
		Button showBestScores = new Button("High Scores");
		
		pauseButton.setOnAction(e-> pause());
		loadGameButton.setOnAction(e -> selectLevelFile());
		showBestScores.setOnAction(e->extractAndDisplayScores());//e->com.print_stack_trace.voogasalad.model.data.GameData);
		//Image background = new Image("voogasalad_PrintStackTrace/src/SpriteImages/mushroom.png");
		//ImageView bg = new ImageView(new Image("../LevelImages/overworld_bg.png"));
		//bg.setImage(new Image(getClass().getResourceAsStream("../images/boss.png")));
		//myRoot.getChildren().add(bg);
		toolBar.getItems().addAll(newGameButton, loadGameButton, helpButton, pauseButton, showBestScores);
		myRoot.getChildren().add(toolBar);															
		return myRoot;
	}

	//may need to move this elsewhere to deal with hiding scores after a bit
	private void extractAndDisplayScores() {
		// TODO Auto-generated method stub
		ArrayList<HighScore> scores = new ArrayList<HighScore>();
		scores.add(new HighScore("Dan", 100));
		scores.add(new HighScore("Tim", 20));
		Text[] scoreTexts = new Text[scores.size()];
		for(int i =0; i<scores.size(); i++){
			String s = String.format("%1$s %2$s", scores.get(i).getPlayerName(), Integer.toString(scores.get(i).getMyScore()));
			scoreTexts[i] = new Text (500, (i+1)*150, s);
			System.out.println(s);
		}
		myRoot.getChildren().addAll(scoreTexts);
		//to be implemented once score object is ready to go...backend please update me on this
		return;
	}

	private void pause() {
		// TODO Auto-generated method stub
		//need a backend method to put in lambda (or here if complicated)
			//I'm guessing it'll involve changing a boolean
		System.out.println("test");
		return;
	}

	private Object selectLevelFile() {
		FileChooser fc = new FileChooser();
		File levelFile = fc.showOpenDialog(new Stage()); 
		//LevelModel lm = com.print_stack_trace.voogasalad.model.data.GameData.loadLevel(null);
		return null; 
	}

	
}
