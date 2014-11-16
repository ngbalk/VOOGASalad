/**
 * @author Pranava Raparla
 * Date Created: 11/10/14
 * Date Modified: 11/16/14
 */

package com.print_stack_trace.voogasalad.model.engine.runtime;

import java.util.HashMap;
import java.util.Map;

import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.authoring.LevelModel;
import com.print_stack_trace.voogasalad.model.environment.Goal;

public class RuntimeModel {

	//-------------------VARIABLES-------------------//

	public Map<Integer, SpriteCharacteristics> spriteMap;
	//public Map<Integer, AnimationEffects> animationEffects
	public Goal goal;

	//-------------------CONSTRUCTORS-------------------//

	/**
	 * Constructor for Generic Model
	 */
	public RuntimeModel() {
		spriteMap = new HashMap<Integer, SpriteCharacteristics>();
		//animationEffects = new HashMap<Integer, AnimationEffects>();
		goal = null;
	}
	
	public RuntimeModel(LevelModel level) {
		this();
		spriteMap = level.spriteMap;
		//animationEffects = level.animationEffects;
		goal = level.myGoal;
	}
	
	//-------------------ACCESSORS-------------------//
	
	public Map<Integer, SpriteCharacteristics> getSpriteMap() {
		return spriteMap;
	}
	
	/*public Map<Integer, AnimationEffects> getAnimations() {
		return animationEffects;
	}*/

	public Goal getMyGoal() {
		//consider returning a string instead of the entire goal
		return goal;
	}
	
}
