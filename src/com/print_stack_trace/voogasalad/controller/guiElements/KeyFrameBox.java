package com.print_stack_trace.voogasalad.controller.guiElements;


import java.util.ArrayList;
import java.util.HashSet;

import com.sun.glass.events.MouseEvent;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.IntegerPropertyBase;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableObjectValue;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class KeyFrameBox extends Pane{
	private ArrayList<Rectangle> myKeys=new ArrayList<Rectangle>();
	private SimpleObjectProperty<KeyFrameBlock> currentKeyFrame=new SimpleObjectProperty<KeyFrameBlock>();
	private double rectangleSize;
	private double strokeWidth=4;
	private double DEFAULT_NUM_RECTANGLES=20;
	public  KeyFrameBox(double width, double height){
		this.setStyle("-fx-background-color:BLACK; -fx-border-color:#0099CC; -fx-border-width: 5");
		setPrefSize(width, height);
		double startX=5;
		rectangleSize=(width-10)/DEFAULT_NUM_RECTANGLES-strokeWidth;
		while((startX+rectangleSize)<width){
			KeyFrameBlock myRectangle=new KeyFrameBlock(null, null, myKeys.size());
			myRectangle.relocate(startX,5);
			myRectangle.setHeight(height-10);
			myRectangle.setWidth(rectangleSize);
			setStyle(myRectangle);
			myRectangle.setOnMousePressed(event->glow(myRectangle));
			myKeys.add(myRectangle);
			this.getChildren().add(myRectangle);
			startX+=rectangleSize+strokeWidth;
		}
		glow(myKeys.get(0));
		
	}
	private void glow(Node myNode){
		currentKeyFrame.setValue((KeyFrameBlock) myNode);
		for (Rectangle rect: myKeys){
			setStyle(rect);
		}
		myNode.setStyle("-fx-fill: BLACK; -fx-stroke-width: 2pt; -fx-stroke: WHITE");
	}
	private void setStyle(Rectangle rect){
		rect.setFill(Paint.valueOf("WHITE"));
		rect.setStyle("-fx-stroke: BLACK; -fx-stroke-width: 2pt");
		
		
	}
	public ObjectProperty<KeyFrameBlock> getCurrentKeyFrame(){
		return currentKeyFrame;
	}

	
	
}
