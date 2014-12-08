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
    private List<LevelModel> levelSequence;
    private Integer currentLevelIndex;
	
	//-------------------CONSTRUCTORS-------------------//
	public GameWorldModel() {
		levelMap = new HashMap<Integer, LevelModel>();
		levelSequence = new ArrayList<LevelModel>();
		gameWorldCharacteristics = new GameWorldCharacteristics();
	}
	
	//-------------------PUBLIC METHODS-------------------//	
    public boolean verifyWorldIntegrity() {
        return levelMap.size() == levelSequence.size();
    }
    
    public void createGameSequence() {
        LevelModel currentLevel = new LevelModel();
        for(Integer id: levelMap.keySet()) {
            if(levelMap.get(id).getLevelCharacteristics().previousLevel == null) {
                currentLevel = levelMap.get(id);
                levelSequence.add(currentLevel);
                break;
            }
        }
        for(int i =0; i< levelMap.size(); i++) {
            for(int j=0; j< levelMap.size(); j++) {
                if(levelMap.get(levelMap.get(j)).getLevelCharacteristics().ID == currentLevel.getLevelCharacteristics().nextLevel) {
                    currentLevel = levelMap.get(j);
                    break;
                }
            }
            if(currentLevel.getLevelCharacteristics().nextLevel == null) {
                break;
            }
        }
    }
    
    public LevelModel startNewGame() {
    	currentLevelIndex = 0;
        return levelSequence.get(0);
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
		return levelSequence;
	}
	
	public Integer getNumberOfLevels() {
		return levelMap.size();
	}
	
    public void addLevel(Integer id, LevelModel level) {
        levelMap.put(id, level);
    }

    public LevelModel getNextLevel() {
        LevelModel nextLevel = levelSequence.get(currentLevelIndex);
        currentLevelIndex++;
        return nextLevel;
    }
    
	
}
