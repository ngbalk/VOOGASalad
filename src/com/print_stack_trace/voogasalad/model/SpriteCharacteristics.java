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
	public int startingHealth;
	public double startingSpeed;
	public int value;
	public String startingDirectionFacing;

	
	
	public SpriteCharacteristics(SpriteType t){
		objectType = t;
//		Default values 
//		img = new Image("");
		p = new Point(0,0);
		interactive = true;
		startingHealth = 10;
		startingSpeed = 10;
		value = 0;
		startingDirectionFacing = "left";
	}
	

	
}
