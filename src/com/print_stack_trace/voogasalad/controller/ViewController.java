package com.print_stack_trace.voogasalad.controller;
<<<<<<< HEAD

import com.print_stack_trace.voogasalad.exceptions.VoogaException;
=======
>>>>>>> master
import com.print_stack_trace.voogasalad.model.engine.GameEngine;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public abstract class ViewController {
	/**
	 * Initialization method. Setup your view objects and put them all into one
	 * root node; !!!: This method must be called after instantiation.
	 * @param  gameEngine	This is the game engine with which to run the 
	 * 						View Controller. This must not be null.
	 * @return Group	this is the root node that holds all of your view
	 * 					objects
	 */
	public abstract Group initialize(GameEngine gameEngine);
	
	public void displayError(VoogaException exception){
		Stage errorStage = new Stage();
		errorStage.setWidth(500);
		errorStage.setHeight(200);
		errorStage.initStyle(StageStyle.UTILITY);
		Scene s = new Scene(new Group(new Text(20, 20, exception.printMessage())));
		errorStage.setScene(s);
		errorStage.show(); 
	}
}
