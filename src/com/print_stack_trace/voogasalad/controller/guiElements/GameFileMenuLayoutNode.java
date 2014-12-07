package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.scene.Node;

public class GameFileMenuLayoutNode extends AbstractLayoutNode{

	public GameFileMenuLayoutNode(double width, double height, Node focus, Object engine, AbstractViewDelegate delegate) {
		super(width, height, focus, engine, delegate);
		
	}

	@Override
	public void initialize(double width, double height) {
		
	}

	@Override
	public void initialize(double width, double height, Node myLinkedObject, Object engine, AbstractViewDelegate delegate) {
		FileMenuBar file=new FileMenuBar(delegate);
		file.setPrefSize(width, height);
		myNode=file;
		
	}

}
