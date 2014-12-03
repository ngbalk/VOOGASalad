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

import com.print_stack_trace.voogasalad.Constants;
import com.print_stack_trace.voogasalad.controller.ViewController;
import com.print_stack_trace.voogasalad.controller.guiElements.DecisionTable;
import com.print_stack_trace.voogasalad.controller.guiElements.PlayerActionButton;
import com.print_stack_trace.voogasalad.controller.guiElements.PlayerSaveButton;
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
		
		//BUILD GUI ELEMENTS
		
		//BUILD GUI TOOLBAR
		
		ToolBar toolBar = new ToolBar();
		Properties classProp = new Properties();
		Properties labelProp = new Properties();
		InputStream classStream = getClass().getClassLoader().getResourceAsStream(DEFAULT_RESOURCE+ELEMENT_RESOURCE_NAME+".Properties");
		InputStream labelStream = getClass().getClassLoader().getResourceAsStream(DEFAULT_RESOURCE+LABEL_RESOURCE_NAME+".Properties");
		try {
			classProp.load(classStream);
			labelProp.load(labelStream);
			Iterator it = classProp.keySet().iterator();
			while(it.hasNext()){
				Object key = it.next();
				String classType = (String) key;
				String className = (String) classProp.get(key);
				className = DEFAULT_CLASS_PATH + className;
				Object newClass = Reflection.createInstance(className, myGameEngine, this);
				newClass.getClass().getMethod("setLabel", String.class).invoke(newClass, labelProp.get(key));
				toolBar.getItems().add((Node) newClass);
			}
			
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
		myRoot.getChildren().add(toolBar);
		return myRoot;
	}
	
	
	private void createTableVisual() {
		Stage stage = new Stage();
		stage.setWidth(500);
		stage.setHeight(500);
		stage.initStyle(StageStyle.UTILITY);
		Group root = new Group();
		Scene s = new Scene(root);
		root.getChildren().add(dt);
		stage.setScene(s);
		stage.show();
		return;
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

			ViewController.displayError(new InvalidImageFileException());
			return; 
		}
		FileInputStream fis;
	}

	//may need to move this elsewhere to deal with hiding scores after a bit
	private void extractAndDisplayScores() {
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
		// TODO Implement this method -- STOP CALLING update() on gameEngine
		return;
	}

	private Object selectLevelFile() {
		FileChooser fc = new FileChooser();
		File levelFile = fc.showOpenDialog(new Stage()); 
		//LevelModel lm = com.print_stack_trace.voogasalad.model.data.GameData.loadLevel(null);
		return null; 
	}
	
}
