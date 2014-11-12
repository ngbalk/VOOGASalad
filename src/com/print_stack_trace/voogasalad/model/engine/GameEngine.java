package com.print_stack_trace.voogasalad.model.engine;

import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.util.Map;

import com.print_stack_trace.voogasalad.model.LevelModel;
import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeModel;

public class GameEngine {
	private LevelModel currentLevel;
	
	//-------------------CONSTRUCTORS-------------------//
	
	/**
	 * Constructor Method.
	 */
	public GameEngine() {
		//TODO: Implement Constructor
	}
	
	//-------------------PUBLIC METHODS-------------------//
	
	//TODO: @data This should mirror public on GameData.java
	public boolean loadGame(File gameFile) {
		return true;
	}
	
	//TODO: @data This should mirror public on GameData.java
	public boolean saveGame(File gameFile) {
		return false;
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
	
	//GAME PLAYER
	
	public void update() {
		//TODOL Call RuntimeEngine
	}
	
	public RuntimeModel getStatus() {
		RuntimeModel ret = new RuntimeModel();
		/*TODO: Implement -- this is looks like an accessor to everyone else but
		 *a RuntimeModel should be created at the time it is called and built 
		 *from all of the various at time of call. */
		return ret;
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
		//TODO: Implement -- Will be used for setLevel but also reseting level.
	}
}
