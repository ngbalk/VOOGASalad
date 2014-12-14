/**
 * @author Justin Carrao
 * @author Pranava Raparla
 * Date Created: 11/21/14
 * Date Modified: 11/23/14
 */

package com.print_stack_trace.voogasalad.model.engine.physics;

import java.util.ArrayList;

import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeModel;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeSpriteCharacteristics;

public class CollisionHandlerTest extends CollisionHandler {

	//-------------------PUBLIC METHODS-------------------//
	
	@Override
	public void applyCollisionEffects(RuntimeSpriteCharacteristics s1,
			RuntimeSpriteCharacteristics s2, RuntimeModel currentRuntime) {
		// TODO Auto-generated method stub
		
	}


	//-------------------PRIVATE METHODS-------------------//
	
	private boolean boundsOverlap(SpriteCharacteristics s1, SpriteCharacteristics s2) {
		
		double s1XPos = getXPos(s1);
		double s1YPos = getYPos(s1);
		double s2XPos = getXPos(s2);
		double s2YPos = s2.getY();
		
		/*double xGapTolerance = (s1.img.getWidth()/2) + (s2.img.getWidth()/2);
		double yGapTolerance = (s1.img.getHeight()/2) + (s2.img.getHeight()/2);
		
		return (distanceBetween(s1XPos, s2XPos) < xGapTolerance && distanceBetween(s1YPos, s2YPos) < yGapTolerance);
		*/
		return false;
	}
	
	private double distanceBetween(double a, double b) {
		return Math.abs(a-b); 
	}
	
	private double getXPos(SpriteCharacteristics s) {
		return s.getX();
	}
	private double getYPos(SpriteCharacteristics s) {
		return s.getY();
	}


    @Override
    public boolean shouldStick (RuntimeSpriteCharacteristics s1, RuntimeSpriteCharacteristics s2) {
        return true;
    }



}
