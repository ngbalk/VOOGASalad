package com.print_stack_trace.voogasalad.model;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;

import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;

public class SpriteCharacteristics {
	public Image img;
	public Point2D p;
	public boolean interactive;
	public SpriteType objectType;
	public int health;
	public double speed;
	public int value;
	public String directionFacing;
	
	public SpriteCharacteristics(SpriteType t){
		objectType = t;
//		Default values 
//		img = new Image("");
		p = new Point2D(0,0);
		interactive = true;
		health = 10;
		speed = 10;
		value = 0;
		directionFacing = "";
	}
	
}
