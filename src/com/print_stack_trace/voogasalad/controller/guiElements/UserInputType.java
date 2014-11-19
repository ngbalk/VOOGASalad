package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.scene.Node;

public abstract class UserInputType  {
	protected Node myNode=null;
	protected String[] myValues;
	public UserInputType(){
	}
	public Node getType(){
		return myNode;
	}
}
