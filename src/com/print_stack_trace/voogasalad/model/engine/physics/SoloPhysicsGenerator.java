package com.print_stack_trace.voogasalad.model.engine.physics;

import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeSpriteCharacteristics;

public class SoloPhysicsGenerator {

    public enum ProgramPhysicEngine {
    	EarthPhysicsEngine,
        HalfGravityEngine,
        ZeroGravityEngine,
        InvertedGravityEngine,
        InvertedHalfGravityEngine,
        WindyCityEngine
    }


    public static SoloPhysicsHandler getProgramPhysicEngine(ProgramPhysicEngine engineType) {
    	switch(engineType) {
        default:
        case EarthPhysicsEngine:
            return physicEngineFromParams(9.81f, 0f, 3.0f);
        case HalfGravityEngine:
            return physicEngineFromParams(4.405f, 0f, 3.0f);
        case ZeroGravityEngine:
        	return physicEngineFromParams(0.0f, 0f, 3.0f);
        case InvertedGravityEngine:
            return physicEngineFromParams(-9.81f, 0f, 3.0f);
        case InvertedHalfGravityEngine:
        	return physicEngineFromParams(-4.405f, 0f, 3.0f);
        case WindyCityEngine:
            return physicEngineFromParams(9.81f, -10.0f, 3.0f);
        }
    }

    public static SoloPhysicsHandler physicEngineFromParams(float gravity, float drag, float intensity) {
        final float fgravity = gravity;
        final float fdrag = drag;
        final float fintensity = intensity;
        return new SoloPhysicsHandler() {
            @Override
            public void applyPhysics(RuntimeSpriteCharacteristics s1, int framesPerSecond) {


                s1.v_y += (1.0f/(float)framesPerSecond)*fgravity*fintensity;
                s1.v_x -= (1.0f/(float)framesPerSecond)*fdrag*fintensity;

            }
        };
    }
}