package com.print_stack_trace.voogasalad.model.engine.authoring;

import java.util.List;

import com.print_stack_trace.voogasalad.exceptions.ElementLockedException;
import com.print_stack_trace.voogasalad.model.GoalCharacteristics;
import com.print_stack_trace.voogasalad.model.LevelCharacteristics;
import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.CameraType;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionFactory.CollisionResult;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionFactory.UserDefinedCollisionParams;
import com.print_stack_trace.voogasalad.model.engine.physics.PhysicsEngineList.ProgramPhysicEngine;

public interface AbstractGameAuthorEngine {
	public void setCurrentLevel(int index) throws ElementLockedException, ArrayIndexOutOfBoundsException;
	public Integer addObjectToLevel(SpriteCharacteristics spriteModel) throws ElementLockedException;
	public void updateObject(Integer modelID, SpriteCharacteristics spriteModel) throws ElementLockedException;
	public void deleteObject(Integer modelID) throws ElementLockedException;
	public LevelModel getCurrentLevel() throws ElementLockedException;
	public List<LevelModel> getAllLevels();
	public Integer addGoalToLevel(GoalCharacteristics goalModel) throws ArrayIndexOutOfBoundsException;
	public void updateGoal(Integer goalID, GoalCharacteristics goalModel) throws ElementLockedException;
	public void deleteGoal(Integer goalID) throws ElementLockedException;
	public void setCameraType(CameraType c) throws ElementLockedException;
	public void setLevelCharacteristics(LevelCharacteristics levelSpecs) throws ElementLockedException;
	public void setProgramPhysicsEngine(ProgramPhysicEngine engineType) throws ElementLockedException;
	public void setPhysicsEngineUsingParams(int gravity, int drag, int intensity) throws ElementLockedException;
	public void setResultOfCollision(CollisionResult result, SpriteType s1, SpriteType s2) throws ElementLockedException;
	public void setCustomParamForCollisionType(CollisionResult result, UserDefinedCollisionParams paramType, int param) throws ElementLockedException;
}
