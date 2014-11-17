package com.print_stack_trace.voogasalad.guiElements;

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

	
}
