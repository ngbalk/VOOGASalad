/**
 * @author Pranava Raparla
 * Date Created: 11/22/14
 * Date Modified: 11/22/14
 */

package com.print_stack_trace.voogasalad.model.engine.runtime;

import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;
import com.print_stack_trace.voogasalad.model.engine.runtime.keyboard.KeyApplicatorFactory.KeyResult;

public class RuntimeSpriteCharacteristics extends SpriteCharacteristics {
	public float v_x;
	public float v_y;
	public boolean isColliding = false;
	public boolean isCollidingHorizontally = false;
	public boolean isCollidingVertically = false;
	public boolean canMultipleJump = false;
	private float decelerationConstant;
	public KeyResult currentSpriteAction;
	
	public int health;
	private boolean remove = false;
	private float alpha = 1.0f;
	
	public RuntimeSpriteCharacteristics(SpriteType t) {
		super(t);
		
	}
	
	public RuntimeSpriteCharacteristics(SpriteCharacteristics obj) {
		super(obj);
		health = startingHealth;
	}

	public float getAlpha() {
		return alpha;
	}

	public void setAlpha(float alpha) {
		if(alpha < 0.0f) { this.alpha = 0.0f; }
		else if(alpha > 1.0f) { this.alpha = 1.0f; }
		else this.alpha = alpha;
	}
	
	public float getDecelerationConstant() {
		return decelerationConstant;
	}

	public void setDecelerationConstant(float decelerationConstant) {
		if(decelerationConstant < 0.0f) { this.decelerationConstant = 0.0f; }
		else if(decelerationConstant > 1.0f) { this.decelerationConstant = 1.0f; }
		else this.decelerationConstant = decelerationConstant;
	}

	public boolean shouldBeRemoved() {
		return remove;
	}

	public void flagForRemoval() {
		this.remove = true;
	}	
	
	public KeyResult getCurrentAnimation() {
		return currentSpriteAction;
	}
	
	public void setPossibleSpriteAction(KeyResult spriteAction) {
		currentSpriteAction = spriteAction;
		//TODO: implement this on back end.
	}

}