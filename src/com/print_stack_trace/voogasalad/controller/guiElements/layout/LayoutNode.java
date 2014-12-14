package com.print_stack_trace.voogasalad.controller.guiElements.layout;

import com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor.AbstractViewDelegate;

import javafx.scene.Node;
public interface  LayoutNode {
	Node show();
	void initialize(double width, double height);
	void initialize(double width, double height, Node myLinkedObject,
			Object engine, AbstractViewDelegate delegate);
	Number getHeight();
	Number getWidth();
}
