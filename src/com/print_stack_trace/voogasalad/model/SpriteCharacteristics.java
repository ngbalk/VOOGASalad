package com.print_stack_trace.voogasalad.model;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import java.util.*;

import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;
//import com.print_stack_trace.voogasalad.model.engine.physics.ArrayList;
//import com.print_stack_trace.voogasalad.model.engine.physics.List;

public class SpriteCharacteristics {
	public Image img;
	public Point2D p;
	public boolean interactive;
	public SpriteType objectType;
	public int health;
	public double speed;
	public int value;
	public String directionFacing;
	public ArrayList<Double> myVerticalBounds;
	public ArrayList<Double> myHorizontalBounds;
	
	
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
		makeBounds(p);
	}
	
	private void makeBounds(Point2D point) {
		
		double xVal = point.getX();
		double yVal = point.getY();
		double imageWidth = img.getWidth();
		double imageHeight = img.getHeight();
		
		myHorizontalBounds.add(xVal - (imageWidth/2));
		myHorizontalBounds.add(xVal+(imageWidth/2));
		myVerticalBounds.add(yVal - (imageHeight/2));
		myVerticalBounds.add(yVal + (imageHeight/2));
	
	}
	
}
