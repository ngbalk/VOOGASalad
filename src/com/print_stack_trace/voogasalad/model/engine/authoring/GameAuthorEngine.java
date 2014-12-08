package com.print_stack_trace.voogasalad.model.engine.authoring;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.input.KeyCode;

import com.print_stack_trace.voogasalad.exceptions.ElementLockedException;
import com.print_stack_trace.voogasalad.model.GameWorldCharacteristics;
import com.print_stack_trace.voogasalad.model.GoalCharacteristics;
import com.print_stack_trace.voogasalad.model.LevelCharacteristics;
import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionFactory;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionFactory.CollisionResult;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionFactory.UserDefinedCollisionParams;
import com.print_stack_trace.voogasalad.model.engine.physics.PhysicsEngine;
import com.print_stack_trace.voogasalad.model.engine.physics.SoloPhysicsGenerator;
import com.print_stack_trace.voogasalad.model.engine.physics.SoloPhysicsGenerator.ProgramPhysicEngine;
import com.print_stack_trace.voogasalad.model.engine.runtime.camera.CameraFactory;
import com.print_stack_trace.voogasalad.model.engine.runtime.keyboard.KeyApplicatorFactory.KeyResult;

public class GameAuthorEngine implements IGameAuthorEngine {
	
	private GameWorldModel gameWorldModel;
	private LevelModel currentLevel;

	public enum SpriteType {
		HERO,
		ENEMY,
		PLATFORM,
		OBSTACLE,
		REWARD
	}

	public GameAuthorEngine(){
		gameWorldModel = new GameWorldModel();
		currentLevel = gameWorldModel.getCurrentLevel();
	}
	
	public GameWorldModel getGameWorldModel() {
		return gameWorldModel;
	}
	
	public void setGameWorldModel(GameWorldModel gameWorldModel) {
		this.gameWorldModel = gameWorldModel;
	}
	
	public GameWorldCharacteristics getGameWorldCharacteristics() {
		return gameWorldModel.getGameWorldCharacteristics();
	}
	
	public void setGameWorldCharacteristics(GameWorldCharacteristics gameSpecs) {
		gameWorldModel.setGameWorldCharacteristics(gameSpecs);
	}

	public void setCurrentLevel(int index){
		gameWorldModel.setCurrentLevel(index);
		currentLevel = gameWorldModel.getCurrentLevel();
	}

	public Integer addObjectToLevel(SpriteCharacteristics spriteModel) {
		return currentLevel.addObject(spriteModel);
	}

	public void updateObject(Integer modelID, SpriteCharacteristics spriteModel) {
		currentLevel.updateObject(modelID, spriteModel);
	}

	public void deleteObject(Integer modelID) {
		currentLevel.deleteObject(modelID);
	}

	public LevelModel getCurrentLevel(){
		return currentLevel;
	}
	
	public List<LevelModel> getAllLevels(){
		return gameWorldModel.getLevels();
	}

	public Integer addGoalToLevel(GoalCharacteristics goalModel) {
		return currentLevel.setGoal(goalModel);
	}

	public void updateGoal(Integer goalID, GoalCharacteristics goalModel) {
		currentLevel.updateGoal(goalID, goalModel);
	}

	public void deleteGoal(Integer goalID) {
		currentLevel.deleteGoal(goalID);
	}

	public void setCameraType(CameraFactory.CameraType c){
		currentLevel.setCameraType(c);
	}

	public void setLevelCharacteristics(LevelCharacteristics levelSpecs) {
		currentLevel.setLevelCharacteristics(levelSpecs);
	}

	public void setPhysicsEngine(PhysicsEngine physicsEngine) {
		currentLevel.setPhysicsEngine(physicsEngine);
	}

	public void setProgramPhysicsEngine(ProgramPhysicEngine engineType) {
		currentLevel.setSoloHandler(SoloPhysicsGenerator.getProgramPhysicEngine(engineType));
	}

	public void setPhysicsEngineUsingParams(float gravity, float drag, float intensity) {
		currentLevel.setSoloHandler(SoloPhysicsGenerator.physicEngineFromParams(gravity, drag, intensity));
	}

	public void setResultOfCollision(CollisionResult result, SpriteType s1, SpriteType s2) {
		currentLevel.setResultOfCollision(result, s1, s2);
	}

	public void setCustomParamForCollisionType(CollisionResult result, UserDefinedCollisionParams paramType, int param) {
		currentLevel.setCollisionHandlerForResult(result, CollisionFactory.collisionEngineFromParams(result, paramType, param));
	}

	public Integer getMainCharacter() {
		return currentLevel.getMainCharacter();
	}

	public void setMainCharacter(Integer mainCharacter) {
		currentLevel.setMainCharacter(mainCharacter);
	}
    
    public void setResultForKey(KeyResult result, KeyCode key) {
    	currentLevel.setResultForKey(result, key);
    }
    
    public KeyResult getResultOfKey(KeyCode key) {
    	return currentLevel.getResultOfKey(key);
    }

}