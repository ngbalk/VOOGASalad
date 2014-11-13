package com.print_stack_trace.voogasalad.model.engine;

import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.util.List;
import java.util.Map;

import com.print_stack_trace.voogasalad.model.LevelModel;
import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.runtime.PhysicsEngine;
import com.print_stack_trace.voogasalad.model.engine.runtime.PhysicsEngineList;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeEngine;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeModel;

public class GameEngine {
	private LevelModel currentLevel;
	private RuntimeEngine runtimeEngine;
	
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
	
	//TODO: @data This should mirror public on GameData.java
	public void saveGame(File gameFile) {
		//loadLevel(LevelModel level)
	}
	
	//GAME AUTHORING
	
	public Integer addObjectToLevel(SpriteCharacteristics spriteModel) {
		return currentLevel.addObject(spriteModel);
	}
	
	public boolean updateObject(Integer modelID, SpriteCharacteristics spriteModel) {
		return currentLevel.updateObject(modelID, spriteModel);
	}
	
	public boolean deleteObject(Integer modelID) {
		return currentLevel.deleteObject(modelID);
	}
	
	public void setProgramPhysicEngine(int engineIndex) {
		setPhysicsEngine(PhysicsEngineList.getProgramPhysicEngine(engineIndex));
	}
	
	public List<String> getProgramPhysicsEngineList() {
		return PhysicsEngineList.getProgramPhysicEngineList();
	}
	
	//TODO: Ask front end ppl what the params they want are
	public void setProgramPhysicEngineUsingParams() {
		//setPhysicsEngine(PhysicsEngineList.physicEngineFromParams(foo, bar));
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
		currentLevel.setPhysicsEngine(newEngine);
	}
}
