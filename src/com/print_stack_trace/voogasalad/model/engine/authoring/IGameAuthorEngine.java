package com.print_stack_trace.voogasalad.model.engine.authoring;

import java.io.FileInputStream;
import java.util.List;

import javafx.scene.input.KeyCode;

import com.print_stack_trace.voogasalad.exceptions.ElementLockedException;
import com.print_stack_trace.voogasalad.model.GameWorldCharacteristics;
import com.print_stack_trace.voogasalad.model.GoalCharacteristics;
import com.print_stack_trace.voogasalad.model.LevelCharacteristics;
import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionFactory.CollisionResult;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionFactory.UserDefinedCollisionParams;
import com.print_stack_trace.voogasalad.model.engine.physics.PhysicsEngine;
import com.print_stack_trace.voogasalad.model.engine.physics.SoloPhysicsGenerator.ProgramPhysicEngine;
import com.print_stack_trace.voogasalad.model.engine.runtime.camera.CameraFactory;
import com.print_stack_trace.voogasalad.model.engine.runtime.camera.CameraFactory.CameraType;
import com.print_stack_trace.voogasalad.model.engine.runtime.keyboard.KeyApplicatorFactory.KeyResult;
/**
 * Interface containing the necessary methods that someone would need to implement if they wanted
 * to create their own game author engine 
 * @author Ethan Chang, Jack Baskin, Nick Widmaiwer, Zach Podbela
 *
 */
public interface IGameAuthorEngine {

	public GameWorldModel getGameWorldModel();
	public void setGameWorldModel(GameWorldModel gameWorldModel) throws ElementLockedException;
	public GameWorldCharacteristics getGameWorldCharacteristics();
	public void setGameWorldCharacteristics(GameWorldCharacteristics gameSpecs) throws ElementLockedException;
	public void addLevel(Integer levelIndex, LevelCharacteristics levelSpecs) throws ElementLockedException;
	public void setCurrentLevel(int index) throws ElementLockedException, ArrayIndexOutOfBoundsException;
	public Integer addObjectToLevel(SpriteCharacteristics spriteModel) throws ElementLockedException;
	public void updateObject(Integer modelID, SpriteCharacteristics spriteModel) throws ElementLockedException;
	public void deleteObject(Integer modelID) throws ElementLockedException;
	public LevelModel getCurrentLevel() throws ElementLockedException;
	public List<LevelModel> getAllLevels();
	public Integer addGoalToLevel(GoalCharacteristics goalModel) throws ArrayIndexOutOfBoundsException;
	public void updateGoal(Integer goalID, GoalCharacteristics goalModel) throws ElementLockedException;
	public void deleteGoal(Integer goalID) throws ElementLockedException;
	public void setCameraType(CameraFactory.CameraType c) throws ElementLockedException;
	public void setLevelCharacteristics(LevelCharacteristics levelSpecs) throws ElementLockedException;
	public void setPhysicsEngine(PhysicsEngine physicsEngine);
	public void setProgramPhysicsEngine(ProgramPhysicEngine engineType) throws ElementLockedException;
	public void setPhysicsEngineUsingParams(float gravity, float drag, float intensity) throws ElementLockedException;
	public void setResultOfCollision(CollisionResult result, SpriteType s1, SpriteType s2) throws ElementLockedException;
	public void setCustomParamForCollisionType(CollisionResult result, UserDefinedCollisionParams paramType, int param) throws ElementLockedException;
	public Integer getMainCharacter();
	public void setMainCharacter(Integer mainCharacter);
    public void setResultForKey(KeyResult result, KeyCode key);
    public KeyResult getResultOfKey(KeyCode key);
}
