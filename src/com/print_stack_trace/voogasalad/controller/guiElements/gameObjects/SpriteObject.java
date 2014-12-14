package com.print_stack_trace.voogasalad.controller.guiElements.gameObjects;

import com.print_stack_trace.voogasalad.controller.ViewController;
import com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor.ViewObjectDelegate;
import com.print_stack_trace.voogasalad.controller.popUpPanes.PaneChooser;
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
	private String myType;
	private SimpleDoubleProperty xProp; 
	private SimpleDoubleProperty yProp;
	private SimpleDoubleProperty widthProp;
	private SimpleDoubleProperty heightProp;
	private GameEngine myGameEngine;
	protected SimpleObjectProperty<SpriteCharacteristics> myCharacteristics=new SimpleObjectProperty<SpriteCharacteristics>();
	public SpriteObject(int ID, String imagePath, String type){
		this(ID, imagePath, type, null);
	}
	public SpriteObject(int id, String imagePath, String type, ViewObjectDelegate delegate){
		super(imagePath, delegate);
		ID=id;
		myType=type;
		xProp=new SimpleDoubleProperty(getImage().getLayoutY()); 
		yProp=new SimpleDoubleProperty(getImage().getLayoutX());
		widthProp=new SimpleDoubleProperty(
				getImage().getFitWidth());
		heightProp=new SimpleDoubleProperty(getImage().getFitHeight());
		myCharacteristics.setValue(new SpriteCharacteristics(SpriteType.valueOf(type.toUpperCase())));
		getCharacteristics().setImagePath(imagePath);
		initializeImage();
		createPane();
		getImage().setOnMouseClicked(e->showPane());
	}
	
	public void setSpriteX(double x){
		xProp.setValue(x);
		getCharacteristics().setX(x);
		getImage().relocate(x, yProp.getValue());
		update();
	}
	public void setSpriteWidth(double width){
		widthProp.setValue(width);
		getCharacteristics().setWidth(width);
		getImage().setFitWidth(width);
		getImage().setPreserveRatio(false);
		update();
	}
	public void setSpriteHeight(double height){
		heightProp.setValue(height);
		getCharacteristics().setHeight(height);
		getImage().setFitHeight(height);
		getImage().setPreserveRatio(false);
		update();
	}
	public void setSpriteY(double y){
		yProp.setValue(y);
		getCharacteristics().setY(y);
		getImage().relocate(xProp.getValue(), y);
		update();	
	}
	
	public SimpleDoubleProperty getObservableX(){
		return xProp;
	}
	
	public SimpleDoubleProperty getObservableY(){
		return yProp;
	}
	
	public SimpleDoubleProperty getObservableWidth(){
		return widthProp;
	}
	
	public SimpleDoubleProperty getObservableHeight(){
		return heightProp;
	}
	public SpriteCharacteristics getCharacteristics(){
		return myCharacteristics.getValue();
	}
	
	public void createPane(){
		PaneChooser myPaneChooser=new PaneChooser();
		
		myPane=myPaneChooser.createPane(this.getType(), this);
		System.out.println(myPane);
	}
	
	public void changeImageView(ImageView imageView){
		ImageView newImageView=new ImageView(imageView.getImage());
		newImageView.setFitHeight(imageView.getFitHeight());
		newImageView.setFitWidth(imageView.getFitWidth());
		newImageView.setRotate(imageView.getRotate());
		newImageView.relocate(imageView.getLayoutX(), imageView.getLayoutY());
		myImage=newImageView;
		getImage().setOnMouseClicked(e->showPane());
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
	public void setImage(String imagePath){
		super.setImage(imagePath);
	}
	
	public void initializeSprite(){
		getCharacteristics().setHeight(getImage().getFitHeight());
		getCharacteristics().setWidth(getImage().getFitWidth());
		getCharacteristics().setX(getImage().getX());
		getCharacteristics().setY(getImage().getY());
		getCharacteristics().setOrientation(
				getImage().getRotate());
	}
	public void initializeImage(){
		getImage().setFitHeight(getCharacteristics().getHeight());
		getImage().setFitWidth(getCharacteristics().getWidth());
		getImage().setRotate(getCharacteristics().getOrientation());
		getImage().setX(getCharacteristics().getX());
		getImage().setY(getCharacteristics().getY());
	}
	@Override
	public void setImageCharacteristics() {
		myCharacteristics.getValue().setImagePath(myImagePath);
		myCharacteristics.getValue().setImage(getImage().getImage());
	}
}
