package com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor;

import javafx.scene.Node;

public interface Extend {
	
	/**
	 * Interface function for lambda use in ExtendDirection
	 * @param view			Node to extend
	 * @param horizontal	width of Pane that Node is on
	 * @param vertical		height of Pane that Node is on
	 */
	void extend(Node view, int horizontal, int vertical);
}
