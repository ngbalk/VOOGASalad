package com.print_stack_trace.voogasalad.controller.player;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import com.google.gson.JsonSyntaxException;
import com.print_stack_trace.voogasalad.Constants;
import com.print_stack_trace.voogasalad.VOOGASalad;
import com.print_stack_trace.voogasalad.controller.ViewController;
import com.print_stack_trace.voogasalad.controller.guiElements.DecisionTable;
import com.print_stack_trace.voogasalad.controller.guiElements.IntroSplashScreen;
import com.print_stack_trace.voogasalad.controller.guiElements.PlayPane;
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
	private Group myGameRoot;
	private PlayPane myPlayPane;
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
		IntroSplashScreen splash = new IntroSplashScreen(0, 0);
		splash.toFront();
		myRoot.getChildren().add(splash);
		splash.continueFromSplashScreen(this, myRoot);
		myPlayPane = new PlayPane();
		myPlayPane.setPrefSize(VOOGASalad.DEFAULT_WIDTH, VOOGASalad.DEFAULT_HEIGHT-150);
		myPlayPane.setLayoutY(100);
		myGameRoot = new Group(myPlayPane);
		myRoot.getChildren().add(myGameRoot);

		return myRoot;
	}
	
	

	/**
	 * update the players view: Engine will change locations/stats on the backend; player will update the scene after changes
	 * Maybe use observables to observe when something changes (just a thought)
	 * @param levelCharacteristics 
	 * @param spriteCharacteristics 
	 */
	public void updateScene(){ 
		LevelCharacteristics levelCharacteristics = myGameEngine.getLevelCharacteristics();
		Map<Integer, SpriteCharacteristics> spriteMap = myGameEngine.getSpriteMap();
		ImageView background = new ImageView(new Image(levelCharacteristics.getBackgroundImagePath()));
		background.setFitWidth(myPlayPane.getWidth());
		background.setFitHeight(myPlayPane.getHeight()-10);
		background.setFitWidth(myPlayPane.getWidth()-10);
		background.setSmooth(true);
		background.setPreserveRatio(false);
		background.relocate(5, 5);
		myPlayPane.getChildren().add(0,background);
		for(Integer id : spriteMap.keySet()){
			System.out.println("detected sprite ID = " + id);
			SpriteCharacteristics spriteCharacteristics = spriteMap.get(id);
			ImageView spriteImage = new ImageView(new Image(spriteCharacteristics.getImagePath()));
			System.out.println("Sprite Image path: " + spriteCharacteristics.getImagePath());
			System.out.println("Sprite X Location: " + spriteCharacteristics.getX());
			System.out.println("Sprite Y Location: " + spriteCharacteristics.getY());
			spriteImage.setFitWidth(spriteCharacteristics.getWidth());
			spriteImage.setFitHeight(spriteCharacteristics.getHeight());
			spriteImage.setRotate(spriteCharacteristics.getOrientation());
			spriteImage.setLayoutX(spriteCharacteristics.getX());
			spriteImage.setLayoutY(spriteCharacteristics.getY());
			myGameRoot.getChildren().add(spriteImage);
		}
		
	}
	
	
	/*** 
	 * calls gameEngine to update Score;; need to hash out out we handle scores/coins
	 */
	private void updateScore(){
		//gameEngine.updateScore() 
		//(or if we are in charge of scores.. then scores.updateScore()
	} 
	
	public void pauseGame(){ //buttons with handlers
		//gameEngine.pause();
		//if gameplayer is the gameloop --> timeline.stop();
	}
	
	public void resumeGame(){ //buttons with handlers
		//gameEngine.resume();
		//timeline.resume();
	}
	public void saveGame(){   
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save Level");
		Stage newStage=new Stage();
		File file = fileChooser.showSaveDialog(newStage);
		if (file != null) {
			try {
				FileOutputStream myFile=new FileOutputStream(file);
				myGameEngine.saveGame();
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
	
	public void stopGame(){
		//gameEngine.stopGame();
	}
	public void loadGame(){
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Load level");
		fileChooser.setInitialDirectory(new File(System.getProperty("user.dir") + "/src/com/print_stack_trace/voogasalad/model/data/"));
		Stage newStage=new Stage();
		File file = fileChooser.showOpenDialog(newStage);
		if (file != null) {
			try {
				FileInputStream myFile=new FileInputStream(file);
				myGameEngine.loadGame(myFile);
			} catch (IOException | JsonSyntaxException | ClassNotFoundException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
	public void showHighScores(){
		Map<String, HighScore> scores = myGameEngine.getHighScoreList();
		Group root = new Group();
		Scene scene = new Scene(root);
		Stage dialog = new Stage();
		dialog.setScene(scene);
		dialog.initModality(Modality.WINDOW_MODAL);
		VBox scoresVBox = new VBox();
		for(HighScore score : scores.values()){
			System.out.println(score.getPlayerName() + ":" + score.getMyScore());
			scoresVBox.getChildren().add(new Text(score.getPlayerName() + ":" + score.getMyScore()));
		}
		root.getChildren().add(scoresVBox);
		dialog.show();
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
