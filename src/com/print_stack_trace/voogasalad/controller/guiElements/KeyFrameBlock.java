package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class KeyFrameBlock extends Rectangle{
	private Image myImage;
	private String myName;
	private int myIndex;
	private String myImagePath;
	public KeyFrameBlock(Image image, String name, int index){
		myImage =image;
		myName=name;
		myIndex=index;
	}
	public String getTag(){
		if (myName==null){
			return "";
		}
		return myName;
	}
	public Image getImage(){
		return myImage;
	}
	public int getIndex(){
		return myIndex;
	}
	public void setIndex(int index){
		myIndex=index;
	}
	public void setImage(Image img){
		myImage=img;
	}
	public String getName(){
		return myName;
	}
	public String getImagePath(){
		return myImagePath;
	}
	public void setImagePath(String myString){
		myImagePath=myString;
	}

	
}
