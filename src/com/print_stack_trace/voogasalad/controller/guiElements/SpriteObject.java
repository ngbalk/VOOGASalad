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
		createPane();
		this.getImage().setOnMouseClicked(e->showPane());
	}

	public SpriteCharacteristics getCharacteristics(){
		return myCharacteristics;
	}
	public void createPane(){
		System.out.println("CREATE"+this);
		PaneChooser myPaneChooser=new PaneChooser();
		myPane=myPaneChooser.createPane(this.getType(), this);
	}
	public int  getId(){
		return myID;
	}
	public void setID(int id){
		myID=id;
	}
	public void changeImageView(ImageView imageView){
		ImageView newImageView=new ImageView(imageView.getImage());
		newImageView.setFitHeight(imageView.getFitHeight());
		newImageView.setFitWidth(imageView.getFitWidth());
		newImageView.setRotate(imageView.getRotate());
		newImageView.relocate(imageView.getX(), imageView.getY());
		myImage=newImageView;
		this.getImage().setOnMouseClicked(e->showPane());
	}
	public String getType(){
		return myType;
	}
	public void setType(String type){
		myType=type;
	}
	public String getCode(){
		return this.getCharacteristics().getName();
	}
	public void setCharacteristics(SpriteCharacteristics characteristics){
		myCharacteristics=characteristics;	
	}
	@Override
	protected void update() {
		myDelegate.update(this);
	}

	

}
