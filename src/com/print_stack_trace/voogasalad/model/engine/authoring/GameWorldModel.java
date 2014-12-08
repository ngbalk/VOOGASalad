/**
 * @author 
 * Date Created: 12/02/14
 * Date Modified: 12/06/14
 */

package com.print_stack_trace.voogasalad.model.engine.authoring;

import java.util.ArrayList;
import java.util.List;

import com.print_stack_trace.voogasalad.model.GameWorldCharacteristics;

public class GameWorldModel {
	private List<LevelModel> levels;

	private GameWorldCharacteristics gameWorldCharacteristics;
	
	//-------------------CONSTRUCTORS-------------------//
	public GameWorldModel() {
		levels = new ArrayList<LevelModel>();
		gameWorldCharacteristics = new GameWorldCharacteristics();
	}
	
	//-------------------PUBLIC METHODS-------------------//
	public void addLevel(LevelModel newLevel) {
		levels.add(newLevel);
	}
	
	public void addLevel(LevelModel newLevel, int index) {
		levels.add(index,newLevel);
	}
	
	//-------------------ACCESSORS-------------------//
	public List<LevelModel> getLevels() {
		return levels;
	}

	public void setLevels(List<LevelModel> levels) {
		this.levels = levels;
	}
	
	public Integer getNumberOfLevels() {
		return levels.size();
	}

	public GameWorldCharacteristics getGameWorldCharacteristics() {
		return gameWorldCharacteristics;
	}

	public void setGameWorldCharacteristics(
			GameWorldCharacteristics gameWorldCharacteristics) {
		this.gameWorldCharacteristics = gameWorldCharacteristics;
	}
	
}
