package com.print_stack_trace.voogasalad.model.engine.runtime;

import java.util.Collection;
import java.util.List;

import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;

public class PhysicsEngineList {
	//TODO: Impliment
	public static List<String> getProgramPhysicEngineList() {
		return null;
		
	}
	
	//TODO: Impliment
	public static PhysicsEngine getProgramPhysicEngine(int indexInList) {
		return null;
	}
	
	public static PhysicsEngine physicEngineFromParams(int gravity, int drag, int intensity) {
		return new PhysicsEngine() {

			@Override
			public void animateSolo(Collection<SpriteCharacteristics> allObjects) {
				// TODO Auto-generated method stub
				//USE FOO AND BAR
			}

			@Override
			public void collisionHandler(SpriteCharacteristics s1,
					SpriteCharacteristics s2) {
				// TODO Auto-generated method stub
				//USE FOO AND BAR
			}
			
		};
	}
}
