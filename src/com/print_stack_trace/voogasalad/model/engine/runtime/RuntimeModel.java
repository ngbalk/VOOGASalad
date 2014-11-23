/**
 * @author Pranava Raparla
 * @author Zachary Podbela
 * Date Created: 11/10/14
 * Date Modified: 11/22/14
 */

package com.print_stack_trace.voogasalad.model.engine.runtime;

import java.util.ArrayList;
import java.util.Collection;

import com.print_stack_trace.voogasalad.model.engine.authoring.LevelModel;
import com.print_stack_trace.voogasalad.model.environment.Goal;

public class RuntimeModel {

	//-------------------VARIABLES-------------------//

	public Collection<RuntimeSpriteCharacteristics> runtimeSprites;
	//public Map<Integer, AnimationEffects> animationEffects
	public Collection<Goal> goalMap;

	//-------------------CONSTRUCTORS-------------------//
	
	/**
	 * Constructor that takes in a level as a parameter and populates the runtime data
	 * @param level
	 */
	public RuntimeModel(LevelModel level) {
		runtimeSprites = new ArrayList<RuntimeSpriteCharacteristics>();
		for(Integer i: level.getSpriteMap().keySet())
			runtimeSprites.add(new RuntimeSpriteCharacteristics(level.getSpriteMap().get(i)));
		//animationEffects = level.animationEffects;
		goalMap = level.getGoalMap().values();
	}
	
	//-------------------ACCESSORS-------------------//
	
	/**
	 * Return the sprite map of integer IDs to sprite characteristics
	 * @return spriteMap
	 */
	public Collection<RuntimeSpriteCharacteristics> getSprites() {
		return runtimeSprites;
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
	public Collection<Goal> getGoalMap() {
		//consider returning a string instead of the entire goal
		return goalMap;
	}
	
}
