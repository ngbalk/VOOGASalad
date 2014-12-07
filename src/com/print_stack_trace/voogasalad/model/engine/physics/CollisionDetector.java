/**
 * @author Justin Carrao
 * @author Zachary Podbela
 * @author Pranava Raparla
 * Date Created: 11/15/14
 * Date Modified: 11/23/14
 */
package com.print_stack_trace.voogasalad.model.engine.physics;

import java.awt.Rectangle;

import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;
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

	public static boolean haveCollidedFromTop(RuntimeSpriteCharacteristics hero,
			RuntimeSpriteCharacteristics block){
		if(!hero.objectType.equals(SpriteType.HERO)) return false;
		Rectangle top = new Rectangle((int) hero.p.getX(), (int) hero.p.getY(), (int) hero.getWidth(), (int) hero.getHeight());
		Rectangle bottom = new Rectangle((int) block.p.getX(), (int) block.p.getY(), (int) block.getWidth(), (int) block.getHeight());
		Rectangle intersect = top.intersection(bottom); 
		
		hero.isCollidingHorizontally = false;
		hero.isCollidingVertically = true;
		
		return(top.getY() < intersect.getY() && intersect.getWidth() > intersect.getHeight());
	}

	public static boolean haveCollidedFromBottom(RuntimeSpriteCharacteristics hero,
			RuntimeSpriteCharacteristics block){
		if(!hero.objectType.equals(SpriteType.HERO)) return false;
		Rectangle bottom = new Rectangle((int) hero.p.getX(), (int) hero.p.getY(), (int) hero.getWidth(), (int) hero.getHeight());
		Rectangle top = new Rectangle((int) block.p.getX(), (int) block.p.getY(), (int) block.getWidth(), (int) block.getHeight());
		Rectangle intersect = top.intersection(bottom);        
		
		hero.isCollidingHorizontally = false;
		hero.isCollidingVertically = true;

		
		return(bottom.getY() < intersect.getY() + intersect.getHeight() && intersect.getWidth() > intersect.getHeight());
	}
	
	public static boolean haveCollidedFromLeft(RuntimeSpriteCharacteristics hero,
			RuntimeSpriteCharacteristics block){
		if(!hero.objectType.equals(SpriteType.HERO)) return false;
		Rectangle left = new Rectangle((int) hero.p.getX(), (int) hero.p.getY(), (int) hero.getWidth(), (int) hero.getHeight());
		Rectangle right = new Rectangle((int) block.p.getX(), (int) block.p.getY(), (int) block.getWidth(), (int) block.getHeight());
		Rectangle intersect = left.intersection(right);  
		hero.isCollidingHorizontally = true;
		hero.isCollidingVertically = false;

		return(left.getX() < intersect.getX() && intersect.getHeight() > intersect.getWidth());
	}
	
	public static boolean haveCollidedFromRight(RuntimeSpriteCharacteristics hero,
			RuntimeSpriteCharacteristics block){
		if(!hero.objectType.equals(SpriteType.HERO)) return false;
		Rectangle right = new Rectangle((int) hero.p.getX(), (int) hero.p.getY(), (int) hero.getWidth(), (int) hero.getHeight());
		Rectangle left = new Rectangle((int) block.p.getX(), (int) block.p.getY(), (int) block.getWidth(), (int) block.getHeight());
		Rectangle intersect = left.intersection(right);       
		hero.isCollidingHorizontally = true;
		hero.isCollidingVertically = false;
		
		return(right.getX() > intersect.getX() && intersect.getHeight() > intersect.getWidth());
	}
	
}
