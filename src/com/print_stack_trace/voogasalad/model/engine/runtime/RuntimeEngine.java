/**
 * @author Pranava Raparla
 * Date Created: 11/10/14
 * Date Modified: 11/11/14
 */

package com.print_stack_trace.voogasalad.model.engine.runtime;

import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.util.Map;

import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.authoring.LevelModel;

public class RuntimeEngine {
	private LevelModel currentLevel;
	private PhysicsEngine physicsEngine;
	
	//-------------------CONSTRUCTORS-------------------//
	
	/**
	 * Blank Constructor Method.
	 */
	public RuntimeEngine() {
		currentLevel = null;
		physicsEngine = null;
	}
	/**
	 * Takes in a LevelModel and sets private variables
	 * @param level
	 */
	public RuntimeEngine(LevelModel level) {
		this();
		currentLevel = level;
		physicsEngine = currentLevel.getPhysicsEngine();
	}
	
	//-------------------PUBLIC METHODS-------------------//
		
	/**
	 * 
	 * @param currentLevel
	 */
	public void update() {
		//TODO: Finish implementation
		physicsEngine.animateAll(currentLevel.spriteMap.values());
	}	
	
	//GAME PLAYER
	
	/**
	 * This is looks like an accessor to everyone else but
	 * a RuntimeModel should be created at the time it is called and built 
	 * from the appropriate LevelModel data at time of call
	 * @return 
	 */
	public RuntimeModel getStatus() {
		//TODO: update this...very bare bones
		RuntimeModel runtimeModel = new RuntimeModel(currentLevel);
		return runtimeModel;
	}
	
	
	//-------------------ACCESSORS-------------------//
	
	
	//-------------------PRIVATE METHODS-------------------//
	
}
