/**
 * @author 
 * Date Created: 12/02/14
 * Date Modified: 12/06/14
 */

package com.print_stack_trace.voogasalad.model.engine.authoring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.print_stack_trace.voogasalad.model.GameWorldCharacteristics;

public class GameWorldModel {
    private GameWorldCharacteristics gameWorldCharacteristics;
    private Map<Integer, LevelModel> levelMap;
    private Integer currentLevelIndex;

    //-------------------CONSTRUCTORS-------------------//
    public GameWorldModel() {
        this(null);
    }

    public GameWorldModel(GameWorldCharacteristics gameWorldCharacteristics) {
        this.gameWorldCharacteristics = gameWorldCharacteristics;
        levelMap = new HashMap<Integer, LevelModel>();
        gameWorldCharacteristics = new GameWorldCharacteristics();
    }

    //-------------------ACCESSORS-------------------//
    public GameWorldCharacteristics getGameWorldCharacteristics() {
        return gameWorldCharacteristics;
    }

    public void setGameWorldCharacteristics(
            GameWorldCharacteristics gameWorldCharacteristics) {
        this.gameWorldCharacteristics = gameWorldCharacteristics;
    }

    public LevelModel getLevelModel(int id) {
        return levelMap.get(id);
    }

    public List<LevelModel> getLevels() {
        List<LevelModel> levelSequence = new ArrayList<LevelModel>();
        for(int i=0; i<levelMap.size(); i++)
            levelSequence.add(i,levelMap.get(i));
        return levelSequence;
    }

    public Integer getNumberOfLevels() {
        return levelMap.size();
    }

    public void addLevel(Integer id, LevelModel level) {
        levelMap.put(id, level);
    }

    public LevelModel getCurrentLevel() {
        return levelMap.get(currentLevelIndex);
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
        currentLevelIndex = 0;
        return levelMap.get(currentLevelIndex);
    }

    public void setCurrentLevel(int index) {
        if(index < 0 || index >= levelMap.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if(levelMap.get(index)!= null){
            currentLevelIndex = index;
        }
    }

}
