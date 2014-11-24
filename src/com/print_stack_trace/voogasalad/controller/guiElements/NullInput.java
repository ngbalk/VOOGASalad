package com.print_stack_trace.voogasalad.controller.guiElements;

public class NullInput extends UserInputType{
	public NullInput(){
		myNode=null;
	}
	public NullInput(GameObject object){
		this();
		mySprite=object;
	}
}
