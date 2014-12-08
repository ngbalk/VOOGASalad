package com.print_stack_trace.voogasalad.model.engine.physics.collisions;

import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionDetector;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionHandler;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeModel;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeSpriteCharacteristics;

public class HeroDamageCollision extends CollisionHandler {

    @Override
    public void applyCollisionEffects (RuntimeSpriteCharacteristics s1,
                                       RuntimeSpriteCharacteristics s2,
                                       RuntimeModel currentRuntime) {
        if(s1.getObjectType().equals(SpriteType.HERO) && s2.getObjectType().equals(SpriteType.ENEMY)){
            if(CollisionDetector.haveCollidedFromTop(s1, s2)){
                s2.flagForRemoval();
                int points = s1.getPropertyReadOnlyPoints().getValue();
                points++;
                s1.setPointsProperty(points);
            }
            else{
                s1.health -= s2.damageDealt;
                System.out.println("NEW HEALTH     " + s1.health);
                s1.v_x = -s1.v_x;
                s2.v_x = -s2.v_x;
            }
        }
        
    }

    
    
}
