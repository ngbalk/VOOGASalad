package com.print_stack_trace.voogasalad.model;


//import java.awt.Image;
import java.io.File;


import javafx.scene.image.Image; //change to java awt
//import javafx.scene.paint.Color;

public class LevelCharacteristics {
	private String name;
	public File nextLevel = null;
	private transient Image backgroundImage = null;
	private String backgroundImagePath;
	public int requiredNumberOfGoals = 0;
	private String myColor;
	//TODO: More...
	public String getName() {
		return name;
	}
	public void setName(String name){
		this.name = name;
		System.out.println("LevelCharacteristics setting name");
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
	
}
