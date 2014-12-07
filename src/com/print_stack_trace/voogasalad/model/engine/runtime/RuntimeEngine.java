/**
 * @author Pranava Raparla
 * Date Created: 11/10/14
 * Date Modified: 11/21/14
 */

package com.print_stack_trace.voogasalad.model.engine.runtime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.scene.input.KeyEvent;

import com.print_stack_trace.voogasalad.model.engine.authoring.LevelModel;
import com.print_stack_trace.voogasalad.model.engine.physics.PhysicsEngine;
import com.print_stack_trace.voogasalad.model.engine.runtime.keyboard.KeyApplicationChecker;
import com.print_stack_trace.voogasalad.model.engine.runtime.keyboard.KeyApplicator;
import com.print_stack_trace.voogasalad.model.engine.runtime.keyboard.KeyApplicatorFactory;
import com.print_stack_trace.voogasalad.model.engine.runtime.keyboard.KeyApplicatorFactory.KeyResult;
import com.print_stack_trace.voogasalad.model.environment.Goal;

public class RuntimeEngine extends AbstractRuntimeEngine {
	private PhysicsEngine physicsEngine;
	private RuntimeModel runtimeModel;
	int framesPerSecond;
	private Map<KeyResult, KeyApplicator> applicatorCache = new HashMap<KeyResult, KeyApplicator>();

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

		GoalChecker goalChecker = new GoalChecker(runtimeModel);
		int completedCount = 0;
		for(Goal g : runtimeModel.getGoalMap().values()) {
			g.acceptChecker(goalChecker);
			if(g.isCompleted)completedCount++;
		}
		int reqGoals = runtimeModel.getLevelCharacteristics().requiredNumberOfGoals;
		if (reqGoals > 0) {
			if(completedCount >= runtimeModel.getLevelCharacteristics().requiredNumberOfGoals) {
				runtimeModel.gameOver = true;
				runtimeModel.gameVictory = true;
			}
		}

		updateSpritePositions();
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
		handleKey(event, false);
	}

	public void handleKeyPress(KeyEvent event) {
		handleKey(event, true);
	}

	//-------------------ACCESSORS-------------------//


	//-------------------PRIVATE METHODS-------------------//

	//Sprites move around even when this method is commented out
	//why is that? this method should be the one controlling movement
	private void updateSpritePositions(){
		for(RuntimeSpriteCharacteristics rst : runtimeModel.getRuntimeSpriteMap().values()) {
			rst.setX(rst.getX()+((double)rst.v_x/(double)framesPerSecond));
			rst.setY(rst.getY()+((double)rst.v_y/(double)framesPerSecond));
			rst.v_x *= (1.0f-rst.getDecelerationConstant());
			rst.v_y *= (1.0f-rst.getDecelerationConstant());
		}
	}

	private void handleKey(KeyEvent event, boolean press) {
		KeyResult res = runtimeModel.getResultOfKey(event.getCode());
		KeyApplicator applicator = applicatorCache.get(res);
		Integer mainChar = runtimeModel.getMainCharacter();
		RuntimeSpriteCharacteristics mainCharData = runtimeModel.getRuntimeSpriteMap().get(mainChar);
		if(applicator == null) {
			applicator = KeyApplicatorFactory.buildKeyApplicator(res);
			applicatorCache.put(res, applicator);
		}
		if(press && KeyApplicationChecker.doesKeyApply(res, mainCharData)) {
			applicator.applyPressActionToRuntimeSprite(mainCharData);
		}
		else{
			applicator.applyReleaseActionToRuntimeSprite(mainCharData);
			return;
		}
	}
}
