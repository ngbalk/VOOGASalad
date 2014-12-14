package com.print_stack_trace.voogasalad.model.engine.physics.collisions;

import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeModel;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeSpriteCharacteristics;

public class DoodleJumpDamageCollision extends DoodleJumpNormalPlatform {
    
    @Override
    protected void setDisplacedActions(RuntimeSpriteCharacteristics s1,
                                       RuntimeSpriteCharacteristics s2,
                                       RuntimeModel currentRuntime){
        super.setDisplacedActions(s1,s2,currentRuntime);
        s1.setHealthProperty(s1.getPropertyReadOnlyHealth().getValue() - s2.getDamageDealt());        
    }
}
