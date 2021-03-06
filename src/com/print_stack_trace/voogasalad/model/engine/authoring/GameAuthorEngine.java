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
/**
 * @author Ethan Chang, Jack Baskin, Nick Widmaier
 * 
 * Implementation of IGameAuthorEngine to be used for our game
 * engine. The class contains a list of all the possible levels
 * as well as a stored current level so assets can be modified
 * directly. Additionally, enumerations for the types of sprites
 * and camera types can be found in this class. Since the game engine
 * calls upon the methods in GameAuthorEngine to update the characteristics
 * of sprites, we have analogous methods to those in the GameEngine for updating
 * sprites and setting the physics engine to use.
 */
public class GameAuthorEngine implements IGameAuthorEngine {
	
	private GameWorldModel gameWorldModel;
    /**
     * Contains potential sprite types that the user can select
     * for their sprites. Using an enumeration allows for lists in
     * the front end to be updated dynamically as items are added
     * to the enumeration.
     *
     */
	public enum SpriteType {
		HERO,
		ENEMY,
		PLATFORM,
		OBSTACLE,
		REWARD
	}
    /**
     * Constructor for GameAuthorEngine, initializes
     * all of the objects needed and adds an initial level.
     */
	public GameAuthorEngine(){
		gameWorldModel = new GameWorldModel();
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
	
	public void addLevel(Integer levelIndex, LevelCharacteristics levelCharacteristics) {
		gameWorldModel.addLevel(levelIndex, levelCharacteristics);
	}
	
	public void setCurrentLevel(int index){
		gameWorldModel.setCurrentLevel(index);
	}

	public Integer addObjectToLevel(SpriteCharacteristics spriteModel) {
		return gameWorldModel.getCurrentLevel().addObject(spriteModel);
	}

	public void updateObject(Integer modelID, SpriteCharacteristics spriteModel) {
	    gameWorldModel.getCurrentLevel().updateObject(modelID, spriteModel);
	}

	public void deleteObject(Integer modelID) {
	    gameWorldModel.getCurrentLevel().deleteObject(modelID);
	}

	public LevelModel getCurrentLevel(){
		return gameWorldModel.getCurrentLevel();
	}
	
	public List<LevelModel> getAllLevels(){
	    List<LevelModel> allLevels = new ArrayList<LevelModel>();
	    for(Integer i : gameWorldModel.getLevelMap().keySet())
	        allLevels.add(i,gameWorldModel.getLevelMap().get(i));
		return allLevels;
	}

	public Integer addGoalToLevel(GoalCharacteristics goalModel) {
		return gameWorldModel.getCurrentLevel().setGoal(goalModel);
	}

	public void updateGoal(Integer goalID, GoalCharacteristics goalModel) {
	    gameWorldModel.getCurrentLevel().updateGoal(goalID, goalModel);
	}

	public void deleteGoal(Integer goalID) {
	    gameWorldModel.getCurrentLevel().deleteGoal(goalID);
	}

	public void setCameraType(CameraFactory.CameraType c){
	    gameWorldModel.getCurrentLevel().setCameraType(c);
	}

	public void setLevelCharacteristics(LevelCharacteristics levelSpecs) {
	    
		gameWorldModel.getCurrentLevel().setLevelCharacteristics(levelSpecs);
	}

	public void setPhysicsEngine(PhysicsEngine physicsEngine) {
		gameWorldModel.getCurrentLevel().setPhysicsEngine(physicsEngine);
	}

	public void setProgramPhysicsEngine(ProgramPhysicEngine engineType) {
		gameWorldModel.getCurrentLevel().setSoloHandler(SoloPhysicsGenerator.getProgramPhysicEngine(engineType));
	}

	public void setPhysicsEngineUsingParams(float gravity, float drag, float intensity) {
		gameWorldModel.getCurrentLevel().setSoloHandler(SoloPhysicsGenerator.physicEngineFromParams(gravity, drag, intensity));
	}

	public void setResultOfCollision(CollisionResult result, SpriteType s1, SpriteType s2) {
		gameWorldModel.getCurrentLevel().setResultOfCollision(result, s1, s2);
	}

	public void setCustomParamForCollisionType(CollisionResult result, UserDefinedCollisionParams paramType, int param) {
		gameWorldModel.getCurrentLevel().setCollisionHandlerForResult(result, CollisionFactory.collisionEngineFromParams(result, paramType, param));
	}

	public Integer getMainCharacter() {
		return gameWorldModel.getCurrentLevel().getMainCharacter();
	}

	public void setMainCharacter(Integer mainCharacter) {
		gameWorldModel.getCurrentLevel().setMainCharacter(mainCharacter);
	}
    
    public void setResultForKey(KeyResult result, KeyCode key) {
    	gameWorldModel.getCurrentLevel().setResultForKey(result, key);
    }
    
    public KeyResult getResultOfKey(KeyCode key) {
    	return gameWorldModel.getCurrentLevel().getResultOfKey(key);
    }

}