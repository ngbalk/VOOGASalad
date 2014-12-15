package com.print_stack_trace.voogasalad.controller.guiElements.layout;

import javafx.scene.Node;
public interface  LayoutNode {
	/**
	 * 
	 * @return Node that is to be displayed
	 */
	Node show();
	
	/**
	 * Creates the specific Node to be displayed
	 * @param width		width of GUI
	 * @param height	height of GUI
	 */
	void initialize(double width, double height);
	/**
	 * 
	 * @param width		width of GUI
	 * @param height	height of GUI
	 * @param myLinkedObject	Node to be linked to the this Node
	 * @param engine			GameEngine for the Node to utilize
	 * @param delegate			ViewObjectDelegate for the Node to call on
	 */
	void initialize(double width, double height, Node myLinkedObject,
			Object engine, AbstractViewDelegate delegate);
	
	//accessors for width and height
	Number getHeight();
	Number getWidth();
}
