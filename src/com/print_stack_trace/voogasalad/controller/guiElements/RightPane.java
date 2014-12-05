package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.scene.Node;

public abstract class RightPane implements LayoutNode {
	private Node myNode;
	public RightPane(){
		initialize();
	}
	public Node show(){
		return myNode;
	}
	public void initialize(){
		
	}
	
}
