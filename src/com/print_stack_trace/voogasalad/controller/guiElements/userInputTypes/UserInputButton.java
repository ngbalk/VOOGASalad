package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class UserInputButton extends UserInputType {
	public UserInputButton(){
		setUpButton();
	}
	public UserInputButton(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
		setUpButton();
		mySprite=object;	
	}
	private void setUpButton(){
		myNode=new Button();
		makeInitialNode();
	}
}
