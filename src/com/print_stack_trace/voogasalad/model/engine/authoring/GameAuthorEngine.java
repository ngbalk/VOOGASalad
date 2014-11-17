package com.print_stack_trace.voogasalad.model.engine.authoring;

import java.util.ArrayList;
import java.util.List;

import com.print_stack_trace.voogasalad.model.GoalCharacteristics;
import com.print_stack_trace.voogasalad.model.LevelCharacteristics;
import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionHandler;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionHandlerList;
import com.print_stack_trace.voogasalad.model.engine.physics.PhysicsEngine;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionHandlerList.UserDefinedCollisionParams;
import com.print_stack_trace.voogasalad.model.engine.physics.PhysicsEngine.CollisionResult;
import com.print_stack_trace.voogasalad.model.engine.physics.PhysicsEngineList;
import com.print_stack_trace.voogasalad.model.engine.physics.PhysicsEngineList.ProgramPhysicEngine;
import com.print_stack_trace.voogasalad.model.environment.Goal;

public class GameAuthorEngine {

	private List<LevelModel> levelList;
	private LevelModel currentLevel;

	public enum SpriteType {
		HERO,
		ENEMY,
		PLATFORM,
		OBSTACLE,
		REWARD
		
	}
	
	public enum GoalType {
	    REACH_OBJECT,
	    REACH_DISTANCE,
	    KILL_BOSS,
	    POINTS,
	    STAY_ALIVE
	}
	
	public enum CameraType {
	    SCROLLING_RIGHT_TO_LEFT,
	    SCROLLING_LEFT_TO_RIGHT,
	    SCROLLING_TOP_TO_BOTTOM,
	    SCROLLING_BOTTOM_TO_TOP,
	    CENTERED_ON_PLAYER,
	    SCROLL_WHEN_EDGE_REACHED
	    
	}

	public GameAuthorEngine(){
		levelList = new ArrayList<>();
		currentLevel = new LevelModel();
		levelList.add(currentLevel);
	}

	public boolean setCurrentLevel(int index){
		if(levelList.get(index)!= null){
			currentLevel = levelList.get(index);
			return true;
		}
		return false;
	}

	public Integer addObjectToLevel(SpriteCharacteristics spriteModel) {

		currentLevel.addObject(spriteModel);
		return null;
	}

	public boolean updateObject(Integer modelID, SpriteCharacteristics spriteModel) {
		currentLevel.updateObject(modelID, spriteModel);
		return true;
	}

	public boolean deleteObject(Integer modelID) {
		currentLevel.deleteObject(modelID);
		return false;
	}

	public LevelModel getCurrentLevel(){
		return currentLevel;
	}
	public List<LevelModel> getAllLevels(){
		return levelList;
	}

	public Integer addGoalToLevel(GoalCharacteristics goalModel) {
		//TODO: Pass to authorEngine!
		return null;
	}

	public boolean updateGoal(Integer goalID, GoalCharacteristics goalModel) {
		//TODO: Pass to authorEngine!
		return false;
	}

	public boolean deleteGoal(Integer goalID) {
		return false;
	}

	public void setCameraType(CameraType c){
	    currentLevel.setCameraType(c);
	}
	
	public boolean setLevelCharacteristics(LevelCharacteristics levelSpecs) {
		return currentLevel.setLevelCharacteristics(levelSpecs);
	}
	
	public boolean setProgramPhysicsEngine(ProgramPhysicEngine engineType) {
		return currentLevel.setSoloHandler(PhysicsEngineList.getProgramPhysicEngine(engineType));
	}
	
	public boolean setPhysicsEngineUsingParams(int gravity, int drag, int intensity) {
		return currentLevel.setSoloHandler(PhysicsEngineList.physicEngineFromParams(gravity, drag, intensity));
	}
	
	public boolean setResultOfCollision(CollisionResult result, SpriteCharacteristics s1, SpriteCharacteristics s2) {
		return currentLevel.setResultOfCollision(result, s1, s2);
	}
	
	public boolean setCustomParamForCollisionType(CollisionResult result, UserDefinedCollisionParams paramType, int param) {
		return currentLevel.setCollisionHandlerForResult(result, CollisionHandlerList.collisionEngineFromParams(result, paramType, param));
	}
}