package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.scene.control.TextField;

public class UserInputText extends UserInputType{
	
	public UserInputText() {
		myNode=new TextField();
	}
	public UserInputText(GameObject object){
		this();
		mySprite=object;
	}

}
