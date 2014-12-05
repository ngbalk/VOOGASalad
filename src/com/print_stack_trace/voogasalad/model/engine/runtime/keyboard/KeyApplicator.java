package com.print_stack_trace.voogasalad.model.engine.runtime.keyboard;

import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeSpriteCharacteristics;

public interface KeyApplicator {
	public void applyActionToRuntimeSprite(RuntimeSpriteCharacteristics sprite);
	public boolean shouldRemove();
}
