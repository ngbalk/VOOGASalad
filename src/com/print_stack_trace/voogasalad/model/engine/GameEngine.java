package com.print_stack_trace.voogasalad.model.engine;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

import com.print_stack_trace.voogasalad.model.GoalCharacteristics;
import com.print_stack_trace.voogasalad.model.LevelCharacteristics;
import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.data.AbstractGameData;
import com.print_stack_trace.voogasalad.model.data.GameData;
import com.print_stack_trace.voogasalad.model.data.HighScore;
import com.print_stack_trace.voogasalad.model.engine.authoring.AbstractGameAuthorEngine;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;
import com.print_stack_trace.voogasalad.model.engine.authoring.LevelModel;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.CameraType;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionHandlerList.UserDefinedCollisionParams;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionFactory.CollisionResult;
import com.print_stack_trace.voogasalad.model.engine.physics.PhysicsEngineList.ProgramPhysicEngine;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeEngine;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeModel;

public class GameEngine {
	private LevelModel currentLevel;
	private RuntimeEngine runtimeEngine;
	private AbstractGameAuthorEngine authorEngine;
	private AbstractGameData gameData;

	//-------------------CONSTRUCTORS-------------------//

	/**
	 * Constructor Method.
	 */
	public GameEngine() {
		this(new GameAuthorEngine(), new GameData());
	}
	
	public GameEngine(AbstractGameAuthorEngine authorEngine, AbstractGameData gameData) {
		this.authorEngine = authorEngine;
		this.gameData = gameData;
	}

	//-------------------PUBLIC METHODS-------------------//
	
	public void loadGame(BufferedInputStream inputStream) {
		loadLevel(gameData.loadLevel(inputStream));
	}
	
	public void saveGame(BufferedOutputStream outputStream) throws IOException {
		LevelModel lvl = authorEngine.getCurrentLevel();
		gameData.writeLevel(lvl, outputStream);
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

	public void setPhysicsEngineUsingParams(int gravity, int drag, int intensity) {
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
	
	public EventHandler<KeyEvent> getRuntimeKeyHandler() {
		return null;
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
}
