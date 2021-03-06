package com.print_stack_trace.voogasalad.model;


//import java.awt.Image;
import java.awt.Point;
import java.io.File;

import com.print_stack_trace.voogasalad.model.engine.runtime.camera.CameraFactory.CameraType;

import javafx.scene.image.Image; //change to java awt
//import javafx.scene.paint.Color;
/**
 * 
 * @author Ethan Chang, Jack Baskin, Nick Widmaier
 * This class sets many of the properties associated with a particular
 * level. Each LevelModel contains a particular instance of this class
 * which contains information specific to that level.
 *
 */
public class LevelCharacteristics {
	private static final int DEFAULT_CAMERA_SPEED = 3;
	
	private String name = "";
	private Integer nextLevel = -1;
	private Integer previousLevel = -1;
	private Integer ID = null;
	private transient Image backgroundImage = null;
	private String backgroundImagePath = "";
	private int requiredNumberOfGoals = 1;
	private Point cameraStart = new Point(0, 0);
	private int cameraSpeed = DEFAULT_CAMERA_SPEED;
	private String myColor;
	private int myHorizontalPaneCount=1;
	private int myVerticalPaneCount=1;
	private CameraType cameraType = CameraType.PlayerFollow; 
	
	public String getName() {
		return name;
	}
	public Integer getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID=ID;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setBackground(Image img){
		myColor=null;
		backgroundImage=img;
	}
	public void setBackgroundImagePath(String path){
		backgroundImagePath = path;
	}
	public String getBackgroundImagePath(){
		return backgroundImagePath;
	}
	public void setBackgroundColor(String string){
		backgroundImage=null;
		myColor=string;
	}
	public Image getBackground(){
		return backgroundImage;
	}
	public String getColor(){
		return myColor;
	}
	public Point getCameraStartPosition(){
		return cameraStart;
	}
	public void setCameraX(double x){
		cameraStart.setLocation(x, cameraStart.getY());
	}
	public void setCameraY(double y){
		cameraStart.setLocation(cameraStart.getX(), y);
	}
	public double getCameraSpeed(){
		return cameraSpeed;
	}
	public void setCameraSpeed(int speed){
		cameraSpeed=speed;
	}
	public int getNextLevel(){
		return nextLevel;
	}
	public int getPreviousLevel(){
		return previousLevel;
	}
	public void setNextLevel(int next){
		nextLevel=next;
	}
	public void setPreviousLevel(int prev){
		previousLevel=prev;
	}
	public int incrementHorizontalPaneCount(){
		this.myHorizontalPaneCount++;
		return this.myHorizontalPaneCount;
	}
	public int incrementVerticalPaneCount() {
		this.myVerticalPaneCount++;
		return this.myVerticalPaneCount;
	}
	public int getVerticalPaneCount(){
		return this.myVerticalPaneCount;
	}
	public int getHorizontalPaneCount(){
		return this.myHorizontalPaneCount;
	}
	
    public CameraType getCameraType () {
        return cameraType;
    }
    public int getRequiredNumberOfGoals () {
        return requiredNumberOfGoals;
    }
    public Point getCameraStart () {
        return cameraStart;
    }
    public void setRequiredNumberOfGoals (int num) {
        requiredNumberOfGoals = num;        
    }
    public void setCameraType (CameraType cameraType) {
        this.cameraType = cameraType;
        
    }
	
}
