package com.print_stack_trace.voogasalad.model;

import java.awt.Image;
import java.awt.Point;

public class SpriteCharacteristics {
	public Image img;
	public Point p;
	public boolean interactive;
	public ObjectType objectType; 
	
	public enum ObjectType {
		PLAYER,
		OBSTACLE,
		GOAL,
		SCENERY
	}
}
