package com.print_stack_trace.voogasalad.model;

import java.awt.Image;
import java.awt.Point;

import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;
//import com.print_stack_trace.voogasalad.model.engine.physics.ArrayList;
//import com.print_stack_trace.voogasalad.model.engine.physics.List;

public class SpriteCharacteristics {
	
	// DEFAULT VARIABLES
	public static final Image DEFAULT_IMAGE = null;
	public static final Point DEFAULT_POINT = new Point(0,0);
	public static final boolean DEFAULT_INTERACTIVE = true;
	public static final SpriteType DEFAULT_OBJECT_TYPE = null;
	public static final int DEFAULT_HEALTH = 10;
	public static final double DEFAULT_SPEED = 10;
	public static final int DEFAULT_VALUE = 0;
	public static final String DEFAULT_DIRECTION_FACING = "left";
	
	// GAME AUTHORING VARIABLES
	public Image img;
	public Point p;
	public boolean interactive;
	public SpriteType objectType;
	public int startingHealth;
	public double startingSpeed;
	public int value;
	public String startingDirectionFacing;
	
	/**
	 * Constructor for SpriteCharacteristics takes in an enum SpriteType t and sets values
	 * @param t
	 */
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

    public Image getImg () {
        return img;
    }

    public void setImg (Image img) {
        this.img = img;
    }

    public Point getP () {
        return p;
    }

    public void setP (Point p) {
        this.p = p;
    }

    public boolean isInteractive () {
        return interactive;
    }

    public void setInteractive (boolean interactive) {
        this.interactive = interactive;
    }

    public SpriteType getObjectType () {
        return objectType;
    }

    public void setObjectType (SpriteType objectType) {
        this.objectType = objectType;
    }

    public int getStartingHealth () {
        return startingHealth;
    }

    public void setStartingHealth (int startingHealth) {
        this.startingHealth = startingHealth;
    }

    public double getStartingSpeed () {
        return startingSpeed;
    }

    public void setStartingSpeed (double startingSpeed) {
        this.startingSpeed = startingSpeed;
    }

    public int getValue () {
        return value;
    }

    public void setValue (int value) {
        this.value = value;
    }

    public String getStartingDirectionFacing () {
        return startingDirectionFacing;
    }

    public void setStartingDirectionFacing (String startingDirectionFacing) {
        this.startingDirectionFacing = startingDirectionFacing;
    }
	
	

	
}
