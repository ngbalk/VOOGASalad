package com.print_stack_trace.voogasalad.model.engine.physics.collisions;

import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionDetector;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionFactory.CollisionResult;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionHandler;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeModel;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeSpriteCharacteristics;

public class ObjectOnePassThroughBottom extends CollisionHandler {
    private NoAction noAction = new NoAction();
    private ObjectBothNoDisplacement obnd = new ObjectBothNoDisplacement();
    private boolean shouldStick = true;
    
    @Override
    public void applyCollisionEffects (RuntimeSpriteCharacteristics s1,
                                       RuntimeSpriteCharacteristics s2,
                                       RuntimeModel currentRuntime) {

        if(s1.v_y < 0 && Math.abs(s1.v_y) > Math.abs(s1.v_x)) {
            noAction.applyCollisionEffects(s1, s2, currentRuntime);
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

