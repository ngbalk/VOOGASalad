package com.print_stack_trace.voogasalad.guiElements;


import java.util.HashSet;

import com.sun.glass.events.MouseEvent;

import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class KeyFrameBox extends HBox{
	private HashSet<Rectangle> myKeys=new HashSet<Rectangle>();
	private int rectangleSize=10;
	public  KeyFrameBox(double width, double height){
		this.setStyle("-fx-background-color:BLACK");
		setPrefSize(width, height*.1);
		int startX=0;
		while(startX<width){
			Rectangle myRectangle=new Rectangle();
			myRectangle.relocate(startX,0);
			myRectangle.setHeight(height*.1);
			myRectangle.setWidth(rectangleSize);
			setStyle(myRectangle);
			myRectangle.setOnMousePressed(event->glow(myRectangle));
			myKeys.add(myRectangle);
			this.getChildren().add(myRectangle);
			startX+=rectangleSize;
		}
	}
	private void glow(Node myNode){
		for (Rectangle rect: myKeys){
			setStyle(rect);
		}
		myNode.setStyle("-fx-fill: BLACK");
	}
	private void setStyle(Rectangle rect){
		rect.setFill(Paint.valueOf("WHITE"));
		rect.setStyle("-fx-stroke: BLACK");
		
	}
}
