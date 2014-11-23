/**
 * @author Pranava Raparla
 * Date Created: 11/10/14
 * Date Modified: 11/21/14
 */

package com.print_stack_trace.voogasalad.model.engine.runtime;

import javafx.scene.input.KeyEvent;

import com.print_stack_trace.voogasalad.model.engine.authoring.LevelModel;
import com.print_stack_trace.voogasalad.model.engine.physics.PhysicsEngine;

public class RuntimeEngine extends AbstractRuntimeEngine {
	private PhysicsEngine physicsEngine;
	private RuntimeModel runtimeModel;
	int framesPerSecond;
	
	//-------------------CONSTRUCTORS-------------------//
	
	/**
	 * Takes in a LevelModel and sets private variables
	 * @param level
	 */
	public RuntimeEngine(LevelModel currentLevel) {
		super(currentLevel);
		runtimeModel = new RuntimeModel(currentLevel);
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
		//TODO: @zacharyPodbela Finish implementation
		physicsEngine.animateAll(runtimeModel.getSpriteMap().values(), framesPerSecond);
	}
	
	public void setFramesPerSecond(int framesPerSecond) {
		this.framesPerSecond = framesPerSecond;
	}
	
	//GAME PLAYER
	
	/**
	 * Get the current state of the level in progress
	 * @return runtimeModel 
	 */
	public RuntimeModel getStatus() {
		return runtimeModel;
	}
	
	public void handleKeyRelease(KeyEvent event) {
		
	}
	
	public void handleKeyPress(KeyEvent event) {
		
	}
	
	//-------------------ACCESSORS-------------------//
	
	
	//-------------------PRIVATE METHODS-------------------//
	
}
