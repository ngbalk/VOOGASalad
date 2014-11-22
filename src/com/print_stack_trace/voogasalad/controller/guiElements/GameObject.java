package com.print_stack_trace.voogasalad.controller.guiElements;

import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.GameEngine;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class GameObject {
	private int myID;
	private ImageView myImage;
	private String myType;
	private GameEngine myGameEngine;
	protected SpriteCharacteristics myCharacteristics;
	private ViewObjectDelegate myDelegate;
	public GameObject(int ID, ImageView image, String type){
		myID=ID;
		myImage=image;
		myType=type;
		//need other types
		myCharacteristics=new SpriteCharacteristics(SpriteType.HERO);
		myDelegate=null;
	}
	public GameObject(int ID, ImageView image, String type, ViewObjectDelegate delegate){
		this(ID, image, type);
		myDelegate=delegate;
	}
	public ImageView getImage(){
		return myImage;	
	}
	public SpriteCharacteristics getCharacteristics(){
		return myCharacteristics;
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
