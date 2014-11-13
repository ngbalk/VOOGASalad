package com.print_stack_trace.voogasalad.guiElements;

import java.awt.Point;
import java.util.HashMap;







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
	public void addGameObject(ImageView gameObject){
		myData.put(gameObject, 0);
		this.getChildren().add(gameObject);
	}
	
	public double getGridWidth(){
		return myWidth;
	}
	public double getGridHeight(){
		return myHeight;
	}
}
