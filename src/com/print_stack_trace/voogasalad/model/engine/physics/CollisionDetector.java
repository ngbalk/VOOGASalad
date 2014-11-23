/**
 * @author Justin Carrao
 * @author Zachary Podbela
 * @author Pranava Raparla
 * Date Created: 11/15/14
 * Date Modified: 11/23/14
 */
package com.print_stack_trace.voogasalad.model.engine.physics;

import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeSpriteCharacteristics;

public class CollisionDetector {
	
	/**
	 * Take in two sprite characteristics, spriteA and spriteB, and determine if a collision happened
	 * @param spriteA
	 * @param spriteB
	 * @return true if a collision happened, false otherwise
	 */
	public static boolean haveCollided(RuntimeSpriteCharacteristics spriteA, RuntimeSpriteCharacteristics spriteB) {
		if(spriteA.interactive && spriteB.interactive) {
			//TODO: !!!
			return false;
		} else {
			return false;
		}
	}
}
