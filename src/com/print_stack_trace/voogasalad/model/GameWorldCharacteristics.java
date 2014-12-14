/**
 * @author 
 * Date Created: 12/02/14
 * Date Modified: 12/06/14
 */

package com.print_stack_trace.voogasalad.model;

public class GameWorldCharacteristics {
    // DEFAULT VARIABLES
	
	
    // GAME AUTHORING VARIABLES
    private String gameTitle;
    
    //TODO: More...
    
    //-------------------CONSTRUCTORS-------------------//
    public GameWorldCharacteristics() {
    	
    }
    
	//-------------------PUBLIC METHODS-------------------//
    
    
    //-------------------ACCESSORS-------------------//
	public String getName() {
		return gameTitle;
	}
    public String getGameTitle() {
        return gameTitle;
    }
    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

}
