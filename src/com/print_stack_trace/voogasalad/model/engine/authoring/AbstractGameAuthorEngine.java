package com.print_stack_trace.voogasalad.model.engine.authoring;

import java.util.List;

import com.print_stack_trace.voogasalad.model.GoalCharacteristics;
import com.print_stack_trace.voogasalad.model.LevelCharacteristics;
import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.CameraType;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionFactory.CollisionResult;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionHandlerList.UserDefinedCollisionParams;
import com.print_stack_trace.voogasalad.model.engine.physics.PhysicsEngineList.ProgramPhysicEngine;

public interface AbstractGameAuthorEngine {
	public void setCurrentLevel(int index);
	public Integer addObjectToLevel(SpriteCharacteristics spriteModel);
	public void updateObject(Integer modelID, SpriteCharacteristics spriteModel);
	public void deleteObject(Integer modelID);
	public LevelModel getCurrentLevel();
	public List<LevelModel> getAllLevels();
	public Integer addGoalToLevel(GoalCharacteristics goalModel);
	public void updateGoal(Integer goalID, GoalCharacteristics goalModel);
	public void deleteGoal(Integer goalID);
	public void setCameraType(CameraType c);
	public void setLevelCharacteristics(LevelCharacteristics levelSpecs);
	public void setProgramPhysicsEngine(ProgramPhysicEngine engineType);
	public void setPhysicsEngineUsingParams(int gravity, int drag, int intensity);
	public void setResultOfCollision(CollisionResult result, SpriteCharacteristics s1, SpriteCharacteristics s2);
	public void setCustomParamForCollisionType(CollisionResult result, UserDefinedCollisionParams paramType, int param);
}
