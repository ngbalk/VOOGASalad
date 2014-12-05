package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class UserInputButton extends UserInputType {
	public UserInputButton(){
		myNode=new Button();
	}
	public UserInputButton(GameObject object){
		this();
		mySprite=object;
	}
	
}
