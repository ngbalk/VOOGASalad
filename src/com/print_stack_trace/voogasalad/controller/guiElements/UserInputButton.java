package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class UserInputButton extends UserInputType {
	public UserInputButton(){
		myNode=new Button();
	}
	public UserInputButton(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
		mySprite=object;
		myNode=new Button();
		
	}
	
}
