/**
 * @author Zachary Podbela
 * @author Pranava Raparla

 * Date Created: 11/11/14
 * Date Modified: 11/11/14
 */
package com.print_stack_trace.voogasalad.model.engine.runtime;

import java.util.Collection;

import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;

public abstract class PhysicsEngine {	

	public abstract void animateSolo(Collection<SpriteCharacteristics> allObjects);
	public abstract void collisionHandler(SpriteCharacteristics s1, SpriteCharacteristics s2);
}
