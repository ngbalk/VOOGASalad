package com.print_stack_trace.voogasalad.controller.guiElements;

import com.print_stack_trace.voogasalad.controller.ViewController;
import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.GameEngine;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class SpriteObject extends GameObject{
	private int myID;
	private String myType;
	private SimpleDoubleProperty xProp; 
	private SimpleDoubleProperty yProp;
	private GameEngine myGameEngine;
	protected SimpleObjectProperty<SpriteCharacteristics> myCharacteristics=new SimpleObjectProperty<SpriteCharacteristics>();

	public SpriteObject(int ID, String imagePath, String type){
		this(ID, imagePath, type, null);
		
	}
	public SpriteObject(int ID, String imagePath, String type, ViewObjectDelegate delegate){
		super(imagePath, delegate);
		myID=ID;
		myType=type;
		xProp=new SimpleDoubleProperty(0); 
		yProp=new SimpleDoubleProperty(0);
		//need other types
		myCharacteristics.setValue(new SpriteCharacteristics(SpriteType.valueOf(type.toUpperCase())));
		myCharacteristics.getValue().setImagePath(imagePath);
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
		return myCharacteristics.getValue();
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
		myCharacteristics.setValue(characteristics);
		xProp.setValue(characteristics.getX());
		yProp.setValue(characteristics.getY());
		
	}
	public SimpleObjectProperty<SpriteCharacteristics> characteristicsProperty(){
		return myCharacteristics;
	}
	@Override
	protected void update() {
		myDelegate.update(this);
	}
	@Override
	public void setImagePath(String imagePath){
		myImagePath=imagePath;
		myCharacteristics.getValue().setImagePath(imagePath);
	}

	

}
