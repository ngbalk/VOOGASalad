/**
 * @author 
 * Date Created: 11/??/14
 * Date Modified: 12/06/14
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
	public static final int DEFAULT_X_POSITION = 0;
	public static final int DEFAULT_Y_POSITION = 0;
	//public static final Point DEFAULT_POINT = new Point(DEFAULT_X_POSITION,DEFAULT_Y_POSITION);
	public static final boolean DEFAULT_INTERACTIVE = false;
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
	//public Point p;
	public int xPosition;
	public int yPosition;
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
	public HashMap<PossibleSpriteAction, KeyCode> myMovements=new HashMap<PossibleSpriteAction,KeyCode>();

	//-------------------CONSTRUCTORS-------------------//

	/**
	 * Constructor for SpriteCharacteristics takes in an enum SpriteType t and sets values
	 * @param t
	 */
	public SpriteCharacteristics(SpriteType t){
		objectType = t;
		img = DEFAULT_IMAGE;
		//p = DEFAULT_POINT;
		xPosition=DEFAULT_X_POSITION;
		yPosition=DEFAULT_Y_POSITION;
		startingHealth = DEFAULT_HEALTH;
		startingSpeed = DEFAULT_SPEED;
		value = DEFAULT_VALUE;
		orientation = DEFAULT_ORIENTATION;
		width=DEFAULT_WIDTH;
		height=DEFAULT_HEIGHT;
		name=DEFAULT_NAME;
		myMovements=new HashMap<PossibleSpriteAction, KeyCode>();
		interactive = DEFAULT_INTERACTIVE;
		switch(t){
		case HERO:
			interactive = true;
		case ENEMY:
			interactive = true;
		}
	}

	/**
	 * Constructor that essentially "clones" another spritecharacteristics class
	 * @param obj
	 */
	public SpriteCharacteristics(SpriteCharacteristics obj) {
		objectType = obj.getObjectType();
		img = obj.getJavaAWTImage();
		//p = obj.getPoint();
		xPosition=(int)obj.getX();
		yPosition=(int)obj.getY();
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
	}

	//-------------------ACCESSORS-------------------//

	public java.awt.Image getJavaAWTImage () {
		return img;
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
		return new Point(xPosition,yPosition);
	}

	public void setPoint (Point p) {
		//this.p=p;
		setX(p.getX());
		setY(p.getY());
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

	public double getOrientation () {
		return orientation;
	}

	public void setOrientation (double newOrientation) {
		this.orientation = newOrientation;
	}

	public double getX(){
		return xPosition;
	}

	public double getY(){
		return yPosition;
	}

	public void setX(double xPosition){
		this.xPosition=(int)xPosition;
	}

	public void setX(int xLocation){
		this.xPosition=xLocation;
	}
	
	public void setY(double yPosition){
		this.yPosition=(int)yPosition;
	}
	
	public void setY(int yPosition){
		this.yPosition=yPosition;
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
