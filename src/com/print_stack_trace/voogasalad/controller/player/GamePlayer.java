package com.print_stack_trace.voogasalad.controller.player;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import com.google.gson.JsonSyntaxException;
import com.print_stack_trace.voogasalad.Constants;
import com.print_stack_trace.voogasalad.controller.ViewController;
import com.print_stack_trace.voogasalad.controller.guiElements.DecisionTable;
import com.print_stack_trace.voogasalad.controller.guiElements.IntroSplashScreen;
import com.print_stack_trace.voogasalad.controller.guiElements.PlayerActionButton;
import com.print_stack_trace.voogasalad.controller.guiElements.PlayerSaveButton;
import com.print_stack_trace.voogasalad.controller.guiElements.PlayerToolBar;
import com.print_stack_trace.voogasalad.controller.guiElements.SaveMenuItem;
import com.print_stack_trace.voogasalad.exceptions.InvalidImageFileException;
import com.print_stack_trace.voogasalad.model.LevelCharacteristics;
import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.data.HighScore;
import com.print_stack_trace.voogasalad.model.engine.GameEngine;
import com.print_stack_trace.voogasalad.player.Score;
import com.print_stack_trace.voogasalad.utilities.Reflection;

public class GamePlayer implements ViewController {
	private Group myRoot;
	private GameEngine myGameEngine;
	private DecisionTable dt = new DecisionTable();
	private Score currentScore;
	private String DEFAULT_RESOURCE="./com/print_stack_trace/voogasalad/controller/guiResources/";
	private String DEFAULT_CLASS_PATH="com.print_stack_trace.voogasalad.controller.guiElements.";
	private String ELEMENT_RESOURCE_NAME="PlayerGUIElements";
	private String LABEL_RESOURCE_NAME="PlayerGUILabels";
	
	/* instance of buttons */
	private Button saveGame, resumeGame, pauseGame,stopGame;
	
	/***
	 * TODO: Obtain Front End Person to work on graphical elements
	 * determine which methods needs to be called from backend, so they can create public methods
	 */
	public Group initialize(GameEngine gameEngine) {
		myGameEngine = gameEngine;
		myRoot = new Group(); 
		myRoot.setOnKeyReleased(KeyPad);

		IntroSplashScreen splash = new IntroSplashScreen(gameEngine, 0, 0);
		splash.toFront();
		myRoot.getChildren().add(splash);
		splash.reAsssign(gameEngine, myRoot);
		return myRoot;
	}
	
	

	/**
	 * update the players view: Engine will change locations/stats on the backend; player will update the scene after changes
	 * Maybe use observables to observe when something changes (just a thought)
	 * @param levelCharacteristics 
	 * @param spriteCharacteristics 
	 */
	public void updateScene(Map<Integer, SpriteCharacteristics> spriteCharacteristics, LevelCharacteristics levelCharacteristics){
		for(Integer id : myGameEngine.getSpriteCharacteristics().keySet()){
			myRoot.getChildren().add(new ImageView(myGameEngine.getSpriteCharacteristics().get(id).getImage()));
		}
	}
	
	
	/*** 
	 * calls gameEngine to update Score;; need to hash out out we handle scores/coins
	 */
	private void updateScore(){
		//gameEngine.updateScore() 
		//(or if we are in charge of scores.. then scores.updateScore()
	} 
	
	private void pauseGame(){ //buttons with handlers
		//gameEngine.pause();
		//if gameplayer is the gameloop --> timeline.stop();
	}
	
	private void resumeGame(){ //buttons with handlers
		//gameEngine.resume();
		//timeline.resume();
	}
	private void saveGame(){   //buttons with handlers
		//gameEngine.saveGame();
	}
	
	private void stopGame(){
		//gameEngine.stopGame();
	}
	

	/**
	 * Handler for actions involving KeyPad.  
	 * add other keyEvents here
	 */
	private EventHandler<KeyEvent> KeyPad = new EventHandler<KeyEvent>(){
		public void handle(KeyEvent t){
			switch(t.getCode()){
			case UP: //doSomething()  break;
			case DOWN: //doSomething() break;
			case LEFT: //doSomething()  break;
			case RIGHT: //doSomething() break;
			
			}
		}
	};

	
	/***
	 * Method for Choosing Image --> Front End Person to modify to his/her liking
	 */
	private void getImageFromFile(){
		FileChooser fc = new FileChooser(); 
		File file = fc.showOpenDialog(new Stage());
		if (!file.getName().endsWith(Constants.JPEG) && !file.getName().endsWith(Constants.PNG)){

			ViewController.displayError(new InvalidImageFileException());
			return; 
		}
		FileInputStream fis;
	}
}
