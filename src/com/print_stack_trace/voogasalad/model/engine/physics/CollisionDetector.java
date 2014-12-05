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
			//TODO: @ethan&nick
			if (intersection(spriteA, spriteB)) {
				return true;
			}
			return false;
		} else {
			return false;
		}
	}
	
	public static double getDistance(double value1, double value2) {
		double difference = Math.abs(value1-value2);
		return difference;
	}
	
	public static boolean intersection(RuntimeSpriteCharacteristics spriteA, RuntimeSpriteCharacteristics spriteB) {
		double xBoundsA = spriteA.width/2;
		double xBoundsB = spriteB.width/2;
		double xTolerance = xBoundsA + xBoundsB;
		double yBoundsA = spriteA.height/2;
		double yBoundsB = spriteB.height/2;
		double yTolerance = yBoundsA + yBoundsB;
		if (getDistance(spriteA.getX(), spriteB.getX()) < xTolerance 
				&& getDistance(spriteA.getY(), spriteB.getY()) < yTolerance) {
			return true;
		}
		return false;
	}
	
	
	
}
