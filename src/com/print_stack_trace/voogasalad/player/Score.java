package com.print_stack_trace.voogasalad.player;

public class Score {
	/***
	 *  Class used to store Player's current Score
	 *  
	 * Class will probably be deleted --> waiting on pranava and Zach for input of 
	 * where to store scores and highScores
	 */
	 
	private double currentScore;
	
	public Score(){
		currentScore = 0;
	}
	
	public void updateScore(){
		/***
		 * Disregard below --> waiting for pranava and zach for input
		 * 
		 * use some kind of reflection (maybe from constants class)
		 * add constant scores of jumping to new level/ coins/ defeating characters
		 * reflect on that String/object to update score defined in Constants calss
		 */
		
		/***
		 * or just pass in value from Constants Class. For each object (coin, character)
		 * have a value method/parameter
		 */
	}
	
	public double geScore(){
		return currentScore;
	}
}
