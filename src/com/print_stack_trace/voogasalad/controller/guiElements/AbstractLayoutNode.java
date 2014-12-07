package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.scene.Node;

public abstract class AbstractLayoutNode implements LayoutNode {
	protected Node myNode;
	public AbstractLayoutNode(double width, double height, Node focus, Object engine, AbstractViewDelegate delegate){
		this.initialize(width, height, focus, engine, delegate);
	}
	@Override
	public Node show(){
		return myNode;
	}
	@Override
	public abstract void initialize(double width, double height);
	@Override
	public abstract void initialize(double width, double height, Node myLinkedObject, Object engine, AbstractViewDelegate delegate);
	public abstract Number getHeight();
	public abstract Number getWidth();

}
