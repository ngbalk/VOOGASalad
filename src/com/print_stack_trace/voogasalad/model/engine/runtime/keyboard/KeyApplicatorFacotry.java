package com.print_stack_trace.voogasalad.model.engine.runtime.keyboard;

import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeSpriteCharacteristics;

public class KeyApplicatorFacotry {
	
	public static final int V_KEY_CONSTANT = 30;
	public static final int H_KEY_CONSTANT = 10;


	
	public enum KeyResult {
		Left,
		Right,
		Up,
		Down
	};
	
	public static KeyApplicator buildKeyApplicator(KeyResult mykeyResult) {
		//TODO: Actually implement

		final int vxnew;
		final int vynew;
		final int vxreleasenew;
		final int vyreleasenew;
		switch(mykeyResult) {
		case Down:
			vynew = -V_KEY_CONSTANT;
			vxnew = 0;
			vxreleasenew = 0;
			vyreleasenew = 0;
			break;
		case Left:
			vxnew = -H_KEY_CONSTANT;
			vynew = 0;
			vxreleasenew = -vxnew;
			vyreleasenew = -vynew;
			break;
		case Right:
			vxnew = H_KEY_CONSTANT;
			vynew = 0;
			vxreleasenew = -vxnew;
			vyreleasenew = -vynew;
			break;
		case Up:
			vynew = V_KEY_CONSTANT;
			vxnew = 0;
			vxreleasenew = 0;
			vyreleasenew = 0;
			break;
		default:
			vynew = 0;
			vxnew = 0;
			vxreleasenew = 0;
			vyreleasenew = 0;
			break;
		
		}
		return new KeyApplicator() {
		    private boolean once = false;
		    
			@Override
			public void applyPressActionToRuntimeSprite(
					RuntimeSpriteCharacteristics sprite) {
			    if(once) return;
			    once = true;
				sprite.v_x += vxnew;
				sprite.v_y -= vynew;
			
			}

			@Override
			public void applyReleaseActionToRuntimeSprite(
					RuntimeSpriteCharacteristics sprite) {
				if(!once) return;
			    once = false;
				sprite.v_x += vxreleasenew;
				sprite.v_y -= vyreleasenew;
			}
		};
       
    }
}
