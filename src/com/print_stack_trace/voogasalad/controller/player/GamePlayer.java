package com.print_stack_trace.voogasalad.controller.player;


import java.awt.event.ActionEvent;





import java.io.File;
import java.io.FileInputStream;

import Exceptions.GamePlayerException;

import com.print_stack_trace.voogasalad.Constants;
import com.print_stack_trace.voogasalad.controller.ViewController;
import com.print_stack_trace.voogasalad.model.engine.GameEngine;
import com.print_stack_trace.voogasalad.player.Score;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class GamePlayer implements ViewController {
	private Group root = new Group();
	private GameEngine gameEngine;
	
	private Score currentScore;
	
	/* instance of buttons */
	private Button saveGame, resumeGame, pauseGame,stopGame;
	
	/***
	 * TODO: Obtain Front End Person to work on graphical elements
	 * determine which methods needs to be called from  backend, so they can create public methods
	 */
	public Group initialize(GameEngine gameEngine) {
		this.gameEngine = gameEngine;
		root.setOnKeyReleased(KeyPad);
		initializeGUIElements();
		setHandlersForGuiElements();
		return root;
	}
	
	/**
	 * update the players view: Engine will change locations/stats on the backend; player will update the scene after changes
	 * Maybe use observables to observe when something changes (just a thought)
	 */
	public void updateScene(){
		
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
	 * Initialize all the GUI elements 
	 * Front End Person reponsible to implement this
	 * whether CSS or fxml etc.
	 */
	private void initializeGUIElements() {
	
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
	 * Handler for actions (buttons or action events)
	 * add button/action handlers here
	 */
	private void setHandlersForGuiElements(){
		saveGame.setOnAction(ActionEvent -> saveGame());
		resumeGame.setOnAction(ActionEvent -> resumeGame());
		pauseGame.setOnAction(ActionEvent -> pauseGame());
		stopGame.setOnAction(ActionEvent -> stopGame());
	}
	
	
	/***
	 * Method for Choosing Image --> Front End Person to modify to his/her liking
	 */
	private void getImageFromFile(){
		FileChooser fc = new FileChooser(); 
		File file = fc.showOpenDialog(new Stage());
		if (!file.getName().endsWith(Constants.JPEG) && !file.getName().endsWith(Constants.PNG)){
			GamePlayerException.displayError(Constants.PLEASE_UPLOAD_A_JPEG_OR_PNG);
			return; 
		}
		FileInputStream fis;
	}
	
}
