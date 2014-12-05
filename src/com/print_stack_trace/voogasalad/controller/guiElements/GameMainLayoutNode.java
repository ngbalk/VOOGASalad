package com.print_stack_trace.voogasalad.controller.guiElements;

import com.print_stack_trace.voogasalad.model.engine.GameEngine;

import javafx.scene.Node;

public class GameMainLayoutNode extends AbstractLayoutNode{

	public GameMainLayoutNode(double width, double height, Object myGameEngine) {
		super(width, height, myGameEngine);
	}

	@Override
	public void initialize(double width, double height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initialize(double width, double height, Object myLinkedObject) {
		GamePane centerPane=new GamePane(width, height, (GameEngine)myLinkedObject);
	
		myNode=centerPane;
		
	}

}
