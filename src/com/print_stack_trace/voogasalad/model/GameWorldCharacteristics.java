/**
 * Date Created: 12/02/14
 * Date Modified: 12/06/14
 */

package com.print_stack_trace.voogasalad.model;

import java.util.Date;

public class GameWorldCharacteristics {
	// DEFAULT VARIABLES
	public static final String DEFAULT_GAME_TITLE = "Game";
	public static final String DEFAULT_GAME_AUTHOR = "PrintStackTrace";
	//public static final Date DEFAULT_DATE_CREATED = new Date();
	//public static final Date DEFAULT_DATE_MODIFIED = new Date();
	public static final GameDifficulty DEFAULT_GAME_DIFFICULTY = GameDifficulty.MEDIUM;

    // PRIVATE VARIABLES
    private String gameTitle;
	private String gameAuthor;
    private Date dateCreated;
    private Date dateModified;
    private GameDifficulty gameDifficulty;
    
    public enum GameDifficulty {
    	EASY,
    	MEDIUM,
    	HARD,
    	EXPERT
    }
    
    //-------------------CONSTRUCTORS-------------------//
    public GameWorldCharacteristics() {
    	gameTitle = this.DEFAULT_GAME_TITLE;
    	gameAuthor = this.DEFAULT_GAME_AUTHOR;
    	gameDifficulty = this.DEFAULT_GAME_DIFFICULTY;
    }
    
	//-------------------PUBLIC METHODS-------------------//
    public String toString() {
    	return gameTitle;
    }
    
    //-------------------ACCESSORS-------------------//
	public String getName() {
		return gameTitle;
	}
	public void setName(String name) {
		this.gameTitle = name;
	}
    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }
    public String getGameAuthor() {
		return gameAuthor;
	}

	public void setGameAuthor(String gameAuthor) {
		this.gameAuthor = gameAuthor;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	public GameDifficulty getGameDifficulty() {
		return gameDifficulty;
	}

	public void setGameDifficulty(GameDifficulty gameDifficulty) {
		this.gameDifficulty = gameDifficulty;
	}


}
