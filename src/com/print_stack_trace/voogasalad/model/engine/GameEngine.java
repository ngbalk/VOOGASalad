package com.print_stack_trace.voogasalad.model.engine;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.data.GameData;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine;
import com.print_stack_trace.voogasalad.model.engine.authoring.LevelModel;
import com.print_stack_trace.voogasalad.model.engine.runtime.PhysicsEngine;
import com.print_stack_trace.voogasalad.model.engine.runtime.PhysicsEngineList;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeEngine;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeModel;

public class GameEngine {
	private LevelModel currentLevel;
	private RuntimeEngine runtimeEngine;
	private GameAuthorEngine authorEngine = new GameAuthorEngine();
	private GameData gameData = new GameData();
	
	//-------------------CONSTRUCTORS-------------------//
	
	/**
	 * Constructor Method.
	 */
	public GameEngine() {
		//TODO: Implement Constructor
	}
	
	//-------------------PUBLIC METHODS-------------------//
	
	//TODO: @data This should mirror public on GameData.java
	public void loadGame(File gameFile) {
		//loadLevel(LevelModel level)
	}
	
	public void saveGame(String location, String fileName) throws IOException {
		LevelModel lvl = null; //TODO: Import from authoing enviro
		gameData.writeLevel(lvl, location, fileName);
	}

	//GAME AUTHORING
	
	public Integer addObjectToLevel(SpriteCharacteristics spriteModel) {
		return authorEngine.addObjectToLevel(spriteModel);
	}
	
	public boolean updateObject(Integer modelID, SpriteCharacteristics spriteModel) {
		return authorEngine.updateObject(modelID, spriteModel);
	}
	
	public boolean deleteObject(Integer modelID) {
		return authorEngine.deleteObject(modelID);
	}
	
	public void setProgramPhysicEngine(int engineIndex) {
		setPhysicsEngine(PhysicsEngineList.getProgramPhysicEngine(engineIndex));
	}
	
	public List<String> getProgramPhysicsEngineList() {
		return PhysicsEngineList.getProgramPhysicEngineList();
	}
	
	public void setProgramPhysicEngineUsingParams(int gravity, int drag, int intensity) {
		setPhysicsEngine(PhysicsEngineList.physicEngineFromParams(gravity, drag, intensity));
	}
	
	//GAME PLAYER
	
	public void update() {
		runtimeEngine.update();
	}
	
	public RuntimeModel getStatus() {
		return runtimeEngine.getStatus();
	}
	
	public Map<Integer, Double> getHighScoreList() {
		//TODO: Return high score list
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
	
	private void setPhysicsEngine(PhysicsEngine newEngine) {
		//.setPhysicsEngine(newEngine);
	}
}
