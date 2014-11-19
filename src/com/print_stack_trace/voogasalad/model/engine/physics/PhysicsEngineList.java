package com.print_stack_trace.voogasalad.model.engine.physics;

import java.util.Collection;
import java.util.List;

import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;

public class PhysicsEngineList {
	
	public enum ProgramPhysicEngine {
		EarthPhysicsEngine,
		HalfGravityEngine,
		WindyCityEngine,
		InvertedGravityEngine
	}
	
	//TODO: Impliment
	public static SoloPhysicsHandler getProgramPhysicEngine(ProgramPhysicEngine engineType) {
		return null;
	}
	
	public static SoloPhysicsHandler physicEngineFromParams(int gravity, int drag, int intensity) {
		return new SoloPhysicsHandler() {
			@Override
			public void applyPhysics(SpriteCharacteristics s1) {
				// TODO Auto-generated method stub
				//USE FOO AND BAR
			}
		};
	}
}
