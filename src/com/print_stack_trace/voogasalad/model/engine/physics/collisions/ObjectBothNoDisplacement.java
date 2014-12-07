package com.print_stack_trace.voogasalad.model.engine.physics.collisions;

import com.print_stack_trace.voogasalad.model.engine.physics.CollisionDetector;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionHandler;
import com.print_stack_trace.voogasalad.model.engine.physics.SoloPhysicsGenerator;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeModel;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeSpriteCharacteristics;

public class ObjectBothNoDisplacement extends CollisionHandler {

        @Override
        public void applyCollisionEffects(RuntimeSpriteCharacteristics s1,
                        RuntimeSpriteCharacteristics s2, RuntimeModel currentRuntime) {
//              s1.v_x = -s1.v_x;
//              s2.v_x = -s2.v_x;
//              s1.v_y = -s1.v_y;
//              s2.v_y = -s2.v_y;
//                System.out.println("S1:    " + s1.getX() + "    " + s1.getY() + s1.getHeight());
//                System.out.println("S2:    " + s2.getX() + "    " + s2.getY());

//                if(CollisionDetector.haveCollidedHorizontally(s1, s2)){
//                    s1.v_x = 0;
//                }
//                else{
//                		s1.setY(s2.getY() - s1.getHeight());
//
//                }
                /*if(!(s1.getX() < s2.getX() && (s1.getY() + s1.getHeight() < s2.getY()))){
                    s1.setY(s2.getY() - s1.getHeight());
                }
                else if(!(s1.getX() > s2.getX() + s2.getWidth() && (s1.getY() + s1.getHeight() > s2.getY()))){
                    s1.setY(s2.getY() - s1.getHeight());
                }
                else{
                    s1.v_x = 0;
                }*/
                s2.v_x = 0;
                s1.v_y = 0;
                s2.v_y = 0;
                
                //s1.setDecelerationConstant(1.0f);
                //s2.setDecelerationConstant(1.0f);
        }

}
