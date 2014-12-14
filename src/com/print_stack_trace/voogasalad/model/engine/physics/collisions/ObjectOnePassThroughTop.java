package com.print_stack_trace.voogasalad.model.engine.physics.collisions;

import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionHandler;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeModel;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeSpriteCharacteristics;

public class ObjectOnePassThroughTop extends CollisionHandler {
	
    private CollisionHandler noAction = new NoAction();
    private boolean shouldStick;
    private CollisionHandler obnd = new ObjectBothNoDisplacement();

    @Override
    public void applyCollisionEffects (RuntimeSpriteCharacteristics s1,
                                       RuntimeSpriteCharacteristics s2,
                                       RuntimeModel currentRuntime) {
        
	        if(s1.v_y > 0 && Math.abs(s1.v_y) < Math.abs(s1.v_x)) {
	            noAction .applyCollisionEffects(s1, s2, currentRuntime);
	            shouldStick = false;
	        } else {
	            obnd.applyCollisionEffects(s1, s2, currentRuntime);
	            shouldStick = true;
	        }

    }

    @Override
    public boolean shouldStick (RuntimeSpriteCharacteristics s1, RuntimeSpriteCharacteristics s2) {
        return shouldStick;
    }
	
}
