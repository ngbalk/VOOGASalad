/**
 * @author Justin Carrao
 * @author Zachary Podbela
 * @author Pranava Raparla
 * Date Created: 11/21/14
 * Date Modified: 11/21/14
 */

package com.print_stack_trace.voogasalad.model.engine.physics;

import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;

public interface CollisionHandler {
	
	/**
	 * Determine if two "sprites" (SpriteCharacteristics) have collided.
	 * @param s1	the first "sprite" to check for collision
	 * @param s2	the second "sprite" to check for collision
	 * @return		whether two "sprites" have collided
	 */
	public boolean haveCollided(SpriteCharacteristics s1, SpriteCharacteristics s2);
	
	/**
	 * Called when sprites have collided.
	 * Apply the appropriate collision effects based on data from each sprite.
	 * @param s1	the first "sprite" to have collision effects applied
	 * @param s2	the second "sprite" to have collision effects applied
	 */
	public void applyCollisionEffects(SpriteCharacteristics s1, SpriteCharacteristics s2);
}