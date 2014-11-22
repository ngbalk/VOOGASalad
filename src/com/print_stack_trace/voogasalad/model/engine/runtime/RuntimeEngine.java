/**
 * @author Pranava Raparla
 * Date Created: 11/10/14
 * Date Modified: 11/21/14
 */

package com.print_stack_trace.voogasalad.model.engine.runtime;

import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.util.Map;

import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.authoring.LevelModel;
import com.print_stack_trace.voogasalad.model.engine.physics.PhysicsEngine;

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
	 * Update all of the data in the current level. Calls PhysicsEngine
	 * to "animate" sprites and other objects by "moving" sprites and
	 * handling collisions. Nothing is returned.
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
	 * @return runtimeModel 
	 */
	public RuntimeModel getStatus() {
		//TODO: update this...very bare bones
		RuntimeModel runtimeModel = new RuntimeModel(currentLevel);
		return runtimeModel;
	}
	
	
	//-------------------ACCESSORS-------------------//
	
	
	//-------------------PRIVATE METHODS-------------------//
	
}
