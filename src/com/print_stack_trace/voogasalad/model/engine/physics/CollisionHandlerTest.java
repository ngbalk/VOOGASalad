/**
 * @author Justin Carrao
 * @author Pranava Raparla
 * Date Created: 11/21/14
 * Date Modified: 11/21/14
 */

package com.print_stack_trace.voogasalad.model.engine.physics;

import java.util.ArrayList;

import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;

public class CollisionHandlerTest implements CollisionHandler {

	//-------------------PUBLIC METHODS-------------------//

	@Override
	public boolean haveCollided(SpriteCharacteristics s1,
			SpriteCharacteristics s2) {
		// TODO Auto-generated method stub
		return boundsOverlap(s1, s2);
		
	}

	@Override
	public void applyCollisionEffects(SpriteCharacteristics s1,
			SpriteCharacteristics s2) {
		// TODO Auto-generated method stub
		
	}

	//-------------------PRIVATE METHODS-------------------//
	
	private boolean boundsOverlap(SpriteCharacteristics s1, SpriteCharacteristics s2) {
		
		double s1XPos = getXPos(s1);
		double s1YPos = getYPos(s1);
		double s2XPos = getXPos(s2);
		double s2YPos = s2.p.getY();
		
		double xGapTolerance = (s1.img.getWidth()/2) + (s2.img.getWidth()/2);
		double yGapTolerance = (s1.img.getHeight()/2) + (s2.img.getHeight()/2);
		
		return (distanceBetween(s1XPos, s2XPos) < xGapTolerance && distanceBetween(s1YPos, s2YPos) < yGapTolerance);
		
	}
	
	private double distanceBetween(double a, double b) {
		return Math.abs(a-b); 
	}
	
	private double getXPos(SpriteCharacteristics s) {
		return s.p.getX();
	}
	private double getYPos(SpriteCharacteristics s) {
		return s.p.getY();
	}

}
