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
	private PaneChooser myPaneChooser=new PaneChooser();
	private GameEngine myGameEngine;
	protected SpriteCharacteristics myCharacteristics;
	public GameObject(int ID, ImageView image, String type, GameEngine gameEngine){
		myID=ID;
		myImage=image;
		myType=type;
		myGameEngine=gameEngine;
		//need other types
		myCharacteristics=new SpriteCharacteristics(SpriteType.HERO);
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
	public void setOnMousePress(){
		Pane myNewPane=myPaneChooser.createPane(getType(), this);
		((GeneralPane) myNewPane).openPane();

	}
}
