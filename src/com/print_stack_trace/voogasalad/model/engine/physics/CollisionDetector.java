/**
 * @author Justin Carrao
 * @author Zachary Podbela
 * @author Pranava Raparla
 * Date Created: 11/15/14
 * Date Modified: 11/23/14
 */
package com.print_stack_trace.voogasalad.model.engine.physics;

import java.awt.Rectangle;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeSpriteCharacteristics;

public class CollisionDetector {
	
	/**
	 * Take in two sprite characteristics, spriteA and spriteB, and determine if a collision happened
	 * @param spriteA
	 * @param spriteB
	 * @return true if a collision happened, false otherwise
	 */
	public static boolean haveCollided(RuntimeSpriteCharacteristics spriteA, RuntimeSpriteCharacteristics spriteB) {
            Rectangle rect1 = new Rectangle((int) spriteA.getX(), (int) spriteA.getY(), (int) spriteA.getWidth(), (int) spriteA.getHeight());
            Rectangle rect2 = new Rectangle((int) spriteB.getX(), (int) spriteB.getY(), (int) spriteB.getWidth(), (int) spriteB.getHeight());
            return rect1.intersects(rect2);
	}
	
}
