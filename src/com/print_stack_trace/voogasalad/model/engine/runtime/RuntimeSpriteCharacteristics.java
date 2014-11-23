/**
 * @author Pranava Raparla
 * Date Created: 11/22/14
 * Date Modified: 11/22/14
 */

package com.print_stack_trace.voogasalad.model.engine.runtime;

import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;

public class RuntimeSpriteCharacteristics extends SpriteCharacteristics {
	public int v_x;
	public int v_y;
	public int decelerationConstant;
	private float alpha;
	
	public RuntimeSpriteCharacteristics(SpriteType t) {
		super(t);
		
	}
	
	public RuntimeSpriteCharacteristics(SpriteCharacteristics obj) {
		super(obj);
	}

	public float getAlpha() {
		return alpha;
	}

	public void setAlpha(float alpha) {
		if(alpha < 0.0f) { this.alpha = 0.0f; }
		else if(alpha > 1.0f) { this.alpha = 1.0f; }
		else this.alpha = alpha;
	}	
}