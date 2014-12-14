package com.print_stack_trace.voogasalad.controller.guiElements.keyFrame;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import com.print_stack_trace.voogasalad.model.engine.runtime.keyboard.KeyApplicatorFactory.KeyResult;
import com.sun.glass.events.MouseEvent;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class KeyFrameBox extends ScrollPane{
	private ArrayList<Rectangle> myKeys=new ArrayList<Rectangle>();
	private SimpleObjectProperty<KeyFrameBlock> currentKeyFrame=new SimpleObjectProperty<KeyFrameBlock>();
	private double rectangleSize;
	private double strokeWidth=4;
	private double DEFAULT_NUM_RECTANGLES=1;
	private HBox myBox=new HBox(strokeWidth);
	private HashMap<KeyResult, ArrayList<File>> movementMap;
	
	public  KeyFrameBox(HashMap<KeyResult, ArrayList<File>> movement, double width, double height){
		Pane myPane=new Pane();
		setContent(myPane);
		myPane.setStyle("-fx-background-color:BLACK; -fx-border-color:#0099CC; -fx-border-width: 5");
		setVbarPolicy(ScrollBarPolicy.NEVER);
		movementMap=movement;
		setPrefSize(width-30, height+25);
		myBox.setPrefSize(width-30, height);
		rectangleSize=(width-10)/(DEFAULT_NUM_RECTANGLES*KeyResult.values().length)-strokeWidth;
		makeKeys();
		glow(myKeys.get(0));
		myPane.getChildren().add(myBox);
	}
	
	private void makeKeys(){
		Iterator<KeyResult> nextMovement=movementMap.keySet().iterator();
		KeyResult myAction=nextMovement.next();
		int nextMovementIndex=movementMap.get(myAction).size()+1;
		int index=0;
		int count=1;
		while(myAction!=null&& count<=DEFAULT_NUM_RECTANGLES*KeyResult.values().length){
			if (nextMovementIndex!=0){
				KeyFrameBlock myRectangle;
				myRectangle=(index<movementMap.get(myAction).size() && nextMovementIndex!=1)? 
						new KeyFrameBlock(movementMap.get(myAction).get(index), null, myAction.name(),(index+1)):
						new KeyFrameBlock(null, null, myAction.name(), (index+1));
				myKeys.add(styleKeyFrame(myRectangle));
				myBox.getChildren().add(myRectangle);
				count++;
				index++;
				nextMovementIndex--;
			}
			else{
				index=0;
				myAction=(nextMovement.hasNext())? nextMovement.next(): null;
				if (myAction!=null){
					nextMovementIndex=movementMap.get(myAction).size()+1;
				}
			}
		}
	}
	
	public void addKeyFrame(){
		KeyFrameBlock current=this.currentKeyFrame.getValue();
		KeyFrameBlock temp=addKeyFrameBlock(current.getTag(), this.currentKeyFrame.getValue().getIndex());
		myKeys.add(myKeys.indexOf(current)+1,temp);
		addAll();
		glow(myKeys.get(myKeys.indexOf((temp))));
	}
	
	private void addAll(){
		myBox.getChildren().clear();
		for (Rectangle key: myKeys){
			myBox.getChildren().add(key);
		}
	}
	
	private KeyFrameBlock addKeyFrameBlock(String name, int index){
		KeyFrameBlock myRectangle=new KeyFrameBlock(null,null, name, index+1);
		return styleKeyFrame(myRectangle);
	}
	
	private KeyFrameBlock styleKeyFrame(KeyFrameBlock key){
		key.setHeight(myBox.getPrefHeight()-20);
		key.setWidth(rectangleSize);
		setStyle(key);
		key.setOnMousePressed(event->glow(key));
		return key;
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
