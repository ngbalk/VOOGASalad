package com.print_stack_trace.voogasalad.model.engine;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

import com.google.gson.JsonSyntaxException;
import com.print_stack_trace.voogasalad.model.GoalCharacteristics;
import com.print_stack_trace.voogasalad.model.LevelCharacteristics;
import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.data.IGameData;
import com.print_stack_trace.voogasalad.model.data.GameData;
import com.print_stack_trace.voogasalad.model.data.HighScore;
import com.print_stack_trace.voogasalad.model.engine.authoring.IGameAuthorEngine;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;
import com.print_stack_trace.voogasalad.model.engine.authoring.LevelModel;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.CameraType;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionFactory.UserDefinedCollisionParams;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionFactory.CollisionResult;
import com.print_stack_trace.voogasalad.model.engine.physics.SoloPhysicsGenerator.ProgramPhysicEngine;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeEngine;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeModel;

public class GameEngine {
	private LevelModel currentLevel;
	private RuntimeEngine runtimeEngine;
	private IGameAuthorEngine authorEngine;
	private IGameData gameData;

	//-------------------CONSTRUCTORS-------------------//

	/**
	 * Constructor Method.
	 */
	public GameEngine() {
		this(new GameAuthorEngine(), new GameData());
	}
	
	public GameEngine(IGameAuthorEngine authorEngine, IGameData gameData) {
		this.authorEngine = authorEngine;
		this.gameData = gameData;
	}

	//-------------------PUBLIC METHODS-------------------//
	
	public void loadGame(FileInputStream myFile) throws JsonSyntaxException, ClassNotFoundException, IOException {
		loadLevel((LevelModel) gameData.loadLevelMarcus(myFile));
	}
	
	public void saveGame() throws IOException {
		LevelModel lvl = authorEngine.getCurrentLevel();
		gameData.writeLevel(lvl);
		
	}

	//GAME AUTHORING

	//Adding, Removing, and Updating Sprites
	public Integer addObjectToLevel(SpriteCharacteristics spriteModel) {
		return authorEngine.addObjectToLevel(spriteModel);
	}

	public void updateObject(Integer modelID, SpriteCharacteristics spriteModel) {
		authorEngine.updateObject(modelID, spriteModel);
	}

	public void deleteObject(Integer modelID) {
		authorEngine.deleteObject(modelID);
	}

	//Adding, Removing, and Updating Goals
	public Integer addGoalToLevel(GoalCharacteristics goalModel) {
		return authorEngine.addGoalToLevel(goalModel);
	}

	public void updateGoal(Integer goalID, GoalCharacteristics goalModel) {
		authorEngine.updateGoal(goalID, goalModel);
	}

	public void deleteGoal(Integer goalID) {
		authorEngine.deleteGoal(goalID);
	}

	//Global Physics
	public void setProgramPhysicsEngine(ProgramPhysicEngine engineType) {
		authorEngine.setProgramPhysicsEngine(engineType);
	}

	public void setPhysicsEngineUsingParams(float gravity, float drag, float intensity) {
		authorEngine.setPhysicsEngineUsingParams(gravity, drag, intensity);
	}

	//Sprite-to-Sprite Physics
	public void setResultOfCollision(CollisionResult result, SpriteType s1, SpriteType s2) {
		authorEngine.setResultOfCollision(result, s1, s2);
	}

	public void setCustomParamForCollisionType(CollisionResult result, UserDefinedCollisionParams paramType, int param) {
		authorEngine.setCustomParamForCollisionType(result, paramType, param);
	}

	//Viewport/Camera Parameters

	public void setCameraType(CameraType cameraType) {
		authorEngine.setCameraType(cameraType);
	}

	//Global Parameters
	public void setLevelCharacteristics(LevelCharacteristics levelSpecs) {
		authorEngine.setLevelCharacteristics(levelSpecs);
	}

	//GAME PLAYER

	public void update() {
		runtimeEngine.update();
	}

	public RuntimeModel getStatus() {
		return runtimeEngine.getStatus();
	}

	public Map<String, HighScore> getHighScoreList() {
		return gameData.getHighScores();
	}
	
	public EventHandler<KeyEvent> getRuntimeKeyPressHandler() {
		return new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent arg0) {
				handleKeyPress(arg0);
			}
		};
	}
	
	public EventHandler<KeyEvent> getRuntimeKeyReleasaeHandler() {
		return new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent arg0) {
				handleKeyRelease(arg0);
			}
		};
	}
	
	public void setFramesPerSecond(int framesPerSecond) {
		runtimeEngine.setFramesPerSecond(framesPerSecond);
	}
	
	//-------------------ACCESSORS-------------------//

	public LevelModel getCurrentLevel() {
		return currentLevel;
	}

	//-------------------PRIVATE METHODS-------------------//

	private void loadLevel(LevelModel level) {
		this.currentLevel = level;
		runtimeEngine = new RuntimeEngine(currentLevel);
	}

	public void saveHighScore(String name, HighScore highScore) {
		gameData.saveHighScore(name, highScore);
	}
	
	private void handleKeyRelease(KeyEvent event) {
		if(runtimeEngine != null) {
			runtimeEngine.handleKeyRelease(event);
		}
	}
	
	private void handleKeyPress(KeyEvent event) {
		if(runtimeEngine != null) {
			runtimeEngine.handleKeyPress(event);
		}
	}
}
