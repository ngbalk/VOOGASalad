/**
 * @author Pranava Raparla
 * Date Created: 11/10/14
 * Date Modified: 11/22/14
 */

package com.print_stack_trace.voogasalad.model.engine.runtime;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeSpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.authoring.LevelModel;
import com.print_stack_trace.voogasalad.model.environment.Goal;

public class RuntimeModel extends LevelModel {

	//-------------------VARIABLES-------------------//

	private Map<Integer, RuntimeSpriteCharacteristics> runtimeSpriteMap;
	private Map<Integer,Goal> goalMap;
	public int currentPoints;
	public Date currentTime;
	public boolean gameOver = false;
	public boolean gameVictory = false;

	//-------------------CONSTRUCTORS-------------------//
	
	/**
	 * Constructor that takes in a level as a parameter and populates the runtime data
	 * @param level
	 */
	public RuntimeModel(LevelModel level) {
		super(level);
		runtimeSpriteMap = new HashMap<Integer, RuntimeSpriteCharacteristics>();
		for(Integer i: level.getSpriteMap().keySet())
			runtimeSpriteMap.put(i, new RuntimeSpriteCharacteristics(level.getSpriteMap().get(i)));
		//animationEffects = level.animationEffects;
		goalMap = level.getGoalMap();
		currentPoints = 0;
		currentTime = new Date();
	}
	
	//-------------------ACCESSORS-------------------//
	
	/**
	 * Return the sprite map of integer IDs to sprite characteristics
	 * @return spriteMap
	 */
	public Map<Integer, RuntimeSpriteCharacteristics> getRuntimeSpriteMap() {
		return runtimeSpriteMap;
	}
	
	/**
	 * Return the goal associated with a given level
	 * @return goal
	 */
	public Map<Integer,Goal> getGoalMap() {
		//consider returning a string instead of the entire goal
		return goalMap;
	}
	
}
