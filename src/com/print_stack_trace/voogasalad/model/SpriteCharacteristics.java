package com.print_stack_trace.voogasalad.model;

import java.awt.Image;
import java.awt.Point;

import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;
//import com.print_stack_trace.voogasalad.model.engine.physics.ArrayList;
//import com.print_stack_trace.voogasalad.model.engine.physics.List;

public class SpriteCharacteristics {
	public Image img;
	private double xLocation;
	private double yLocation;
	public boolean interactive;
	public SpriteType objectType;
	public int health;
	public double speed;
	public int value;
	public String directionFacing;
	private double width;
	private double height;
	private String name;

	
	
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
	public double getWidth(){
		return width;
	}
	public double getHeight(){
		return height;
	}
	public void setWidth(double width){
		this.width = width;
	}
	public void setHeight(double height){
		this.height = height;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		
	}
	

	
}
