package com.print_stack_trace.voogasalad.controller;

import javafx.scene.Group;

public interface TabController {
	/**
	 * Initialization method. Setup your view objects and put them all into one
	 * root node;
	 * 
	 * @return Group	this is the root node that holds all of your Tab view
	 * 					objects
	 */
	public Group initialize();
}
