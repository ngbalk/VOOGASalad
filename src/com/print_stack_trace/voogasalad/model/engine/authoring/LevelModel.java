package com.print_stack_trace.voogasalad.model.engine.authoring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.print_stack_trace.voogasalad.model.GoalCharacteristics;
import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.CameraType;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;
import com.print_stack_trace.voogasalad.model.engine.physics.PhysicsEngine;
import com.print_stack_trace.voogasalad.model.environment.Goal;
import com.print_stack_trace.voogasalad.model.environment.GoalFactory;
import com.print_stack_trace.voogasalad.model.sprites.Sprite;
import com.print_stack_trace.voogasalad.model.sprites.SpriteFactory;

public class LevelModel {
	
	Map<Integer, SpriteCharacteristics> spriteMap;
	private Integer currentID;
	private boolean isLocked;
	private PhysicsEngine physicsEngine;
	private Goal myGoal;
	
	
	public PhysicsEngine getPhysicsEngine() {
		return physicsEngine;
	}

	public void setPhysicsEngine(PhysicsEngine physicsEngine) {
		if (isLocked);
		this.physicsEngine = physicsEngine;
	}

	private Integer generateID() {
		while(spriteMap.keySet().contains(currentID)) {
			currentID++;
		}
		return currentID;
	}
	
	public void setLocked() {
		isLocked = true;
	}
	
	public void setUnlocked() {
		isLocked = false;
	}
	
	public Integer addObject (SpriteCharacteristics chars) {
		if (isLocked) return null;
		
		for (Integer i: spriteMap.keySet()) {
			/*
			 * Logic for if object can be added 
			 * Loop through sprites to see if
			 * location of new added sprite is
			 * unoccupied.  If so, return null 
			 * in this loop. Otherwise, conclude
			 * the loop.
			*/
		}
		
		int newID = generateID();
		spriteMap.put(newID, chars);
		return newID;
	}
	
	public boolean deleteObject (Integer ModelID) {
		if (isLocked) return false;
		spriteMap.remove(ModelID);
		return true;
	}
	
	public boolean updateObject (Integer ModelID, SpriteCharacteristics chars) {
		if (isLocked) return false;
		//if it passes other logic tests including: no collisions
		spriteMap.remove(ModelID);
		spriteMap.put(ModelID, chars);
		return true;
	}
	
	
	//TODO: Talk to authoring about how goals are implemented 
	//      this is needed to implement this method.
	public boolean setGoal(Goal goal) {
		myGoal = goal;
		return true;
	}
	
	
	
	/*public HashMap<Integer, SpriteCharacteristics> getSpriteTypes(ObjectType obj) {
		HashMap<Integer, SpriteCharacteristics> sprites = new HashMap<Integer, SpriteCharacteristics >();
		for (Integer i: spriteMap.keySet()) {
			if (spriteMap.get(i).objectType == obj) {
				sprites.put(i, spriteMap.get(i));
			}
		}
		return sprites;
	}*/
	
	
	

}
