package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.scene.Node;

public abstract class AbstractLayoutNode implements LayoutNode {
	protected Node myNode;
	public AbstractLayoutNode(double width, double height, Object node){
		this.initialize(width, height, node);
	}
	@Override
	public Node show(){
		return myNode;
	}
	@Override
	public abstract void initialize(double width, double height);
	@Override
	public abstract void initialize(double width, double height, Object myLinkedObject);
	

}
