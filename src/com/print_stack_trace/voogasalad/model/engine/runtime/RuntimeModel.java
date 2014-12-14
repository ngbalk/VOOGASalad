/**
 * @author Pranava Raparla
 * Date Created: 11/10/14
 * Date Modified: 11/22/14
 */

package com.print_stack_trace.voogasalad.model.engine.runtime;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.print_stack_trace.voogasalad.model.GoalCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeSpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.authoring.LevelModel;
import com.print_stack_trace.voogasalad.model.environment.Goal;

/**
 * This RuntimeModel class extends LevelModel to separate authoring
 * data from runtime data. Since data set in the authoring environment
 * must be accessed in runtime, this class extends LevelModel. This
 * class is updated in the RuntimeEngine and used by the GamePlayer
 * front end for visualization.
 * @author Pranava Raparla
 *
 */
public class RuntimeModel extends LevelModel {

	//-------------------VARIABLES-------------------//

	private Map<Integer, RuntimeSpriteCharacteristics> runtimeSpriteMap;
	private Map<Integer,GoalCharacteristics> goalMap;
	public int currentPoints;
	public Date currentTime;
	public boolean gameOver = false;
	public boolean gameVictory = false;
	public Point camera;
	public int width;
	public int height;
	public Integer mainChar;
	public Dimension viewport;
	public boolean gameTotallyOver;

	//-------------------CONSTRUCTORS-------------------//
	
	/**
	 * Constructor that takes in a level as a parameter and populates the runtime data
	 * @param level
	 */
	public RuntimeModel(LevelModel level, Dimension viewport) {
		super(level);
		runtimeSpriteMap = new HashMap<Integer, RuntimeSpriteCharacteristics>();
		for(Integer i: level.getSpriteMap().keySet()){
			runtimeSpriteMap.put(i, new RuntimeSpriteCharacteristics(level.getSpriteMap().get(i)));
		}
		//animationEffects = level.animationEffects;
		goalMap = level.getGoalMap();
		currentPoints = 0;
		currentTime = new Date();
		camera = level.getLevelCharacteristics().getCameraStart();
		this.viewport = viewport;
		mainChar = level.getMainCharacter();
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
	public Map<Integer,GoalCharacteristics> getGoalMap() {
		//consider returning a string instead of the entire goal
		return goalMap;
	}

}
