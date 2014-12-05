package com.print_stack_trace.voogasalad.model.engine.runtime.keyboard;

import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeSpriteCharacteristics;

public class KeyApplicatorFacotry {
	public static final int V_KEY_CONSTANT = 5;
	
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
		final boolean shouldRemove;
		switch(mykeyResult) {
		case Down:
			vynew = -V_KEY_CONSTANT;
			vxnew = 0;
			shouldRemove = true;
			break;
		case Left:
			vxnew = -V_KEY_CONSTANT;
			vynew = 0;
			shouldRemove = false;
			break;
		case Right:
			vxnew = V_KEY_CONSTANT;
			vynew = 0;
			shouldRemove = false;
			break;
		case Up:
			vynew = V_KEY_CONSTANT;
			vxnew = 0;
			shouldRemove = true;
			break;
		default:
			vynew = 0;
			vxnew = 0;
			shouldRemove = true;
			break;
		
		}
		return new KeyApplicator() {
			@Override
			public void applyActionToRuntimeSprite(RuntimeSpriteCharacteristics sprite) {
				sprite.v_x = vxnew;
				sprite.v_y = vynew;
			}

			@Override
			public boolean shouldRemove() {
				return shouldRemove;
			}
		};
       
    }
}
