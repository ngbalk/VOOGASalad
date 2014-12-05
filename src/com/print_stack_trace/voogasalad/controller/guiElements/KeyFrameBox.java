package com.print_stack_trace.voogasalad.controller.guiElements;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import com.print_stack_trace.voogasalad.controller.guiElements.SpriteMovement.PossibleSpriteAction;
import com.sun.glass.events.MouseEvent;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Node;
import javafx.scene.image.Image;
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
	private HBox myBox=new HBox();
	private HashMap<PossibleSpriteAction, ArrayList<Image>> movementMap;
	public  KeyFrameBox(HashMap<PossibleSpriteAction, ArrayList<Image>> movement, double width, double height){
		this.setStyle("-fx-background-color:BLACK; -fx-border-color:#0099CC; -fx-border-width: 5");
		movementMap=movement;
		setPrefSize(width, height);
		double startX=5;
		rectangleSize=(width-10)/DEFAULT_NUM_RECTANGLES-strokeWidth;
		makeKeys();
		glow(myKeys.get(0));
		this.getChildren().add(myBox);

	}
	private void makeKeys(){
		double startX=5;
		double nextMovementIndex=numKeysBetween();
		Iterator<PossibleSpriteAction> nextMovement=movementMap.keySet().iterator();
		PossibleSpriteAction myAction=nextMovement.next();
		int index=0;
		int count=1;
		//rectangleSize=(this.getPrefWidth()-10)/DEFAULT_NUM_RECTANGLES-strokeWidth;
		while(myAction!=null&& count<=DEFAULT_NUM_RECTANGLES){//(startX+rectangleSize)<this.getPrefWidth()&&myAction!=null){
			System.out.println("GOING THOUGH"+DEFAULT_NUM_RECTANGLES);
			if (nextMovementIndex!=0 ){
				KeyFrameBlock myRectangle;
				System.out.println(index);
				if (index<movementMap.get(myAction).size()){
					myRectangle=new KeyFrameBlock(movementMap.get(myAction).get(index), myAction.name(), myKeys.size());
					System.out.println(count);
				}
				else{
					myRectangle=new KeyFrameBlock(null, myAction.name(), myKeys.size());
					System.out.println(count);
				}
				myRectangle.relocate(startX,5);
				myRectangle.setHeight(this.getPrefHeight()-10);
				myRectangle.setWidth(rectangleSize);
				setStyle(myRectangle);
				myRectangle.setOnMousePressed(event->glow(myRectangle));
				myKeys.add(myRectangle);
				//this.getChildren().add(myRectangle);

				myBox.getChildren().add(myRectangle);
				count++;
				System.out.println("NO"+count);
				startX+=rectangleSize+strokeWidth;
				index++;
				nextMovementIndex--;
			}
			else{
				index=0;
				myAction=(nextMovement.hasNext())? nextMovement.next(): null;
				nextMovementIndex=numKeysBetween();
			}
		}
	}


	private int numKeysBetween(){
		return (int) (DEFAULT_NUM_RECTANGLES/movementMap.keySet().size());
	}
	public void addKeyFrame(){
		myBox.getChildren().removeAll(myKeys);
		myKeys.clear();
		DEFAULT_NUM_RECTANGLES++;
		makeKeys();
		glow(myKeys.get(currentKeyFrame.getValue().getIndex()));
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
