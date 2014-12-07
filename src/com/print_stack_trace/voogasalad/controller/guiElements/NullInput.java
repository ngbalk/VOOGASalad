package com.print_stack_trace.voogasalad.controller.guiElements;

public class NullInput extends UserInputType{
	public NullInput(){
		myNode=null;
	}
	public NullInput(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
		mySprite=object;
		myNode=null;
	}
}
