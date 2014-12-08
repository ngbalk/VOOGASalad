package com.print_stack_trace.voogasalad.model.engine;

import java.awt.Dimension;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import com.google.gson.JsonSyntaxException;
import com.print_stack_trace.voogasalad.model.GameWorldCharacteristics;
import com.print_stack_trace.voogasalad.model.GoalCharacteristics;
import com.print_stack_trace.voogasalad.model.LevelCharacteristics;
import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.data.IGameData;
import com.print_stack_trace.voogasalad.model.data.GameData;
import com.print_stack_trace.voogasalad.model.data.HighScore;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameWorldModel;
import com.print_stack_trace.voogasalad.model.engine.authoring.IGameAuthorEngine;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;
import com.print_stack_trace.voogasalad.model.engine.authoring.LevelModel;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionFactory.UserDefinedCollisionParams;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionFactory.CollisionResult;
import com.print_stack_trace.voogasalad.model.engine.physics.PhysicsEngine;
import com.print_stack_trace.voogasalad.model.engine.physics.SoloPhysicsGenerator.ProgramPhysicEngine;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeEngine;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeModel;
import com.print_stack_trace.voogasalad.model.engine.runtime.camera.CameraFactory;
import com.print_stack_trace.voogasalad.model.engine.runtime.camera.CameraFactory.CameraType;
import com.print_stack_trace.voogasalad.model.engine.runtime.keyboard.KeyApplicatorFactory.KeyResult;
import com.print_stack_trace.voogasalad.model.environment.Goal;
import com.print_stack_trace.voogasalad.model.environment.GoalFactory;
import com.print_stack_trace.voogasalad.model.environment.GoalFactory.GoalType;

public class GameEngine {
	private GameWorldModel gameWorldModel;
	private LevelModel currentLevel;
	private RuntimeEngine runtimeEngine;
	private IGameAuthorEngine authorEngine;
	private IGameData gameData;
	private int framesPerSecond;
	private Map<String, HighScore> highScores;
	private Dimension viewport;

	//-------------------CONSTRUCTORS-------------------//

	public GameEngine() {
		gameWorldModel = new GameWorldModel();
	}
	
	public GameEngine(Dimension viewport, IGameAuthorEngine authorEngine, IGameData gameData) {
		this();
		this.authorEngine = authorEngine;
		this.gameData = gameData;
		this.viewport = viewport;
	}
	
	public GameEngine(Dimension viewport) {
		this(viewport, new GameAuthorEngine(), new GameData());
	}
	
	//-------------------PUBLIC METHODS-------------------//

	public void loadGame(File myFile) throws JsonSyntaxException, ClassNotFoundException, IOException {
		initializeGame(loadGameFromFile(myFile));
	}
	
	public GameWorldModel loadGameFromFile(File myFile) throws JsonSyntaxException, ClassNotFoundException, IOException {
		return (GameWorldModel) gameData.load(myFile, LevelModel.class);
	}

	public void saveGame() throws IOException {
		GameWorldModel game = authorEngine.getGameWorldModel();
		gameData.write(game);
		for(LevelModel level: game.getLevels()) {
			debugLevel(level);
		}
	}

	public void debugLevel(LevelModel lvl){
		for(int i=0 ;i < lvl.getPhysicsEngine().decisionMatrix.length ;i++){
			for(int j=0; j < lvl.getPhysicsEngine().decisionMatrix[0].length; j++){
				CollisionResult c = lvl.getPhysicsEngine().decisionMatrix[i][j];
				if(!(c.name().toString().equals(CollisionResult.NoAction.toString()))){
					System.out.println(c.name());
				}
			}
		}
		for(Integer i : lvl.getSpriteMap().keySet()){
			SpriteCharacteristics s = lvl.getSpriteMap().get(i);
			System.out.println("type = " + s.objectType
					+ "x,y = " + s.getX() +"," + s.getY()
					+ "orientation = " + s.getOrientation()
					+ "name = " + s.getName());
		}
		for(GoalCharacteristics g : lvl.getGoalMap().values()){
			System.out.println(g.myGoalType);
		}
	}

	//GAME AUTHORING
	
	//GameWorld data
	public void setGameWorldCharacteristics(GameWorldCharacteristics gameWorldCharacteristics) {
		authorEngine.setGameWorldCharacteristics(gameWorldCharacteristics);
	}

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
	public void setPhysicsEngine(PhysicsEngine physicsEngine) {
		authorEngine.setPhysicsEngine(physicsEngine);
	}

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

	public void setCameraType(CameraFactory.CameraType cameraType) {
		authorEngine.setCameraType(cameraType);
	}

	//Global Parameters
	public void setLevelCharacteristics(LevelCharacteristics levelSpecs) {
		authorEngine.setLevelCharacteristics(levelSpecs);
	}

	//Setting Keyboard/Movement
	public Integer getMainCharacter() {
		return authorEngine.getMainCharacter();
	}

	public void setMainCharacter(Integer mainCharacter) {
		authorEngine.setMainCharacter(mainCharacter);
	}

	public void setResultForKey(KeyResult result, KeyCode key) {
		authorEngine.setResultForKey(result, key);
	}

	public KeyResult getResultOfKey(KeyCode key) {
		return authorEngine.getResultOfKey(key);
	}

	//GAME PLAYER

	public Map<Integer, SpriteCharacteristics> getSpriteMap(){
		return currentLevel.getSpriteMap();
	}
	public LevelCharacteristics getLevelCharacteristics(){
		return currentLevel.getLevelCharacteristics();
	}
	public void update() {
		runtimeEngine.update();
	}
	
	public LevelModel getCurrentLevel() {
		return currentLevel;
	}
	
	public RuntimeModel getStatus() {
		return runtimeEngine.getStatus();
	}

	public Map<String, HighScore> getHighScoreList(){
		try {
			highScores = (Map<String, HighScore>) gameData.getObject("HighScores", highScores.getClass());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return highScores;
	}

	public EventHandler<KeyEvent> getRuntimeKeyPressHandler() {
		return new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent arg0) {
				handleKeyPress(arg0);
			}
		};
	}

	public EventHandler<KeyEvent> getRuntimeKeyReleaseHandler() {
		return new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent arg0) {
				handleKeyRelease(arg0);
			}
		};
	}

	public void setFramesPerSecond(int framesPerSecond) {
		this.framesPerSecond = framesPerSecond;
	}

	//-------------------PRIVATE METHODS-------------------//

	private void initializeLevel(LevelModel level) {
		this.currentLevel = level;

//		FIXME: Remove this work around garbage
		Integer first = currentLevel.getSpriteMap().keySet().iterator().next();
		currentLevel.setMainCharacter(first);
		currentLevel.setResultForKey(KeyResult.Up, KeyCode.UP);
		currentLevel.setResultForKey(KeyResult.Down, KeyCode.DOWN);
		currentLevel.setResultForKey(KeyResult.Left, KeyCode.LEFT);
		currentLevel.setResultForKey(KeyResult.Right, KeyCode.RIGHT);

//		GoalCharacteristics g = new GoalCharacteristics(GoalType.REACH_OBJECT);
//		g.myDestination = 100;
//		g.myObjectID = 2;	
//		currentLevel.setGoal(g);
//
//		LevelCharacteristics l = currentLevel.getLevelCharacteristics();
//		l.requiredNumberOfGoals = 1;
//		currentLevel.setLevelCharacteristics(l);
		
		runtimeEngine = new RuntimeEngine(currentLevel, viewport);
		runtimeEngine.setFramesPerSecond(framesPerSecond);
	}
	
	private void initializeGame(GameWorldModel gameWorld) {
		this.currentLevel = gameWorld.getCurrentLevel();

//		FIXME: Remove this work around garbage
		Integer first = currentLevel.getSpriteMap().keySet().iterator().next();
		currentLevel.setMainCharacter(first);
		currentLevel.setResultForKey(KeyResult.Up, KeyCode.UP);
		currentLevel.setResultForKey(KeyResult.Down, KeyCode.DOWN);
		currentLevel.setResultForKey(KeyResult.Left, KeyCode.LEFT);
		currentLevel.setResultForKey(KeyResult.Right, KeyCode.RIGHT);

//		GoalCharacteristics g = new GoalCharacteristics(GoalType.REACH_OBJECT);
//		g.myDestination = 100;
//		g.myObjectID = 2;	
//		currentLevel.setGoal(g);
//
//		LevelCharacteristics l = currentLevel.getLevelCharacteristics();
//		l.requiredNumberOfGoals = 1;
//		currentLevel.setLevelCharacteristics(l);
		
		runtimeEngine = new RuntimeEngine(currentLevel, viewport);
		runtimeEngine.setFramesPerSecond(framesPerSecond);
	}


	public void saveHighScore(String name, HighScore highScore) throws IOException {
		highScores.put(name, highScore);
		gameData.storeObject(highScores, "HighScores");
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
