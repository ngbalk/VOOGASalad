package com.print_stack_trace.voogasalad.controller.author;

import com.print_stack_trace.voogasalad.controller.ViewController;
import com.print_stack_trace.voogasalad.controller.guiElements.layout.GreenGUI;
import com.print_stack_trace.voogasalad.model.engine.GameEngine;

import javafx.scene.Group;

public class GameAuthor implements ViewController {
	
	private Group root = new Group();
	private GameEngine myGameEngine;
	private double myWidth;
	private double myHeight;
	public GameAuthor(double width, double height){
		myWidth=width;
		myHeight=height;
	}
	public Group initialize(GameEngine gameEngine) {
		myGameEngine = gameEngine;
		GreenGUI myGUI=new GreenGUI(myWidth, myHeight);
		root=myGUI.initialize(gameEngine);
		return root;
	}	
}