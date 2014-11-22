/**
 * @author Pranava Raparla
 * Date Created: 11/10/14
 * Date Modified: 11/21/14
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

	public Map<Integer, SpriteCharacteristics> spriteMap;
	//public Map<Integer, AnimationEffects> animationEffects
	public GoalCharacteristics goalCharacteristics;

	//-------------------CONSTRUCTORS-------------------//

	/**
	 * Constructor for generic RuntimeModel
	 */
	public RuntimeModel() {
		spriteMap = new HashMap<Integer, SpriteCharacteristics>();
		//animationEffects = new HashMap<Integer, AnimationEffects>();
		goalCharacteristics = null;
	}
	
	/**
	 * Constructor that takes in a level as a parameter and populates the runtime data
	 * @param level
	 */
	public RuntimeModel(LevelModel level) {
		this();
		spriteMap = level.spriteMap;
		//animationEffects = level.animationEffects;
		goalCharacteristics = level.getGoal();
	}
	
	//-------------------ACCESSORS-------------------//
	
	/**
	 * Return the sprite map of integer IDs to sprite characteristics
	 * @return spriteMap
	 */
	public Map<Integer, SpriteCharacteristics> getSpriteMap() {
		return spriteMap;
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
	public GoalCharacteristics getGoal() {
		//consider returning a string instead of the entire goal
		return goalCharacteristics;
	}
	
}
