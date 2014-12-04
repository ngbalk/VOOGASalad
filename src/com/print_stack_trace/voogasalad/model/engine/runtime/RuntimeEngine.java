/**
 * @author Pranava Raparla
 * Date Created: 11/10/14
 * Date Modified: 11/21/14
 */

package com.print_stack_trace.voogasalad.model.engine.runtime;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.input.KeyEvent;

import com.print_stack_trace.voogasalad.model.engine.authoring.LevelModel;
import com.print_stack_trace.voogasalad.model.engine.physics.PhysicsEngine;
import com.print_stack_trace.voogasalad.model.engine.runtime.keyboard.KeyApplicator;
import com.print_stack_trace.voogasalad.model.engine.runtime.keyboard.KeyApplicatorFacotry;
import com.print_stack_trace.voogasalad.model.engine.runtime.keyboard.KeyApplicatorFacotry.KeyResult;
import com.print_stack_trace.voogasalad.model.environment.Goal;

public class RuntimeEngine extends AbstractRuntimeEngine {
	private PhysicsEngine physicsEngine;
	private RuntimeModel runtimeModel;
	private List<KeyEvent> currentEvents = new ArrayList<KeyEvent>();
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
	 * Update all of the data in the current level.
	 * 1. Calls PhysicsEngine to "animate" sprites.
	 * 2. Apply unexpired key events.
	 * 3. Use GoalChecker to check goals
	 * 4. See if game is over or not
	 * @param currentLevel
	 */
	public void update() {
		physicsEngine.animateAll(runtimeModel, framesPerSecond);
		
		applyCurrentKeyEvents();
		
		GoalChecker goalChecker = new GoalChecker(runtimeModel);
		int completedCount = 0;
		for(Goal g : runtimeModel.getGoalMap().values()) {
			g.acceptChecker(goalChecker);
			if(g.isCompleted) completedCount++;
		}
		int reqGoals = runtimeModel.getLevelCharacteristics().requiredNumberOfGoals;
		if (reqGoals > 0) {
			if(completedCount >= runtimeModel.getLevelCharacteristics().requiredNumberOfGoals) {
				runtimeModel.gameOver = true;
				runtimeModel.gameVictory = true;
			}
		}
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
		currentEvents.remove(event);
	}
	
	public void handleKeyPress(KeyEvent event) {
		currentEvents.add(event);
	}
	
	//-------------------ACCESSORS-------------------//
	
	
	//-------------------PRIVATE METHODS-------------------//
	
	private void applyCurrentKeyEvents() {
		for(KeyEvent e : currentEvents) {
			KeyResult res = runtimeModel.getResultOfKey(e.getCode());
			KeyApplicator applicator = KeyApplicatorFacotry.buildKeyApplicator(res);
			Integer mainChar = runtimeModel.getMainCharacter();
			RuntimeSpriteCharacteristics mainCharData = runtimeModel.getRuntimeSpriteMap().get(mainChar);
			applicator.applyActionToRuntimeSprite(mainCharData);
		}
	}
	
}
