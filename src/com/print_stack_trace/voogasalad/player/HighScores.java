package com.print_stack_trace.voogasalad.player;

import java.util.HashMap;
import java.util.Map;

public class HighScores {
	/***
	 * Class used to Store HighScores for the game
	 * Class will probably be deleted --> waiting on pranava and Zach for input of 
	 * where to store scores and highScores
	 */
	private double highestScore;
	//private double currentScore;
	private Map<String,Double> scores; //change String to Player Object (if created)
	public HighScores(){
		scores = new HashMap<String,Double>();
	}
	
	public void resetHighScores(){
		scores.clear();
	}
	
	public void updateScore(Character p, double score){
		//check is player score already exist
		//check if current player score is greater than high score
		//add/edit high score
	}
	public String toString() {
		//iterate over map, print HighScores
		return null;
	}
	
}
