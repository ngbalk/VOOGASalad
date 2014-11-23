/**
 * @author Zachary Podbela
 * @author Pranava Raparla
 * Date Created: 11/23/14
 * Date Modified: 11/23/14
 */

package com.print_stack_trace.voogasalad.model.engine.physics.collisions;

import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeSpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionHandler;

public class ObjectOneDisappear implements CollisionHandler {

	@Override
	public void applyCollisionEffects(RuntimeSpriteCharacteristics s1,
			RuntimeSpriteCharacteristics s2) {
		// TODO Auto-generated method stub
		s1.interactive = false;
		s1.setAlpha(0.0f);
	}

}
