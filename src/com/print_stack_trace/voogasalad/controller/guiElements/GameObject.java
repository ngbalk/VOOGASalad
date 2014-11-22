package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameObject {
	private int myID;
	private ImageView myImage;
	private String myType;
	public GameObject(int ID, ImageView image, String type){
		myID=ID;
		myImage=image;
		myType=type;
	}
	public ImageView getImage(){
		return myImage;
	}
	public int  getId(){
		return myID;
	}
	public void setID(int id){
		myID=id;
	}
	public void setImage(Image img){
		myImage.setImage(img);
	}
	public String getType(){
		return myType;
	}
	public void setType(String type){
		myType=type;
	}
}
