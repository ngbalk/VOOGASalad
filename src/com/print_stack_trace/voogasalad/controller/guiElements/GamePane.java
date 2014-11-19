package com.print_stack_trace.voogasalad.controller.guiElements;

import java.awt.Point;
import java.util.HashMap;














import javax.swing.JOptionPane;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableDoubleValue;
import javafx.beans.value.ObservableIntegerValue;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ScrollBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class GamePane extends Pane{
	private double myWidth;
	private double myHeight;
	private HashMap<ImageView, Number> myData;
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
		String gameObjectType=JOptionPane.showInputDialog("What type of object would you like this image to be: (player, object, enemy, or obstacle");
		GameObject myGameObject=new GameObject(0, gameObjectImageView, gameObjectType);
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
	public void addBackground(ImageView imgView){
		GameObject myGameObject=new GameObject(0,imgView, "level background");
		DraggableItem copyNode=new DraggableItem(myGameObject, getWidth(), getHeight());
		ImageView background=(ImageView)copyNode.getMyItem();
		background.setFitWidth(getWidth());
		background.setFitHeight(getHeight()-10);
		background.setFitWidth(getWidth()-10);
		background.setSmooth(true);
		background.setPreserveRatio(false);
		background.relocate(5, 5);
		this.getChildren().add(0, background);
	}
}
