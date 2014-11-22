/**
 * @author Pranava Raparla
 * Date Created: 11/10/14
 * Date Modified: 11/22/14
 */

package com.print_stack_trace.voogasalad.model.engine.runtime;

import java.util.HashMap;
import java.util.Map;

import com.print_stack_trace.voogasalad.model.GoalCharacteristics;
import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.authoring.LevelModel;
import com.print_stack_trace.voogasalad.model.environment.Goal;

public class RuntimeModel {

	//-------------------VARIABLES-------------------//

	public Map<Integer, RuntimeSprite> runtimeSpriteMap;
	//public Map<Integer, AnimationEffects> animationEffects
	public Map<Integer,Goal> goalMap;

	//-------------------CONSTRUCTORS-------------------//

	/**
	 * Constructor for generic RuntimeModel
	 */
	public RuntimeModel() {
		runtimeSpriteMap = new HashMap<Integer, RuntimeSprite>();
		//animationEffects = new HashMap<Integer, AnimationEffects>();
		goalMap = new HashMap<>();
	}
	
	/**
	 * Constructor that takes in a level as a parameter and populates the runtime data
	 * @param level
	 */
	public RuntimeModel(LevelModel level) {
		this();
		for(Integer i: level.getSpriteMap().keySet())
			runtimeSpriteMap.put(i, new RuntimeSprite(level.getSpriteMap().get(i)));
		//animationEffects = level.animationEffects;
		goalMap = level.getGoalMap();
	}
	
	//-------------------ACCESSORS-------------------//
	
	/**
	 * Return the sprite map of integer IDs to sprite characteristics
	 * @return spriteMap
	 */
	public Map<Integer, RuntimeSprite> getSpriteMap() {
		return runtimeSpriteMap;
	}
	
	/**
	 * Return the animationEffects associated with each SpriteCharacteristics
	 * @return animationEffects
	 */
	//TODO: Create AnimationEffects class (if necessary?) and then uncomment this
	/*public Map<Integer, AnimationEffects> getAnimations() {
		return animationEffects;
	}*/
	
	/**
	 * Return the goal associated with a given level
	 * @return goal
	 */
	public Map<Integer,Goal> getGoalMap() {
		//consider returning a string instead of the entire goal
		return goalMap;
	}
	
}
