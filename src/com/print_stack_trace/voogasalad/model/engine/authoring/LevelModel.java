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
/**
 * 
 * @author Ethan Chang, Jack Baskin, Nick Widmaier
 * Object containing any information a level might need:
 * sprites, physics engine, and key mappings for that level
 */
public class LevelModel {

	private Map<Integer, GoalCharacteristics> goalMap; // good
	private Map<Integer, SpriteCharacteristics> mySpriteMap; // good
	private Integer currentID;
	private boolean isLocked;
	private PhysicsEngine physicsEngine;
	private LevelCharacteristics myLevelChars;
	private GoalFactory myGoalFactory;
	private Map<KeyCode, KeyResult> myKeyMap = new HashMap<KeyCode, KeyResult>();
	private Integer mainCharacter;

	/**
     * Initializes all of the major collections
     * for the level
     */
	public LevelModel() {
		myGoalFactory = new GoalFactory();
		currentID = 0;
		mySpriteMap = new HashMap<>();
		goalMap = new HashMap<>();
		myKeyMap = new HashMap<>();
		myLevelChars = new LevelCharacteristics();
		physicsEngine = new PhysicsEngine();
		//mainCharacter = 0;
	}

	public LevelModel(LevelModel level) {
		Map<Integer, SpriteCharacteristics> mySpriteMap = level.mySpriteMap; // good
		Map<Integer, GoalCharacteristics> goalMap = level.goalMap; // good
		currentID = level.currentID;
		isLocked = level.isLocked;
		physicsEngine = level.physicsEngine;
		myLevelChars = level.myLevelChars;
		myGoalFactory = level.myGoalFactory;
		myKeyMap = level.myKeyMap;
		mainCharacter = level.mainCharacter;
	}
    /**
     * returns the level's current physics engine
     * @return
     */
	public PhysicsEngine getPhysicsEngine() {
		return physicsEngine;
	}

	public void setPhysicsEngine(PhysicsEngine physicsEngine) {
		this.physicsEngine = physicsEngine;
	}
    /**
     * Generates a new, unique id for a new object being
     * added in the authoring environment.
     * @param map map of sprites on the map
     * @return the id just generated
     */
	private Integer generateID(Map map) {
		while (map.keySet().contains(currentID)) {
			currentID++;
		}
		return currentID;
	}
    /**
     * If a level is being tested, object shouldn't be allowed to
     * be added to the level, so we lock these methods
     */
	public void setLocked() {
		isLocked = true;
	}
    /**
     * unlocks methods, allowing objects to be added
     */
	public void setUnlocked() {
		isLocked = false;
	}
    /**
     * Adds a new object Spritecharacteristics file to the level.
     * @param chars
     * @return
     * @throws ElementLockedException
     */
	public Integer addObject(SpriteCharacteristics chars)
			throws ElementLockedException {
		if (isLocked) {
			throw new ElementLockedException();
		}

		int newID = generateID(mySpriteMap);
		mySpriteMap.put(newID, chars);
		if (chars.getObjectType() == SpriteType.HERO) {
			setMainCharacter(newID);
		}
		return newID;
	}
    /**
     * Removed a model from the level
     * @param ModelID
     * @throws ElementLockedException
     */
	public void deleteObject(Integer ModelID) throws ElementLockedException {
		if (isLocked) {
			throw new ElementLockedException();
		}
		mySpriteMap.remove(ModelID);
	}
    /**
     * Updates a specific ID with a new SpriteCharacteristic
     * @param ModelID
     * @param chars
     * @throws ElementLockedException
     */
	public void updateObject(Integer ModelID, SpriteCharacteristics chars)
			throws ElementLockedException {
		if (isLocked)
			throw new ElementLockedException();
		// if it passes other logic tests including: no collisions
		mySpriteMap.remove(ModelID);
		mySpriteMap.put(ModelID, chars);
		if (chars.getObjectType() == SpriteType.HERO) {
			setMainCharacter(ModelID);
		}
	}
    /**
     * Adds a new goal for the level
     * @param goal
     * @return id of the added goal
     * @throws ElementLockedException
     */
	public Integer setGoal(GoalCharacteristics goal)
			throws ElementLockedException {
		if (isLocked)
			throw new ElementLockedException();

		int newID = generateID(goalMap);
		goalMap.put(newID, goal);
		return newID;

	}
    /**
     * Updates an existing goal with a new set of characteristics
     * @param goalID
     * @param goal
     * @throws ElementLockedException
     */
	public void updateGoal(Integer goalID, GoalCharacteristics goal)
			throws ElementLockedException {
		if (isLocked)
			throw new ElementLockedException();
		goalMap.remove(goalID);
		if (!goalMap.containsValue(goal))
			goalMap.put(goalID, goal);

	}
    /**
     * Removeds a goal from the level
     * @param goalID
     * @throws ElementLockedException
     */
	public void deleteGoal(Integer goalID) throws ElementLockedException {
		if (isLocked)
			throw new ElementLockedException();
		goalMap.remove(goalID);
		if (myLevelChars.requiredNumberOfGoals > goalMap.size()) {
			myLevelChars.requiredNumberOfGoals = myLevelChars.requiredNumberOfGoals - 1;
		}

	}
    /**
     * Get a specific goal from the level
     * @param id
     * @return the goal corresponding to id
     */
	public GoalCharacteristics getGoal(Integer id) {
		return goalMap.get(id);
	}
    /**
     * Retrieves a map containing all the goals
     * @return map of all the goals
     */
	public Map<Integer, GoalCharacteristics> getGoalMap() {
		return goalMap;
	}

    /**
     * sets the levels camera type
     * @param cameraType
     * @throws ElementLockedException
     */
	public void setCameraType(CameraFactory.CameraType cameraType)
			throws ElementLockedException {
		if (isLocked)
			throw new ElementLockedException();
		// in what context can you not set a certain cameraType
		myLevelChars.cameraType = cameraType;
	}

	public CameraFactory.CameraType getCameraType() {
		return myLevelChars.cameraType;
	}
	
    /**
     * Set the properties for the level
     * @param levelSpecs
     * @throws ElementLockedException
     */
	public void setLevelCharacteristics(LevelCharacteristics levelSpecs)
			throws ElementLockedException {
		if (isLocked)
			throw new ElementLockedException();
		// if (levelSpecs.requiredNumberOfGoals<0 ||
		// levelSpecs.requiredNumberOfGoals > goalMap.size()) {
		// throw new InvalidNumberOfGoalsException();
		// }
		// in what context can you not set a certain cameraType
		myLevelChars = levelSpecs;
	}
	
    /**
     * Retrieve the levelCharacteristics file for the level
     * @return levelCharacteristics for the level
     */
	public LevelCharacteristics getLevelCharacteristics() {
		return myLevelChars;
	}
	
    /**
     * Set a physics handler for the level
     * @param soloHandler
     * @throws ElementLockedException
     */
	public void setSoloHandler(SoloPhysicsHandler soloHandler)
			throws ElementLockedException {
		if (isLocked)
			throw new ElementLockedException();
		physicsEngine.setSoloHandler(soloHandler);

	}
	
    /**
     * sets the collisionhandler for the level
     * @param result
     * @param handler
     * @throws ElementLockedException
     */
	public void setCollisionHandlerForResult(CollisionResult result,
			CollisionHandler handler) throws ElementLockedException {
		if (isLocked)
			throw new ElementLockedException();
		physicsEngine.setHandlerForResult(result, handler);
	}
	
    /**
     * set results for the collisions of two sprites
     * @param result
     * @param s1
     * @param s2
     * @throws ElementLockedException
     */
	public void setResultOfCollision(CollisionResult result, SpriteType s1,
			SpriteType s2) throws ElementLockedException {
		if (isLocked)
			throw new ElementLockedException();
		physicsEngine.setResultOfCollision(result, s1, s2);
	}

	public Map<Integer, SpriteCharacteristics> getSpriteMap() {
		return mySpriteMap;
	}

	public void setSpriteMap(Map<Integer, SpriteCharacteristics> spriteMap) {
		this.mySpriteMap = spriteMap;
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
		if (!myKeyMap.containsKey(key)) {
			return KeyResult.Default;
		}
		return myKeyMap.get(key);
	}

	public String toString() {
		// returns name of the level
		return this.getLevelCharacteristics().getName();
	}
}
