package com.print_stack_trace.voogasalad.controller.guiElements;

import com.print_stack_trace.voogasalad.controller.ViewController;
import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.GameEngine;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class SpriteObject extends GameObject{
	private int myID;
	private String myType;
	private GameEngine myGameEngine;
	protected SpriteCharacteristics myCharacteristics;
	private ViewObjectDelegate myDelegate;
	
	public SpriteObject(int ID, ImageView image, String type){
		this(ID, image, type, null);
	}
	
	public SpriteObject(int ID, ImageView image, String type, ViewObjectDelegate delegate){
		super(image, delegate);
		myID=ID;
		myType=type;
		//need other types
		myCharacteristics=new SpriteCharacteristics(SpriteType.HERO);
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
	
	public String getType(){
		return myType;
	}
	public void setType(String type){
		myType=type;
	}
	
}
