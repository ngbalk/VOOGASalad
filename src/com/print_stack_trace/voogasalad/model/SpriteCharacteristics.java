/**
 * @author 
 * Date Created: 11/??/14
 * Date Modified: 12/06/14
 */

package com.print_stack_trace.voogasalad.model;


import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.*;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;

import com.print_stack_trace.voogasalad.controller.guiElements.SpriteMovement.PossibleSpriteAction;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;

public class SpriteCharacteristics {

	// DEFAULT VARIABLES
	public static final Image DEFAULT_IMAGE = null;
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
	public Point p;
	//public int xPosition;
	//public int yPosition;
	public boolean interactive;
	public SpriteType objectType;
	public int startingHealth;
	public double startingSpeed;
	public int value;
	public double orientation;
	public String name;
	public double width;
	public double height;

	public HashMap<PossibleSpriteAction, KeyCode> myMovements;
	public HashMap<PossibleSpriteAction, ArrayList<File>> myAnimations;


	//-------------------CONSTRUCTORS-------------------//

	/**
	 * Constructor for SpriteCharacteristics takes in an enum SpriteType t and sets values
	 * @param t
	 */
	public SpriteCharacteristics(SpriteType t){
		objectType = t;
		img = DEFAULT_IMAGE;
		p = new Point(0,0);
		//xPosition=DEFAULT_X_POSITION;
		//yPosition=DEFAULT_Y_POSITION;
		startingHealth = DEFAULT_HEALTH;
		startingSpeed = DEFAULT_SPEED;
		value = DEFAULT_VALUE;
		orientation = DEFAULT_ORIENTATION;
		width=DEFAULT_WIDTH;
		height=DEFAULT_HEIGHT;
		name=DEFAULT_NAME;
		myMovements=new HashMap<PossibleSpriteAction, KeyCode>();

		myAnimations=new HashMap<PossibleSpriteAction, ArrayList<File>>();
		this.initiateAnimations();

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
	public HashMap<PossibleSpriteAction, ArrayList<File>> getAnimations(){
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
    public ArrayList<File> getAnimationPath(PossibleSpriteAction action){
    	return myAnimations.get(action);
    }
    
    public ArrayList<javafx.scene.image.Image> getAnimationImages(PossibleSpriteAction action){
    	ArrayList<javafx.scene.image.Image> myImages=new ArrayList<javafx.scene.image.Image>();
    	BufferedImage buffer;
    	for (File path: getAnimationPath(action)){
    		try {
				buffer = ImageIO.read(path);
				javafx.scene.image.Image img=SwingFXUtils.toFXImage(buffer, null);
				myImages.add(img);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Image couldn't be uploaded");
			}
			
    	}
    	return myImages;
    }

    public void addAnimation(PossibleSpriteAction myAction, int index, File imgPath){
    	if (myAnimations.get(myAction).size()>index)
    		myAnimations.get(myAction).set(index,imgPath);
    	else {
    		for (int i=0; i<index; i++){
    			myAnimations.get(myAction).add(null);
    		}
    		myAnimations.get(myAction).add(imgPath);
    	}
    }

	public void setImagePath(String path){
		imagePath = path;
	}
	
	public String getImagePath(){
		return imagePath;
	}

	public Point getPoint () {
		//return new Point(xPosition,yPosition);
		return p;
	}

	public void setPoint (Point p) {
		this.p=p;
		//setX(p.getX());
		//setY(p.getY());
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
		//return xPosition;
		return p.getX();
	}

	public double getY(){
		//return yPosition;
		return p.getY();
	}

	public void setX(double xPosition){
		//this.xPosition=(int)xPosition;
		//p.setLocation(xPosition, p.getY());
		p.x=(int)xPosition;
	}
	
	public void setY(double yPosition){
		//this.yPosition=(int)yPosition;
		//p.setLocation(p.getX(), yPosition);
		p.y=(int)yPosition;
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
