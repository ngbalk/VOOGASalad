package com.print_stack_trace.voogasalad.controller.guiElements;

import java.util.HashMap;

import javax.swing.JOptionPane;

import com.print_stack_trace.voogasalad.model.engine.GameEngine;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class GamePane extends Pane implements ViewObjectDelegate{
	private double myWidth;
	private double myHeight;
	private GameEngine myGameEngine;
	private HashMap<ImageView, Number> myData;
	private PaneChooser myPaneChooser=new PaneChooser();
	public GamePane(double width, double height){
		myWidth=width;
		myHeight=height;
		this.setWidth(width);
		this.setHeight(height);
		myData=new HashMap<ImageView, Number>();
		this.setPrefSize(width, height);
		this.setUpScrollingBars();

	}
	private void setUpScrollingBars(){
		ScrollingBarPair myScrollingBars=new ScrollingBarPair((int)myWidth-20,(int) myHeight-14);
		this.getChildren().addAll(myScrollingBars);
	}
	public void addGameObject(ImageView gameObjectImageView){
		String gameObjectType=JOptionPane.showInputDialog("What type of object would you like this image to be: (hero, obstacle, enemy, platform or reward");
		GameObject myGameObject=new GameObject(0, gameObjectImageView, gameObjectType);
		//Integer myID=myGameEngine.addObjectToLevel(myGameObject.getCharacteristics());
		//myGameObject.setID(myID);
		gameObjectImageView.setOnMouseClicked(event->createPane(myGameObject));
		DraggableItem copyNode=new DraggableItem(myGameObject, getWidth(), getHeight());
		myData.put(gameObjectImageView, 0);
		
		this.getChildren().add(gameObjectImageView);
	}
	public double getGridWidth(){
		return myWidth;
	}
	public double getGridHeight(){
		return myHeight;
	}
	public void createPane(GameObject object){
		Pane myNewPane=myPaneChooser.createPane(object.getType(), object);
		((GeneralPane) myNewPane).openPane();

	}
	public void addBackground(ImageView imgView){
		GameObject myGameObject=new GameObject(0,imgView, "level background");
		DraggableItem copyNode=new DraggableItem(myGameObject, getWidth(), getHeight());
		ImageView background=myGameObject.getImage();
		background.setFitWidth(getWidth());
		background.setFitHeight(getHeight()-10);
		background.setFitWidth(getWidth()-10);
		background.setSmooth(true);
		background.setPreserveRatio(false);
		background.relocate(5, 5);
		this.getChildren().add(0, background);
	}
	public void addGameEngine(GameEngine gameEngine){
		myGameEngine=gameEngine;
	}
	public void update(GameObject myObject){
		myGameEngine.updateObject(myObject.getId(), myObject.getCharacteristics());
	}
}
