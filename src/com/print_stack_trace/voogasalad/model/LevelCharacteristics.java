package com.print_stack_trace.voogasalad.model;


//import java.awt.Image;
import java.awt.Point;
import java.io.File;

import com.print_stack_trace.voogasalad.model.engine.runtime.camera.CameraFactory.CameraType;

import javafx.scene.image.Image; //change to java awt
//import javafx.scene.paint.Color;

public class LevelCharacteristics {
	private static final int DEFAULT_CAMERA_SPEED = 3;
	
	private String name;
	public File nextLevel = null;
	private transient Image backgroundImage = null;
	private String backgroundImagePath;
	public int requiredNumberOfGoals = 1;
	public Point cameraStart = new Point(0, 0);
	public int cameraSpeed = DEFAULT_CAMERA_SPEED;
	private String myColor;
	private int myHorizontalPaneCount=1;
	private int myVerticalPaneCount=1;
	private CameraType cameraType = CameraType.PlayerFollow; 
	
	public String getName() {
		return name;
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
	
	public CameraType getCameraType(){
		return this.cameraType;
	}
	
	public void setCamera(CameraType camType){
		this.cameraType = camType;
	}
	
}
