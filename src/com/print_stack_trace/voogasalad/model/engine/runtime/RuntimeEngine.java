/**
 * @author Pranava Raparla
 * Date Created: 11/10/14
 * Date Modified: 11/21/14
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

public class RuntimeEngine extends AbstractRuntimeEngine {
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
     * Takes in a LevelModel and sets private variables
     * @param level
     */
    public RuntimeEngine(LevelModel currentLevel, Dimension viewport) {
        super(currentLevel);
        runtimeModel = new RuntimeModel(currentLevel, viewport);
        physicsEngine = currentLevel.getPhysicsEngine();
        goalFactory = new GoalFactory();
        goalMap = new HashMap<>();
        populateGoalMap();
        cameraHandler = CameraFactory.buildCameraHandler(currentLevel.getLevelCharacteristics().cameraType);
        this.viewport = viewport;
    }
    
    public RuntimeEngine(GameWorldModel gameWorld, Dimension viewport) {
        super(gameWorld);
        this.viewport = viewport;
        currentLevel = gameWorld.getCurrentLevel();
        createRuntimeState(currentLevel, viewport);
    }

    private void createRuntimeState(LevelModel levelModel, Dimension viewport) {
        runtimeModel = new RuntimeModel(gameWorld.getCurrentLevel(), viewport);
        physicsEngine = gameWorld.getCurrentLevel().getPhysicsEngine();
        goalFactory = new GoalFactory();
        goalMap = new HashMap<>();
        populateGoalMap();
        cameraHandler = CameraFactory.buildCameraHandler(currentLevel.getLevelCharacteristics().cameraType);
    }

    //-------------------PUBLIC METHODS-------------------//

    private void getNextLevel() {
        System.out.println(gameWorld);
        currentLevel = gameWorld.getNextLevel();
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
                System.out.println("YOU WIN");
                runtimeModel.gameOver = true;
                runtimeModel.gameVictory = true;
                getNextLevel();
            }
        }
        
		RuntimeSpriteCharacteristics mainChar = runtimeModel.getRuntimeSpriteMap().get(runtimeModel.mainChar);
		if(gameOver(mainChar)){
			System.out.println("YOU DIED BITCH");
			runtimeModel.gameOver = true;
			runtimeModel.gameVictory = false;
		}
		updateSpritePositions();
		
		cameraHandler.updateCamera(runtimeModel);
    }

    public void setFramesPerSecond(int framesPerSecond) {
        this.framesPerSecond = framesPerSecond;
    }

    //GAME PLAYER

    /**
     * Get the current state of the level in progress
     * @return runtimeModel 
     */
    public RuntimeModel getStatus() {
        return runtimeModel;
    }

    public void handleKeyRelease(KeyEvent event) {
        handleKey(event, false);
    }

    public void handleKeyPress(KeyEvent event) {
        handleKey(event, true);
    }
    
    public void populateGoalMap(){
        for(Integer i : runtimeModel.getGoalMap().keySet()){
            goalMap.put(i, goalFactory.buildGoal(runtimeModel.getGoalMap().get(i)));
        }
    }
	
    
    //-------------------ACCESSORS-------------------//


    //-------------------PRIVATE METHODS-------------------//

    //Sprites move around even when this method is commented out
    //why is that? this method should be the one controlling movement
    private void updateSpritePositions(){
        for(RuntimeSpriteCharacteristics rst : runtimeModel.getRuntimeSpriteMap().values()) {
            rst.setX(rst.getX()+((double)rst.v_x/(double)framesPerSecond));
            rst.setY(rst.getY()+((double)rst.v_y/(double)framesPerSecond));
            rst.v_x *= (1.0f-rst.getDecelerationConstant());
            rst.v_y *= (1.0f-rst.getDecelerationConstant());
        }
    }

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
    
	private boolean gameOver(RuntimeSpriteCharacteristics mainChar){
	    if(mainChar == null) return false;
	    return(mainChar.getPropertyReadOnlyHealth().getValue() <= 0 || mainChar.getY() > (runtimeModel.camera.y + runtimeModel.viewport.height));
                    
	}

    public LevelModel startNewGame () {
        return gameWorld.startNewGame();
    }
}
