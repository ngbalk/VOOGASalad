package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class MultipleLibraryLayoutNode extends AbstractLayoutNode{
	
	public MultipleLibraryLayoutNode(double width, double height, Node myNode) {
		super(width, height, myNode);
	}
	
	@Override
	public void initialize(double width, double height, Object toBeLinked) {
		MultipleLibraryPane myTabPane=new MultipleLibraryPane(width, height, (Pane)toBeLinked);
		myNode=myTabPane;
	}
	@Override
	public void initialize(double width, double height) {
		// TODO Auto-generated method stub
	}
	
}
