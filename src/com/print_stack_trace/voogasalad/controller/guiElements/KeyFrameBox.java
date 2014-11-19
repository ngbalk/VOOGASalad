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
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class KeyFrameBox extends HBox{
	private ArrayList<Rectangle> myKeys=new ArrayList<Rectangle>();
	private SimpleObjectProperty<KeyFrameBlock> currentKeyFrame=new SimpleObjectProperty<KeyFrameBlock>();
	private int rectangleSize=10;
	public  KeyFrameBox(double width, double height){
		this.setStyle("-fx-background-color:BLACK");
		setPrefSize(width, height);
		int startX=0;
		while((startX+10)<width){
			KeyFrameBlock myRectangle=new KeyFrameBlock(null, null, myKeys.size());
			myRectangle.relocate(startX,0);
			myRectangle.setHeight(height);
			myRectangle.setWidth(rectangleSize);
			setStyle(myRectangle);
			myRectangle.setOnMousePressed(event->glow(myRectangle));
			myKeys.add(myRectangle);
			this.getChildren().add(myRectangle);
			startX+=rectangleSize;
		}
		glow(myKeys.get(0));
	}
	private void glow(Node myNode){
		currentKeyFrame.setValue((KeyFrameBlock) myNode);
		for (Rectangle rect: myKeys){
			setStyle(rect);
		}
		myNode.setStyle("-fx-fill: BLACK");
	}
	private void setStyle(Rectangle rect){
		rect.setFill(Paint.valueOf("WHITE"));
		rect.setStyle("-fx-stroke: BLACK");
		
	}
	public ObjectProperty<KeyFrameBlock> getCurrentKeyFrame(){
		return currentKeyFrame;
	}

	
	
}
