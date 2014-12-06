/**
 * @author 
 * Date Created: 11/??/14
 * Date Modified: 11/23/14
 */

package com.print_stack_trace.voogasalad.model;


import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

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
	public static final double DEFAULT_ORIENTATION = 0;
	public static final String DEFAULT_NAME="";
	public static final double DEFAULT_WIDTH=100;
	public static final double DEFAULT_HEIGHT=100;
	
	// GAME AUTHORING VARIABLES
	public transient Image img;
	public String imagePath;
	public Point p;
	public boolean interactive;
	public SpriteType objectType;
	public int startingHealth;
	public double startingSpeed;
	public int value;
	public double orientation;
	
	//AUTHOR
	public String name;
	public double width;
	public double height;
	public HashMap<PossibleSpriteAction, KeyCode> myMovements;
	public HashMap<PossibleSpriteAction, ArrayList<Image>> myAnimations;
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
		orientation = DEFAULT_ORIENTATION;
		width=DEFAULT_WIDTH;
		height=DEFAULT_HEIGHT;
		name=DEFAULT_NAME;
		myMovements=new HashMap<PossibleSpriteAction, KeyCode>();
		myAnimations=new HashMap<PossibleSpriteAction, ArrayList<Image>>();
		this.initiateAnimations();
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
		orientation= obj.getOrientation();
		width=obj.getWidth();
		height=obj.getHeight();
		name=obj.getName();
		myMovements=obj.getMovements();
		imagePath = obj.getImagePath();
		myAnimations=obj.getAnimations();
		
	}
	
	public void initiateAnimations(){
		for (PossibleSpriteAction action: PossibleSpriteAction.values()){
			myAnimations.put(action, new ArrayList());
		}
		
	}

	//-------------------ACCESSORS-------------------//
	
	public java.awt.Image getJavaAWTImage () {
		return img;
	}
	public HashMap<PossibleSpriteAction, ArrayList<Image>> getAnimations(){
		return myAnimations;
	}
    public javafx.scene.image.Image getImage () {
//    	BufferedImage bufferedImage = (BufferedImage) img;
//    	javafx.scene.image.Image javaFXImage = SwingFXUtils.toFXImage(bufferedImage, null);
    	return new javafx.scene.image.Image(imagePath);
    }
    
    public void setJavaAWTImage(Image image) {
        this.img = image;
    }

    public void setImage(javafx.scene.image.Image image) {
        this.img = SwingFXUtils.fromFXImage(image, null);
    }
    public void setImagePath(String path){
    	imagePath = path;
    }
    public String getImagePath(){
    	return imagePath;
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
    public void addAnimation(PossibleSpriteAction myAction, int index, javafx.scene.image.Image image){
    	Image img=SwingFXUtils.fromFXImage(image, null);
    	if (myAnimations.get(myAction).size()>index)
    		myAnimations.get(myAction).set(index,img);
    	else {
    		for (int i=0; i<index; i++){
    			myAnimations.get(myAction).add(null);
    		}
    		myAnimations.get(myAction).add(img);
    	}
    }
    public void setValue (int value) {
        this.value = value;
    }

    public double getOrientation () {
        return orientation;
    }

    public void setOrientation (double newOrientation) {
    	//System.out.println(newOrientation);
        this.orientation = newOrientation;
        //System.out.println(orientation);
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
