package com.print_stack_trace.voogasalad.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.print_stack_trace.voogasalad.controller.author.Goal;
import com.print_stack_trace.voogasalad.model.SpriteCharacteristics.ObjectType;

public class LevelModel {
	
	Map<Integer, SpriteCharacteristics> spriteMap;
	private Integer currentID;
	private boolean isLocked;
	
	
	private Integer incrementID() {
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
		return 0;
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
	
	public boolean setGoal(Goal goal) {
		return false;
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
