package com.print_stack_trace.voogasalad.model.engine.physics.collisions;

import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionHandler;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeModel;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeSpriteCharacteristics;

public class ObjectOnePassThroughTop extends CollisionHandler {
	
	@Override
    public void applyCollisionEffects (RuntimeSpriteCharacteristics s1,
                                       RuntimeSpriteCharacteristics s2,
                                       RuntimeModel currentRuntime) {
            if(s1.getObjectType().equals(SpriteType.HERO) && s1.isCollidingVertically && s1.v_y > 0){
                System.out.println("jkasbdjasd");
                return;
            }
                //s2.v_x = 0;
            s1.v_y = 0;
                //s2.v_y = 0;
    }
	
}