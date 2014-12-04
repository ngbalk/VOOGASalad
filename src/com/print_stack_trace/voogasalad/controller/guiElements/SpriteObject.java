package com.print_stack_trace.voogasalad.controller.guiElements;

import com.print_stack_trace.voogasalad.controller.ViewController;
import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.GameEngine;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class SpriteObject extends GameObject{
	private int myID;
	private String myType;
	private SimpleDoubleProperty xProp=new SimpleDoubleProperty(0); 
	private SimpleDoubleProperty yProp=new SimpleDoubleProperty(0); ;
	private GameEngine myGameEngine;
	protected SpriteCharacteristics myCharacteristics;

	public SpriteObject(int ID, ImageView image, String imagePath, String type){
		this(ID, image, imagePath, type, null);
		
	}
	public SpriteObject(int ID, ImageView image, String imagePath, String type, ViewObjectDelegate delegate){
		super(image, imagePath, delegate);
		myID=ID;
		myType=type;
		//need other types
		myCharacteristics=new SpriteCharacteristics(SpriteType.valueOf(type.toUpperCase()));
		myCharacteristics.setImagePath(imagePath);
		createPane();
		this.getImage().setOnMouseClicked(e->showPane());
	}
	public void setMyX(double x){
		xProp.setValue(x);
		this.getCharacteristics().setX(x);
		this.getImage().relocate(x, yProp.getValue());
		myDelegate.update(this);
	}
	public void setMyY(double y){
		yProp.setValue(y);
		this.getCharacteristics().setY(y);
		this.getImage().relocate(xProp.getValue(), y);
		myDelegate.update(this);
		
	}
	public SimpleDoubleProperty getObservableX(){
		return xProp;
	}
	public SimpleDoubleProperty getObservableY(){
		return yProp;
	}
	public SpriteCharacteristics getCharacteristics(){
		return myCharacteristics;
	}
	public void createPane(){
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
