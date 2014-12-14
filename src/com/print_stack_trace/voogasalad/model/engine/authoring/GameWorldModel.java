/**
 * @author 
 * Date Created: 12/02/14
 * Date Modified: 12/06/14
 */

package com.print_stack_trace.voogasalad.model.engine.authoring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.print_stack_trace.voogasalad.model.GameWorldCharacteristics;
import com.print_stack_trace.voogasalad.model.LevelCharacteristics;

public class GameWorldModel {
    private GameWorldCharacteristics gameWorldCharacteristics;
    private Map<Integer, LevelModel> levelMap;
    private Integer currentLevelIndex;
    private static final int FIRST_LEVEL_INDEX = 1;

    //-------------------CONSTRUCTORS-------------------//
    public GameWorldModel() {
        levelMap = new HashMap<Integer, LevelModel>();
        gameWorldCharacteristics = new GameWorldCharacteristics();
    }

    public GameWorldModel(GameWorldCharacteristics gameWorldCharacteristics) {
        this();
    	this.gameWorldCharacteristics = gameWorldCharacteristics;
    }

    //-------------------ACCESSORS-------------------//
    public GameWorldCharacteristics getGameWorldCharacteristics() {
        return gameWorldCharacteristics;
    }

    public void setGameWorldCharacteristics(
            GameWorldCharacteristics gameWorldCharacteristics) {
        this.gameWorldCharacteristics = gameWorldCharacteristics;
    }
    
    public Map<Integer, LevelModel> getLevelMap() {
    	return levelMap;
    }

    public LevelModel getLevelModel(int id) {
        if(levelMap.size()==0)
            return null;
        return levelMap.get(id);
    }

    public Integer getNumberOfLevels() {
        return levelMap.size();
    }

    public void addLevel(Integer id, LevelModel levelModel) {
        levelMap.put(id, levelModel);
    }
    
    public void addLevel(Integer id, LevelCharacteristics levelCharacteristics) {
        LevelModel levelModel = new LevelModel();
        if(id != 1)
            levelModel.getPhysicsEngine().setDecisionMatrix(levelMap.get(id-1).getPhysicsEngine().getDecisionMatrix());
        levelCharacteristics.setID(id);
        levelModel.setLevelCharacteristics(levelCharacteristics);
    	levelMap.put(id, levelModel);
   }

    public LevelModel getCurrentLevel() {
    	return levelMap.get(currentLevelIndex);
    }
    
    public void setCurrentLevel(int index) {
        if(index < FIRST_LEVEL_INDEX) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if(levelMap.get(index) == null) {
            levelMap.put(index,new LevelModel());
        }
        currentLevelIndex = index;
    }
    
    public LevelModel getNextLevel() {
        currentLevelIndex++;
        return levelMap.get(currentLevelIndex);
    }


    //-------------------PUBLIC METHODS-------------------//	
    public boolean verifyWorldIntegrity() {
        //TODO: implement this!
        return false;
    }

    public LevelModel startNewGame() {
        currentLevelIndex = FIRST_LEVEL_INDEX;
        return levelMap.get(currentLevelIndex);
    }
    
    public String toString() {
    	return "Game-" + gameWorldCharacteristics.toString();
    }

}
