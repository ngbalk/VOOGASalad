/**
 * @author Zachary Podbela
 * @author Pranava Raparla
 * Date Created: 11/23/14
 * Date Modified: 11/23/14
 */

package com.print_stack_trace.voogasalad.model.engine.physics.collisions;

import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeModel;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeSpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionHandler;

public class NoAction extends CollisionHandler {

	@Override
	public void applyCollisionEffects(RuntimeSpriteCharacteristics s1,
			RuntimeSpriteCharacteristics s2, RuntimeModel currentRuntime) {
		// No Action Taken
		return;
	}

    @Override
    public boolean shouldStick (RuntimeSpriteCharacteristics s1, RuntimeSpriteCharacteristics s2) {
        return false;
    }

}
