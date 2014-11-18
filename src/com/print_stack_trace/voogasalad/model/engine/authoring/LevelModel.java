package com.print_stack_trace.voogasalad.model.engine.authoring;

import java.util.HashMap;
import java.util.Map;

import com.print_stack_trace.voogasalad.exceptions.ElementLockedException;
import com.print_stack_trace.voogasalad.model.GoalCharacteristics;
import com.print_stack_trace.voogasalad.model.LevelCharacteristics;
import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.CameraType;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionHandler;
import com.print_stack_trace.voogasalad.model.engine.physics.PhysicsEngine;
import com.print_stack_trace.voogasalad.model.engine.physics.SoloPhysicsHandler;
import com.print_stack_trace.voogasalad.model.engine.physics.PhysicsEngine.CollisionResult;
import com.print_stack_trace.voogasalad.model.environment.Goal;
import com.print_stack_trace.voogasalad.model.environment.GoalFactory;

public class LevelModel {

	Map<Integer, SpriteCharacteristics> spriteMap;
	Map<Integer, Goal> goalMap;
	private Integer currentID;
	private boolean isLocked;
	private PhysicsEngine physicsEngine;
	private CameraType myCameraType;
	private LevelCharacteristics myLevelChars;
	private GoalFactory myGoalFactory;

	public LevelModel(){
		myGoalFactory = new GoalFactory();
		currentID = 0;
		spriteMap = new HashMap<>();
		goalMap = new HashMap<>();
	}
	
	public PhysicsEngine getPhysicsEngine() {
		return physicsEngine;
	}

	private Integer generateID(Map map) {
		while(map.keySet().contains(currentID)) {
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

	public Integer addObject (SpriteCharacteristics chars) throws ElementLockedException {
		if (isLocked){
			throw new ElementLockedException();
		}

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

		int newID = generateID(spriteMap);
		spriteMap.put(newID, chars);
		return newID;
	}

	public void deleteObject (Integer ModelID) throws ElementLockedException {
		if (isLocked){
			throw new ElementLockedException();
		}
		spriteMap.remove(ModelID);
	}

	public void updateObject (Integer ModelID, SpriteCharacteristics chars) 
			throws ElementLockedException {
		if (isLocked) throw new ElementLockedException();
		//if it passes other logic tests including: no collisions
		spriteMap.remove(ModelID);
		spriteMap.put(ModelID, chars);
	}

	//TODO: Talk to authoring about how goals are implemented 
	//      this is needed to implement this method.
	public Integer setGoal(GoalCharacteristics goal) throws ElementLockedException  {
		if (isLocked) throw new ElementLockedException();

		//what determines if a goal can be set?
		int newID = generateID(goalMap);
		goalMap.put(newID, myGoalFactory.buildGoal(goal));
		return newID;

	}
	
	public void updateGoal(Integer goalID, GoalCharacteristics goal)
	throws ElementLockedException{
		if(isLocked) throw new ElementLockedException();
		goalMap.remove(goalID);
		goalMap.put(goalID, myGoalFactory.buildGoal(goal));
		
	}
	
	public void deleteGoal(Integer goalID) throws ElementLockedException{
		if(isLocked) throw new ElementLockedException();
		goalMap.remove(goalID);

	}


	public Goal getGoal(Integer id) {
		return goalMap.get(id);
	}

	public void setCameraType(CameraType cameraType)
			throws ElementLockedException {
		if (isLocked) throw new ElementLockedException();
		//in what context can you not set a certain cameraType
		myCameraType = cameraType;
	}

	public CameraType getCameraType() {
		return myCameraType;
	}

	public void setLevelCharacteristics(LevelCharacteristics levelSpecs)
			throws ElementLockedException {
		if (isLocked) throw new ElementLockedException();
		//in what context can you not set a certain cameraType
		myLevelChars = levelSpecs;
	}

	public LevelCharacteristics getLevelCharacteristics() {
		return myLevelChars;
	}

	public void setSoloHandler(SoloPhysicsHandler soloHandler)
			throws ElementLockedException {
		if (isLocked) throw new ElementLockedException();
		physicsEngine.setSoloHandler(soloHandler);

	}

	public void setCollisionHandlerForResult(CollisionResult result,
			CollisionHandler handler) throws ElementLockedException  {
		if (isLocked) throw new ElementLockedException();
		physicsEngine.setHandlerForResult(result, handler);
	}

	public void setResultOfCollision(CollisionResult result, SpriteCharacteristics s1,
			SpriteCharacteristics s2) throws ElementLockedException {
		if (isLocked) throw new ElementLockedException();
		physicsEngine.setResultOfCollision(result, s1, s2);
	}
}
