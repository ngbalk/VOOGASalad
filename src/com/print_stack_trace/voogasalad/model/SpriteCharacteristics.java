package com.print_stack_trace.voogasalad.model;



import java.util.HashMap;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

import com.print_stack_trace.voogasalad.controller.guiElements.SpriteMovement.PossibleSpriteAction;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;
//import com.print_stack_trace.voogasalad.model.engine.physics.ArrayList;
//import com.print_stack_trace.voogasalad.model.engine.physics.List;

public class SpriteCharacteristics {
	private Image myImage;
	private double xLocation;
	private double yLocation;
	public boolean interactive;
	public SpriteType objectType;
	public int health;
	public double speed;
	public int value;
	public String directionFacing;
	public double width;
	public double height;
	private HashMap<PossibleSpriteAction, KeyCode> myMovements=new HashMap<PossibleSpriteAction, KeyCode>();


	
	public SpriteCharacteristics(SpriteType t){
		objectType = t;
//		Default values 
//		img = new Image("");
		xLocation = 0.0;
		yLocation = 0.0;
		interactive = true;
		health = 10;
		speed = 10;
		value = 0;
		directionFacing = "";
	}
	public double getX(){
		return xLocation;
	}
	public double getY(){
		return yLocation;
	}
	public void setX(double xLocation){
		this.xLocation = xLocation; 
	}
	public void setY(double yLocation){
		this.yLocation = yLocation;
	}
	public void setImage(Image imageToChange){
		myImage=imageToChange;
	}
	public void addMovement(PossibleSpriteAction myAction, KeyCode myKey){
		myMovements.put(myAction, myKey);
	}
	public HashMap<PossibleSpriteAction, KeyCode> getMovements(){
		return myMovements;
	}
	

	
}
