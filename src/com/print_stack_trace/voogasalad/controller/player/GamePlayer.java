package com.print_stack_trace.voogasalad.controller.player;


import java.awt.event.ActionEvent;



import com.print_stack_trace.voogasalad.controller.ViewController;

import com.print_stack_trace.voogasalad.model.engine.GameEngine;
import com.print_stack_trace.voogasalad.player.Score;

import javafx.scene.Group;
import javafx.scene.control.Button;

public class GamePlayer implements ViewController {
	private Group root = new Group();
	private GameEngine gameEngine;
	
	private Score currentScore;
	private Button saveGame, resumeGame, pauseGame,stopGame;
	
	
	public Group initialize(GameEngine gameEngine) {
		this.gameEngine = gameEngine;
		
		//TODO: Implement
		
		// initialize GUI Elements (method)
		currentScore = new Score();
		return root;
	}
	
	/**
	 * uses the engine to update the players view
	 */
	public void updateScene(){
		
	}
	
	private void updateScore(){
		/*** 
		 * calls gameEngine to update Score;; need to hash out out we handle scores/coins
		 */
		gameEngine.updateScore() //(or if we are in charge of scores.. then scores.updateScore()
	} 
	
	private void pauseGame(){ //buttons with handlers
		gameEngine.pause();
		//if gameplayer is the gameloop --> timeline.stop();
	}
	
	private void resumeGame(){ //buttons with handlers
		gameEngine.resume();
		//timeline.resume();
	}
	private void saveGame(){   //buttons with handlers
		gameEngine.saveGame();
	}
	
	private void stopGame(){
		gameEngine.stopGame();
	}
	
	private void setHandlersForGuiElements(){
		saveGame.setOnAction(ActionEvent -> saveGame());
		resumeGame.setOnAction(ActionEvent -> resumeGame());
		pauseGame.setOnAction(ActionEvent -> pauseGame());
		stopGame.setOnAction(ActionEvent -> stopGame());
	}
	
}
