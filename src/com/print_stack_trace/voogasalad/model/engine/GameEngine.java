package com.print_stack_trace.voogasalad.model.engine;

import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.util.Map;

import com.print_stack_trace.voogasalad.model.LevelModel;
import com.print_stack_trace.voogasalad.model.RuntimeModel;
import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;

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
	
	Integer addObjectToLevel(SpriteCharacteristics spriteModel) {
		//TODO: This should mirror public on LevelModel.java
		return null;
	}
	
	Integer updateObject(Integer modelID, SpriteCharacteristics spriteModel) {
		//TODO: This should mirror public on LevelModel.java
		return null;
	}
	
	boolean deleteObject(Integer modelID) {
		//TODO: This should mirror public on LevelModel.java
		return false;
	}
	
	//GAME PLAYER
	
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
