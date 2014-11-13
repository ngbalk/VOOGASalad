package com.print_stack_trace.voogasalad.model.engine.authoring;

import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;

public class GameAuthorEngine {
	public enum SpriteType {
		PLAYER,
		OBSTACLE,
		GOAL,
		SCENERY
	}
	
	public Integer addObjectToLevel(SpriteCharacteristics spriteModel) {
		return null;
	}
	
	public boolean updateObject(Integer modelID, SpriteCharacteristics spriteModel) {
		return true;
	}
	
	public boolean deleteObject(Integer modelID) {
		return false;
	}
}