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
		int newHealth = (int) s2.getPropertyReadOnlyHealth().getValue();
		newHealth--;
		s2.setHealthProperty(newHealth);
		int newHealth2 = (int) s1.getPropertyReadOnlyHealth().getValue();
		newHealth2--;
		s1.setHealthProperty(newHealth2);
		return;
	}

}
