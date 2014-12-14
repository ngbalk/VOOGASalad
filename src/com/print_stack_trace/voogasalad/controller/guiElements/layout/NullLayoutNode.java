package com.print_stack_trace.voogasalad.controller.guiElements.layout;

import com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor.AbstractViewDelegate;

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

	@Override
	public Number getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Number getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

}
