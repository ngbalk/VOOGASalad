package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.scene.Node;

public class GameFileMenuLayoutNode extends AbstractLayoutNode{

	public GameFileMenuLayoutNode(double width, double height, Object myNode) {
		super(width, height, myNode);
		
	}

	@Override
	public void initialize(double width, double height) {
		FileMenuBar file=new FileMenuBar();
		file.setPrefSize(width, height);
		myNode=file;
	}

	@Override
	public void initialize(double width, double height, Object myLinkedObject) {
		initialize(width, height);
		
	}

}
