package com.print_stack_trace.voogasalad.model.engine.authoring;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.input.KeyCode;

import com.print_stack_trace.voogasalad.exceptions.ElementLockedException;
import com.print_stack_trace.voogasalad.model.GoalCharacteristics;
import com.print_stack_trace.voogasalad.model.LevelCharacteristics;
import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionHandler;
import com.print_stack_trace.voogasalad.model.engine.physics.PhysicsEngine;
import com.print_stack_trace.voogasalad.model.engine.physics.SoloPhysicsHandler;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionFactory.CollisionResult;
import com.print_stack_trace.voogasalad.model.engine.runtime.camera.CameraFactory;
import com.print_stack_trace.voogasalad.model.engine.runtime.keyboard.KeyApplicatorFactory.KeyResult;
import com.print_stack_trace.voogasalad.model.environment.Goal;
import com.print_stack_trace.voogasalad.model.environment.GoalFactory;

public class LevelModel {

    Map<Integer, SpriteCharacteristics> mySpriteMap; //good
    Map<Integer, Goal> goalMap; //good
	private Integer currentID;
    private boolean isLocked;
    private PhysicsEngine physicsEngine;
    private LevelCharacteristics myLevelChars;
    private GoalFactory myGoalFactory;
    private Map<KeyCode, KeyResult> myKeyMap = new HashMap<KeyCode, KeyResult>();
    private Integer mainCharacter;

    public LevelModel(){
        myGoalFactory = new GoalFactory();
        currentID = 0;
        mySpriteMap = new HashMap<>();
        goalMap = new HashMap<>();
        myKeyMap = new HashMap<>();
        myLevelChars = new LevelCharacteristics();
        physicsEngine = new PhysicsEngine();
    }
    
    public LevelModel(LevelModel level) {
    	Map<Integer, SpriteCharacteristics> mySpriteMap=level.mySpriteMap; //good
        Map<Integer, Goal> goalMap=level.goalMap; //good
    	currentID=level.currentID;
        isLocked=level.isLocked;
        physicsEngine=level.physicsEngine;
        myLevelChars = level.myLevelChars;
        myGoalFactory = level.myGoalFactory;
        myKeyMap = level.myKeyMap;
        mainCharacter = level.mainCharacter;
    }

    public PhysicsEngine getPhysicsEngine() {
        return physicsEngine;
    }

    public void setPhysicsEngine(PhysicsEngine physicsEngine) {
        this.physicsEngine = physicsEngine;
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

        int newID = generateID(mySpriteMap);
        mySpriteMap.put(newID, chars);
        return newID;
    }

    public void deleteObject (Integer ModelID) throws ElementLockedException {
        if (isLocked){
            throw new ElementLockedException();
        }
        mySpriteMap.remove(ModelID);
    }

    public void updateObject (Integer ModelID, SpriteCharacteristics chars) 
            throws ElementLockedException {
        if (isLocked) throw new ElementLockedException();
        //if it passes other logic tests including: no collisions
        mySpriteMap.remove(ModelID);
        mySpriteMap.put(ModelID, chars);
    }


    public Integer setGoal(GoalCharacteristics goal) throws ElementLockedException  {
        if (isLocked) throw new ElementLockedException();

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
        if(myLevelChars.requiredNumberOfGoals>goalMap.size()) {
            myLevelChars.requiredNumberOfGoals = myLevelChars.requiredNumberOfGoals - 1;
        }

    }

    public Goal getGoal(Integer id) {
        return goalMap.get(id);
    }
    
    public Map<Integer, Goal> getGoalMap() {
		return goalMap;
	}

    public void setCameraType(CameraFactory.CameraType cameraType)
            throws ElementLockedException {
        if (isLocked) throw new ElementLockedException();
        //in what context can you not set a certain cameraType
        myLevelChars.cameraType = cameraType;
    }

    public CameraFactory.CameraType getCameraType() {
        return myLevelChars.cameraType;
    }

    public void setLevelCharacteristics(LevelCharacteristics levelSpecs)
            throws ElementLockedException {
        if (isLocked) throw new ElementLockedException();
//        if (levelSpecs.requiredNumberOfGoals<0 || levelSpecs.requiredNumberOfGoals > goalMap.size()) {
//            throw new InvalidNumberOfGoalsException();
//        }
//        in what context can you not set a certain cameraType
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

    public void setResultOfCollision(CollisionResult result, SpriteType s1,
            SpriteType s2) throws ElementLockedException {
        if (isLocked) throw new ElementLockedException();
        physicsEngine.setResultOfCollision(result, s1, s2);
    }

    public Map<Integer, SpriteCharacteristics> getSpriteMap() {
        return mySpriteMap;
    }

	public Integer getMainCharacter() {
		return mainCharacter;
	}

	public void setMainCharacter(Integer mainCharacter) {
		this.mainCharacter = mainCharacter;
	}
    
    public void setResultForKey(KeyResult result, KeyCode key) {
    	myKeyMap.put(key, result);
    }
    
    public KeyResult getResultOfKey(KeyCode key) {
        if(!myKeyMap.containsKey(key)) {
            return KeyResult.Default;
        }
    	return myKeyMap.get(key);
    }
    
    public String toString(){
    	//returns name of the level
    	return this.getLevelCharacteristics().getName();
    }
}
