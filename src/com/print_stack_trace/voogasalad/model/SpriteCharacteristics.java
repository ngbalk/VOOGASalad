package com.print_stack_trace.voogasalad.model;

import java.awt.Image;
import java.awt.Point;

import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;
//import com.print_stack_trace.voogasalad.model.engine.physics.ArrayList;
//import com.print_stack_trace.voogasalad.model.engine.physics.List;

public class SpriteCharacteristics {
	public Image img;
	public Point p;
	public boolean interactive;
	public SpriteType objectType;
	public int health;
	public double speed;
	public int value;
	public String directionFacing;
	
	public SpriteCharacteristics(SpriteCharacteristics obj) {
		// TODO Impliment clone method
	}
	
	public SpriteCharacteristics(SpriteType t){
		objectType = t;
//		Default values 
//		img = new Image("");
		p = new Point(0,0);
		interactive = true;
		health = 10;
		speed = 10;
		value = 0;
		directionFacing = "";
	}



	
	

	
}
