package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.scene.Node;

public abstract class UserInputType  {
	protected Node myNode=null;
	protected String[] myValues;
	protected GameObject mySprite;
	public UserInputType(){
	}
	public UserInputType(GameObject object){
		super();
		mySprite=object;
	}
	public Node getType(){
		return myNode;
	}
	
}
