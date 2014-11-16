package com.print_stack_trace.voogasalad.controller.author;

import com.print_stack_trace.voogasalad.controller.ViewController;
import com.print_stack_trace.voogasalad.guiElements.AbstractGUI;
import com.print_stack_trace.voogasalad.guiElements.GreenGUI;
import com.print_stack_trace.voogasalad.model.engine.GameEngine;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;

public class GameAuthor implements ViewController {
	
	private Group root = new Group();
	private GameEngine gameEngine;
	private double myWidth;
	private double myHeight;
	public GameAuthor(double width, double height){
		myWidth=width;
		myHeight=height;
	}
	public Group initialize(GameEngine gameEngine) {
		gameEngine = gameEngine;
		GreenGUI myGUI=new GreenGUI(myWidth, myHeight);
		root=myGUI.initialize(gameEngine);
		return root;
	}	
}