package com.print_stack_trace.voogasalad.controller;

import com.print_stack_trace.voogasalad.exceptions.VoogaException;
import com.print_stack_trace.voogasalad.model.engine.GameEngine;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public interface ViewController {

	/**
	 * Initialization method. Setup your view objects and put them all into one
	 * root node; !!!: This method must be called after instantiation.
	 * @param  gameEngine	This is the game engine with which to run the 
	 * 						View Controller. This must not be null.
	 * @return Group	this is the root node that holds all of your view
	 * 					objects
	 */
	public abstract Group initialize(GameEngine gameEngine);
	
	public static void displayError(VoogaException exception){
		displayError(exception.printMessage());
	}
	
	public static void displayError(String message) {
		Stage errorStage = new Stage();
		errorStage.setWidth(500);
		errorStage.setHeight(200);
		errorStage.initStyle(StageStyle.UTILITY);
		Scene s = new Scene(new Group(new Text(20, 20, message)));
		errorStage.setScene(s);
		errorStage.show(); 
	}
}
