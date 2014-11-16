package com.print_stack_trace.voogasalad.controller;
import com.print_stack_trace.voogasalad.model.engine.GameEngine;

import javafx.scene.Group;

public interface ViewController {
	
	/**
	 * Initialization method. Setup your view objects and put them all into one
	 * root node; !!!: This method must be called after instantiation.
	 * @param  gameEngine	This is the game engine with which to run the 
	 * 						View Controller. This must not be null.
	 * @return Group	this is the root node that holds all of your view
	 * 					objects
	 */
	public Group initialize(GameEngine gameEngine);
}
