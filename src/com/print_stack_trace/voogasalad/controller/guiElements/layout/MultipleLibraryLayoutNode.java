package com.print_stack_trace.voogasalad.controller.guiElements.layout;

import com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor.AbstractViewDelegate;
import com.print_stack_trace.voogasalad.controller.guiElements.libraries.MultipleLibraryPane;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class MultipleLibraryLayoutNode extends AbstractLayoutNode{
	
	
	
	public MultipleLibraryLayoutNode(double width, double height, Node toBeLinked,Object engine, AbstractViewDelegate delegate) {
		super(width,height,toBeLinked,engine, delegate);
	}

	@Override
	public void initialize(double width, double height, Node toBeLinked, Object engine, AbstractViewDelegate delegate) {
		MultipleLibraryPane myTabPane=new MultipleLibraryPane(width, height, (Pane)toBeLinked);
		myNode=myTabPane;
	}
	@Override
	public void initialize(double width, double height) {
		// TODO Auto-generated method stub
	}

	@Override
	public Number getHeight() {
		return((MultipleLibraryPane) myNode).getPrefHeight();
	}
	
	@Override
	public Number getWidth() {
		return ((MultipleLibraryPane) myNode).getPrefWidth();	
	}
	
}
