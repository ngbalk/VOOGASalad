/**
 * @author Pranava Raparla
 * Date Created: 11/10/14
 * Date Modified: 12/13/14
 */

package com.print_stack_trace.voogasalad.model.engine.runtime;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.input.KeyEvent;

import com.print_stack_trace.voogasalad.model.GoalCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameWorldModel;
import com.print_stack_trace.voogasalad.model.engine.authoring.LevelModel;
import com.print_stack_trace.voogasalad.model.engine.physics.PhysicsEngine;
import com.print_stack_trace.voogasalad.model.engine.runtime.camera.CameraFactory;
import com.print_stack_trace.voogasalad.model.engine.runtime.camera.CameraHandler;
import com.print_stack_trace.voogasalad.model.engine.runtime.keyboard.KeyApplicationChecker;
import com.print_stack_trace.voogasalad.model.engine.runtime.keyboard.KeyApplicator;
import com.print_stack_trace.voogasalad.model.engine.runtime.keyboard.KeyApplicatorFactory;
import com.print_stack_trace.voogasalad.model.engine.runtime.keyboard.KeyApplicatorFactory.KeyResult;
import com.print_stack_trace.voogasalad.model.environment.Goal;
import com.print_stack_trace.voogasalad.model.environment.GoalFactory;

/**
 * This class contains our implementation of the IRuntimeEngine interface.
 * The purpose of this class is be the primary point of access for runtime
 * actions. All of the runtime methods that the front end calls through game
 * engine are passed through to RuntimeEngine. In this way, we can modify our
 * implementation of RuntimeEngine without any changes to the front end's
 * method call structure.
 *
 */
public class RuntimeEngine implements IRuntimeEngine {
	
	/**
	 * Private Variables for use in Runtime.
	 */
	private LevelModel currentLevel;
	private GameWorldModel gameWorld;
    private PhysicsEngine physicsEngine;
    private RuntimeModel runtimeModel;
    int framesPerSecond;
    private Map<KeyResult, KeyApplicator> applicatorCache = new HashMap<KeyResult, KeyApplicator>();
    private GoalFactory goalFactory;
    private Map<Integer, Goal> goalMap;
    private CameraHandler cameraHandler;
    private Dimension viewport;
    private int completedGoalCount = 0;


    //-------------------CONSTRUCTORS-------------------//

    /**
     * Takes in a LevelModel and viewport to set private variables
     * through calling a helper method.
     * @param currentLevel
     * @param viewport
     */
    public RuntimeEngine(LevelModel currentLevel, Dimension viewport) {
		this.currentLevel = currentLevel;
        createRuntimeState(currentLevel, viewport);
    }
    /**
     * Takes in a GameWorldModel and viewport to set private variables
     * through calling a helper method.
     * @param currentLevel
     * @param viewport
     */
    public RuntimeEngine(GameWorldModel gameWorld, Dimension viewport) {
	    this.gameWorld = gameWorld;
        currentLevel = gameWorld.getCurrentLevel();
        createRuntimeState(currentLevel, viewport);
    }
    /**
     * This helper method takes in a LevelModel and viewport to set private variables.
     * @param currentLevel
     * @param viewport
     */
    private void createRuntimeState(LevelModel levelModel, Dimension viewport) {
        runtimeModel = new RuntimeModel(gameWorld.getCurrentLevel(), viewport);
        physicsEngine = gameWorld.getCurrentLevel().getPhysicsEngine();
        goalFactory = new GoalFactory();
        goalMap = new HashMap<>();
        populateGoalMap();
        cameraHandler = CameraFactory.buildCameraHandler(currentLevel.getLevelCharacteristics().cameraType);
        this.viewport = viewport;
    }

    //-------------------PUBLIC METHODS-------------------//

    private void getNextLevel() {
        currentLevel = gameWorld.getNextLevel();
        if(currentLevel == null){
            runtimeModel.gameTotallyOver = true;
            return;
        }
        createRuntimeState(currentLevel, viewport);
    }
    
    /**
     * Update all of the data in the current level.
     * 1. Calls PhysicsEngine to "animate" sprites.
     * 2. Apply unexpired key events.
     * 3. Use GoalChecker to check goals
     * 4. See if game is over or not
     * 5. Move camera
     * @param currentLevel
     */
    public void update() {
        physicsEngine.animateAll(runtimeModel, framesPerSecond);
        GoalChecker goalChecker = new GoalChecker(runtimeModel);
        int completedCount = 0;
        for(Goal g : goalMap.values()) {
            g.acceptChecker(goalChecker);
            if(g.isCompleted)completedCount++;
        }
        int reqGoals = runtimeModel.getLevelCharacteristics().requiredNumberOfGoals;
        if (reqGoals > 0) {
            if(completedCount >= runtimeModel.getLevelCharacteristics().requiredNumberOfGoals) {
                winGame();
                getNextLevel();
            }
        }
		RuntimeSpriteCharacteristics mainChar = runtimeModel.getRuntimeSpriteMap().get(runtimeModel.mainChar);
		if(gameOver(mainChar)){
			loseGame();
		}
		updateSpritePositions();
		cameraHandler.updateCamera(runtimeModel);
    }
    
    /**
     * This method sets the FPS for the Game Player in runtime.
     * @param framesPerSecond
     */
    public void setFramesPerSecond(int framesPerSecond) {
        this.framesPerSecond = framesPerSecond;
    }
    
    /**
     * This method returns the current state of the level in progress.
     * @return runtimeModel 
     */
    public RuntimeModel getStatus() {
        return runtimeModel;
    }
    
    /**
     * This method starts a new game through calling the gameWorld's
     * start new game method. It is a pass through method.
     * @return levelModel
     */
    public LevelModel startNewGame () {
        return gameWorld.startNewGame();
    }
    
    /**
     * This method handles Key Release Events.
     */
    public void handleKeyRelease(KeyEvent event) {
        handleKey(event, false);
    }
    /**
     * This method handles Key Press Events.
     */
    public void handleKeyPress(KeyEvent event) {
        handleKey(event, true);
    }
    
    /**
     * This method loops through the Goals in the RuntimeModel's goal map
     * and puts new GoalCharacteristics through using the goal factory.
     */
    public void populateGoalMap(){
        for(Integer i : runtimeModel.getGoalMap().keySet()){
            goalMap.put(i, goalFactory.buildGoal(runtimeModel.getGoalMap().get(i)));
        }
    }

	//-------------------PRIVATE METHODS-------------------//
    
    /**
     * This method sets the states in RuntimeModel for
     * a game win to be registered.
     */
    private void winGame() {
    	runtimeModel.gameOver = true;
        runtimeModel.gameVictory = true;
    }
    /**
     * This method sets the states in RuntimeModel for
     * a game loss to be registered.
     */
    private void loseGame() {
    	runtimeModel.gameOver = true;
        runtimeModel.gameVictory = false;
    }
    
    /**
     * This method updates all the sprite positions by accessing their
     * velocities and updating their x and y data.
     */
	private void updateSpritePositions(){
		for(RuntimeSpriteCharacteristics rst : runtimeModel.getRuntimeSpriteMap().values()) {
			rst.setX(rst.getX()+((double)rst.v_x/(double)framesPerSecond));
			rst.setY(rst.getY()+((double)rst.v_y/(double)framesPerSecond));
			rst.v_x *= (1.0f-rst.getDecelerationConstant());
			rst.v_y *= (1.0f-rst.getDecelerationConstant());
		}
	}
	
	/**
	 * This method takes in a key event and a boolean to determine what action
	 * should result based on the authored data that was stored in LevelModel and
	 * transferred to RuntimeModel.
	 * @param event
	 * @param press
	 */
	private void handleKey(KeyEvent event, boolean press) {
		KeyResult res = runtimeModel.getResultOfKey(event.getCode());
		KeyApplicator applicator = applicatorCache.get(res);
		Integer mainChar = runtimeModel.getMainCharacter();
		RuntimeSpriteCharacteristics mainCharData = runtimeModel.getRuntimeSpriteMap().get(mainChar);
		if(applicator == null) {
			applicator = KeyApplicatorFactory.buildKeyApplicator(res);
			applicatorCache.put(res, applicator);
		}
		if(press && KeyApplicationChecker.doesKeyApply(res, mainCharData)) {
			applicator.applyPressActionToRuntimeSprite(mainCharData);
		}
		else{
			applicator.applyReleaseActionToRuntimeSprite(mainCharData);
			return;
		}
	}
	
	/**
	 * This method takes in the main character and determines if it is still "alive."
	 * If the player is not alive in the game, then true will be returned.
	 * @param mainChar
	 * @return bool
	 */
	private boolean gameOver(RuntimeSpriteCharacteristics mainChar){
	    if(mainChar == null) return true;
	    return(mainChar.getPropertyReadOnlyHealth().getValue() <= 0 || mainChar.getY() > (runtimeModel.camera.y + runtimeModel.viewport.height));
	}

}
