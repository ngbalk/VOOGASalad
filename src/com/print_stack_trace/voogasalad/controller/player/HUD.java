package com.print_stack_trace.voogasalad.controller.player;

import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class HUD extends HBox {
	
	private static final String pointsBaseText = "Points: ";
	private static final String livesBaseText = "Lives: ";
	private static final String healthBaseText = "Health: ";
	private static final int mySpacing = 50;
	private int myHealth = 1;
	private int myLives = 1;
	private int myPoints = 0;
	private Text healthText;
	private Text livesText;
	private Text pointsText;

	public HUD(){
		super(mySpacing);
		healthText = new Text(healthBaseText + Integer.toString(myHealth));
		livesText = new Text(livesBaseText + Integer.toString(myLives));
		pointsText = new Text(pointsBaseText + Integer.toString(myPoints ));
		this.getChildren().addAll(healthText, livesText, pointsText); 
	}
	
	public void updateHealth(int health){
		healthText.setText(healthBaseText + Integer.toString(health));
		myHealth = health;
	}
	
	public void updateLives(int lives){
		livesText.setText(livesBaseText + Integer.toString(lives));
		myLives = lives;
	}
	
	public void updatePoints(int points){
		pointsText.setText(pointsBaseText + Integer.toString(points));
		myPoints = points;
	}
	
	public int getPoints(){
		return this.myPoints;
	}
	
	public int getLives(){
		return this.myLives;
	}
	
	public int getHealth(){
		return this.myHealth; 
	}
}
