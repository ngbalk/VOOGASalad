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
	    if(spriteA== null || spriteB==null) { //why does this work
	                return false;
	          }
	    Rectangle rect1 = new Rectangle((int) spriteA.getX(), (int) spriteA.getY(), (int) spriteA.getWidth(), (int) spriteA.getHeight());
		Rectangle rect2 = new Rectangle((int) spriteB.getX(), (int) spriteB.getY(), (int) spriteB.getWidth(), (int) spriteB.getHeight());
//        System.out.print("Does SpriteA: " + spriteA.getName() + spriteA.getY() + " collide SpriteB: " + spriteB.getY() + spriteB.getHeight()+ "? ");
//		if(rect1.intersects(rect2))
//		    System.out.println("Yes.");
//		else
//		    System.out.println("No.");
        return rect1.intersects(rect2);
	}

	public static boolean haveCollidedHorizontally(RuntimeSpriteCharacteristics spriteA, RuntimeSpriteCharacteristics spriteB){
		Rectangle rect = makeIntersector(spriteA, spriteB);
		return rect.getHeight() > rect.getWidth();
	}

	public static boolean haveCollidedVertically(RuntimeSpriteCharacteristics spriteA, RuntimeSpriteCharacteristics spriteB){

		Rectangle rect = makeIntersector(spriteA, spriteB);
		return rect.getWidth() >= rect.getHeight();
	}

	public static boolean haveCollidedFromTop(RuntimeSpriteCharacteristics hero,
			RuntimeSpriteCharacteristics block){
		if(incorrectSpriteType(hero)) return false;
		Rectangle top = new Rectangle((int) hero.getX(), (int) hero.getY(), (int) hero.getWidth(), (int) hero.getHeight());
		Rectangle bottom = new Rectangle((int) block.getX(), (int) block.getY(), (int) block.getWidth(), (int) block.getHeight());
		Rectangle intersect = top.intersection(bottom); 
		
		setCollidingVertically(hero);
		
		return(top.getY() < intersect.getY() && intersect.getWidth() > intersect.getHeight());
	}

	public static boolean haveCollidedFromBottom(RuntimeSpriteCharacteristics hero,
			RuntimeSpriteCharacteristics block){
		if(incorrectSpriteType(hero)) return false;
		Rectangle bottom = new Rectangle((int) hero.getX(), (int) hero.getY(), (int) hero.getWidth(), (int) hero.getHeight());
		Rectangle top = new Rectangle((int) block.getX(), (int) block.getY(), (int) block.getWidth(), (int) block.getHeight());
		Rectangle intersect = top.intersection(bottom);        
		
		setCollidingVertically(hero);
		
		return(bottom.getY() < intersect.getY() + intersect.getHeight() && intersect.getWidth() > intersect.getHeight());
	}
	
	public static boolean haveCollidedFromLeft(RuntimeSpriteCharacteristics hero,
			RuntimeSpriteCharacteristics block){
		if(incorrectSpriteType(hero)) return false;
		Rectangle left = new Rectangle((int) hero.getX(), (int) hero.getY(), (int) hero.getWidth(), (int) hero.getHeight());
		Rectangle right = new Rectangle((int) block.getX(), (int) block.getY(), (int) block.getWidth(), (int) block.getHeight());
		Rectangle intersect = left.intersection(right);  
		setCollidingHorizontally(hero);

		return(left.getX() < intersect.getX() && intersect.getHeight() > intersect.getWidth());
	}
	
	public static boolean haveCollidedFromRight(RuntimeSpriteCharacteristics hero,
			RuntimeSpriteCharacteristics block){
		if(incorrectSpriteType(hero)) return false;
		Rectangle right = new Rectangle((int) hero.getX(), (int) hero.getY(), (int) hero.getWidth(), (int) hero.getHeight());
		Rectangle left = new Rectangle((int) block.getX(), (int) block.getY(), (int) block.getWidth(), (int) block.getHeight());
		Rectangle intersect = left.intersection(right);
		setCollidingHorizontally(hero);
		
		return(right.getX() >= intersect.getX() && intersect.getHeight() > intersect.getWidth());
	}
	
	public static boolean incorrectSpriteType(RuntimeSpriteCharacteristics hero) {
		return (!(hero.objectType.equals(SpriteType.HERO) || (hero.objectType.equals(SpriteType.ENEMY))));
	}
	
	public static Rectangle makeIntersector(RuntimeSpriteCharacteristics rs1, RuntimeSpriteCharacteristics rs2) {
		Rectangle rect1 = new Rectangle((int) rs1.getX(), (int) rs1.getY(), (int) rs1.getWidth(), (int) rs1.getHeight());
		Rectangle rect2 = new Rectangle((int) rs2.getX(), (int) rs2.getY(), (int) rs2.getWidth(), (int) rs2.getHeight());
		return rect1.intersection(rect2);
	}
	
	public static void setCollidingVertically(RuntimeSpriteCharacteristics hero) {
		hero.isCollidingVertically = true;
		hero.isCollidingHorizontally = false;
	}
	
	public static void setCollidingHorizontally(RuntimeSpriteCharacteristics hero) {
		hero.isCollidingVertically = false;
		hero.isCollidingHorizontally = true;
	}
	
}
