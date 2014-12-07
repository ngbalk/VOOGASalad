package com.print_stack_trace.voogasalad.model.engine.physics.collisions;

import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionDetector;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionHandler;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeModel;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeSpriteCharacteristics;

public class HeroGetsRewards extends CollisionHandler {

    @Override
    public void applyCollisionEffects (RuntimeSpriteCharacteristics s1,
                                       RuntimeSpriteCharacteristics s2,
                                       RuntimeModel currentRuntime) {
        if(s1.getObjectType().equals(SpriteType.HERO) && s2.getObjectType().equals(SpriteType.REWARD)){
                s2.flagForRemoval();
                s1.value += s2.value;
                System.out.println("Point Total = " + s1.value);
            }
        }
        
    }

    
    

