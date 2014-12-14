package com.print_stack_trace.voogasalad.model.engine.physics.collisions;

import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeModel;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeSpriteCharacteristics;

public class DoodleJumpNormalPlatform extends ObjectOnePassThroughBottom {
    private static final int DEFAULT_JUMP_VELOCITY = -20;
    
    @Override
    protected void setDisplacedActions (RuntimeSpriteCharacteristics s1,
                                        RuntimeSpriteCharacteristics s2,
                                        RuntimeModel currentRuntime) {
        super.setDisplacedActions(s1, s2, currentRuntime);
        s1.v_y = DEFAULT_JUMP_VELOCITY;
    }
}
