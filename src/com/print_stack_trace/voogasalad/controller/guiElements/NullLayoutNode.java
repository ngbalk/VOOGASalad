package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.scene.Node;

public class NullLayoutNode extends AbstractLayoutNode{
	

	public NullLayoutNode(double myWidth, double myHeight, Node toBeLinked,Object engine, AbstractViewDelegate delegate) {
		super(myWidth, myHeight, toBeLinked,engine, delegate);
	}

	@Override
	public void initialize(double width, double height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initialize(double width, double height, Node myLinkedObject, Object engine, AbstractViewDelegate delegate) {
		// TODO Auto-generated method stub
		
	}

}
