package com.print_stack_trace.voogasalad.model;


import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class LevelCharacteristics {
	private String name;
	public File nextLevel = null;
	private Image backgroundImage = null;
	public int requiredNumberOfGoals = 0;
	private String myColor;
	//TODO: More...
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
