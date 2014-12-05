package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.scene.Node;
public interface  LayoutNode {
	Node show();
	void initialize(double width, double height);
	void initialize(double width, double height, Object myLinkedObject);
}
