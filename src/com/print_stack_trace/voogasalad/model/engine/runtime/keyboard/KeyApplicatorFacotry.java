package com.print_stack_trace.voogasalad.model.engine.runtime.keyboard;

import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeSpriteCharacteristics;

public class KeyApplicatorFacotry {
	public static final int V_KEY_CONSTANT = 50;
	
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
		switch(mykeyResult) {
		case Down:
			vynew = -V_KEY_CONSTANT;
			vxnew = 0;
			break;
		case Left:
			vxnew = -V_KEY_CONSTANT;
			vynew = 0;
			break;
		case Right:
			vxnew = V_KEY_CONSTANT;
			vynew = 0;
			break;
		case Up:
			vynew = V_KEY_CONSTANT;
			vxnew = 0;
			break;
		default:
			vynew = 0;
			vxnew = 0;
			break;
		
		}
		return new KeyApplicator() {
			@Override
			public void applyPressActionToRuntimeSprite(
					RuntimeSpriteCharacteristics sprite) {
				sprite.v_x += vxnew;
				sprite.v_y -= vynew;	
			}

			@Override
			public void applyReleaseActionToRuntimeSprite(
					RuntimeSpriteCharacteristics sprite) {
				sprite.v_x -= vxnew;
				sprite.v_y += vynew;
			}
		};
       
    }
}
