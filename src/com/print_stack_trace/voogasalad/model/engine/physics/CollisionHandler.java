/**
 * @author Justin Carrao
 * @author Zachary Podbela
 * @author Pranava Raparla
 * Date Created: 11/21/14
 * Date Modified: 11/23/14
 */

package com.print_stack_trace.voogasalad.model.engine.physics;

import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeSpriteCharacteristics;

public abstract class CollisionHandler {
		
	/**
	 * Called when sprites have collided.
	 * Apply the appropriate collision effects based on data from each sprite.
	 * @param s1	the first "sprite" to have collision effects applied
	 * @param s2	the second "sprite" to have collision effects applied
	 */
	public abstract void applyCollisionEffects(RuntimeSpriteCharacteristics s1, RuntimeSpriteCharacteristics s2);
}