package com.print_stack_trace.voogasalad.controller.guiElements.layout;

import com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor.GamePane;
import com.print_stack_trace.voogasalad.model.engine.GameEngine;

import javafx.scene.Node;

public class GameMainLayoutNode extends AbstractLayoutNode{

	public GameMainLayoutNode(double width, double height, Node toBeLinked, Object myGameEngine, AbstractViewDelegate delegate) {
		super(width, height, toBeLinked,myGameEngine, delegate);
	}

	@Override
	public void initialize(double width, double height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initialize(double width, double height, Node myLinkedObject, Object engine, AbstractViewDelegate delegate) {
		GamePane centerPane=new GamePane(width, height, (GameEngine) engine);
		myNode=centerPane;
		
	}

	@Override
	public Number getHeight() {
		return ((GamePane) myNode).getPrefHeight();
	}

	@Override
	public Number getWidth() {
		return ((GamePane) myNode).getPrefWidth();
	}

}
