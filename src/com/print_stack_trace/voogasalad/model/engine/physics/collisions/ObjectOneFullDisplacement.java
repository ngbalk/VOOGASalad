/**
 * @author Zachary Podbela
 * @author Pranava Raparla
 * Date Created: 11/23/14
 * Date Modified: 11/23/14
 */

package com.print_stack_trace.voogasalad.model.engine.physics.collisions;

import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeSpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionHandler;

public class ObjectOneFullDisplacement implements CollisionHandler {

	@Override
	public void applyCollisionEffects(RuntimeSpriteCharacteristics s1,
			RuntimeSpriteCharacteristics s2) {
		s1.v_x = -s1.v_x;
		s2.v_x = -s2.v_x;
		s1.decelerationConstant = 1;
	}

}
