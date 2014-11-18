package com.print_stack_trace.voogasalad.model.data;

public class HighScore {
	private String myName;
	private Integer myScore;
	
	public HighScore(String player, Integer score){
		myName = player;
		myScore = score;
	}
	
	public String getPlayerName(){
		return this.myName;
	}
	
	public Integer getMyScore(){
		return this.myScore;
	}
	
}
