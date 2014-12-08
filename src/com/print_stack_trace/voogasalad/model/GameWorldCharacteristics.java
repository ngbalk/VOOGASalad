/**
 * @author 
 * Date Created: 12/02/14
 * Date Modified: 12/06/14
 */

package com.print_stack_trace.voogasalad.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.print_stack_trace.voogasalad.model.engine.authoring.LevelModel;

public class GameWorldCharacteristics {
    // DEFAULT VARIABLES
	
	
    // GAME AUTHORING VARIABLES
    private String gameTitle;
    private List<LevelModel> levels;
    private List<LevelModel> levelSequence;
    private int currentLevel;
    
    //TODO: More...
    
    //-------------------CONSTRUCTORS-------------------//
    public GameWorldCharacteristics() {
        levels = new ArrayList<>();
        levelSequence = new LinkedList<>();
        currentLevel = 0;
    }
    
	//-------------------PUBLIC METHODS-------------------//
    public String getGameTitle() {
        return gameTitle;
    }
    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }
    public List<LevelModel> getLevels() {
        return levels;
    }
    public void setLevels(List<LevelModel> levels) {
        this.levels = levels;
    }
    public int getNumberOfLevels() {
        return levels.size();
    }
    
    
    //-------------------ACCESSORS-------------------//

    public void addLevel(LevelModel level) {
        levels.add(level);
    }

    public LevelModel getNextLevel() {
        LevelModel nextLevel = levelSequence.get(currentLevel);
        currentLevel ++;
        return nextLevel;
    }

    public LevelModel startNewGame() {
        currentLevel = 0;
        return levelSequence.get(0);
    }
    
    
    public boolean verifyWorldIntegrity() {
        return levels.size() == levelSequence.size();
    }
    
    public void createGameSequence() {
        LevelModel currentLevel = new LevelModel();
        for(LevelModel level: levels) {
            if(level.getLevelCharacteristics().previousLevel == null) {
                currentLevel = level;
                levelSequence.add(currentLevel);
                break;
            }
        }
        for(int i =0; i< levels.size(); i++) {
            for(int j=0; j< levels.size(); j++) {
                if(levels.get(j).getLevelCharacteristics().ID == currentLevel.getLevelCharacteristics().nextLevel) {
                    currentLevel = levels.get(j);
                }
            }
        }
    }

}
