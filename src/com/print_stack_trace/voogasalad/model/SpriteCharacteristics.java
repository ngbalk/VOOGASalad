/**
 * @author 
 * Date Created: 11/??/14
 * Date Modified: 11/23/14
 */

package com.print_stack_trace.voogasalad.model;


import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.*;
import javafx.scene.input.KeyCode;

import com.print_stack_trace.voogasalad.controller.guiElements.SpriteMovement.PossibleSpriteAction;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;

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
	public static final String DEFAULT_NAME="";
	public static final double DEFAULT_WIDTH=100;
	public static final double DEFAULT_HEIGHT=100;
	
	// GAME AUTHORING VARIABLES
	public Image img;
	public Point p;
	public boolean interactive;
	public SpriteType objectType;
	public int startingHealth;
	public double startingSpeed;
	public int value;
	public String startingDirectionFacing;
	
	//AUTHOR
	public String name;
	public double width;
	public double height;
	public HashMap<PossibleSpriteAction, KeyCode> myMovements=new HashMap<PossibleSpriteAction,KeyCode>();
	
	//-------------------CONSTRUCTORS-------------------//

	/**
	 * Constructor for SpriteCharacteristics takes in an enum SpriteType t and sets values
	 * @param t
	 */
	public SpriteCharacteristics(SpriteType t){
		objectType = t;
		img = DEFAULT_IMAGE;
		p = DEFAULT_POINT;
		interactive = DEFAULT_INTERACTIVE;
		startingHealth = DEFAULT_HEALTH;
		startingSpeed = DEFAULT_SPEED;
		value = DEFAULT_VALUE;
		startingDirectionFacing = DEFAULT_DIRECTION_FACING;
		width=DEFAULT_WIDTH;
		height=DEFAULT_HEIGHT;
		name=DEFAULT_NAME;
		myMovements=new HashMap<PossibleSpriteAction, KeyCode>();
	}
	
	/**
	 * Constructor that essentially "clones" another spritecharacteristics class
	 * @param obj
	 */
	public SpriteCharacteristics(SpriteCharacteristics obj) {
		objectType = obj.getObjectType();
		img = obj.getJavaAWTImage();
		p = obj.getPoint();
		interactive = obj.isInteractive();
		startingHealth = obj.getStartingHealth();
		startingSpeed = obj.getStartingSpeed();
		value = obj.getValue();
		startingDirectionFacing = obj.getStartingDirectionFacing();
		width=obj.getWidth();
		height=obj.getHeight();
		name=obj.getName();
		myMovements=obj.getMovements();
	}

	//-------------------ACCESSORS-------------------//
	
	public java.awt.Image getJavaAWTImage () {
		return img;
	}
	
    public javafx.scene.image.Image getImage () {
    	BufferedImage bufferedImage = (BufferedImage) img;
    	javafx.scene.image.Image javaFXImage = SwingFXUtils.toFXImage(bufferedImage, null);
    	return javaFXImage;
    }

    public void setImage(Image img) {
        this.img = img;
    }

    public Point getPoint () {
        return p;
    }

    public void setPoint (Point p) {
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
    
	public double getX(){
		return p.getX();
	}
	
	public double getY(){
		return p.getY();
	}
	
	public void setX(double xLocation){
		p.x=(int)xLocation; 
	}
	
	public void setY(double yLocation){
		p.y=(int) yLocation;
	}
	
	public void addMovement(PossibleSpriteAction myAction, KeyCode myKey){
		myMovements.put(myAction, myKey);
	}
	
	public HashMap<PossibleSpriteAction, KeyCode> getMovements(){
		return myMovements;
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
