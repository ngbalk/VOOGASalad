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
            Rectangle rect1 = new Rectangle((int) spriteA.p.getX(), (int) spriteA.p.getY(), (int) spriteA.getWidth(), (int) spriteA.getHeight());
            Rectangle rect2 = new Rectangle((int) spriteB.p.getX(), (int) spriteB.p.getY(), (int) spriteB.getWidth(), (int) spriteB.getHeight());
            return rect1.intersects(rect2);
        }
        
        public static boolean haveCollidedHorizontally(RuntimeSpriteCharacteristics spriteA, RuntimeSpriteCharacteristics spriteB){
            Rectangle rect1 = new Rectangle((int) spriteA.p.getX(), (int) spriteA.p.getY(), (int) spriteA.getWidth(), (int) spriteA.getHeight());
            Rectangle rect2 = new Rectangle((int) spriteB.p.getX(), (int) spriteB.p.getY(), (int) spriteB.getWidth(), (int) spriteB.getHeight());
            Rectangle rect3 = rect1.intersection(rect2);
            return rect3.getHeight() > rect3.getWidth();
        }
        
        public static boolean haveCollidedVertically(RuntimeSpriteCharacteristics spriteA, RuntimeSpriteCharacteristics spriteB){
            Rectangle rect1 = new Rectangle((int) spriteA.p.getX(), (int) spriteA.p.getY(), (int) spriteA.getWidth(), (int) spriteA.getHeight());
            Rectangle rect2 = new Rectangle((int) spriteB.p.getX(), (int) spriteB.p.getY(), (int) spriteB.getWidth(), (int) spriteB.getHeight());
            Rectangle rect3 = rect1.intersection(rect2);
            return rect3.getWidth() >= rect3.getHeight();
        }
        
}
