package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;

import javafx.scene.control.TextField;

public class UserInputText extends UserInputType{
	
	public UserInputText() {
		this(null, 0, 0, 0, 0, null);
	}
	public UserInputText(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
		mySprite=object;
		myNode=new TextField();
		makeInitialNode();	
	}
}
