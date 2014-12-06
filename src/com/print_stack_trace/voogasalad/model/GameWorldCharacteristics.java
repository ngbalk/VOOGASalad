/**
 * @author 
 * Date Created: 12/02/14
 * Date Modified: 12/06/14
 */

package com.print_stack_trace.voogasalad.model;

import java.util.List;

import com.print_stack_trace.voogasalad.model.engine.authoring.LevelModel;

public class GameWorldCharacteristics {
	// DEFAULT VARIABLES
	
	
	// GAME AUTHORING VARIABLES
	private String gameTitle;
	private List<LevelModel> levels;
	
	//TODO: More...

	//-------------------CONSTRUCTORS-------------------//
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

		
}
