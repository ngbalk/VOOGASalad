package com.print_stack_trace.voogasalad.controller.guiElements.layout;

import com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor.AbstractViewDelegate;
import com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor.ViewObjectDelegate;
import com.print_stack_trace.voogasalad.controller.guiElements.topFileMenuBar.FileMenuBar;

import javafx.scene.Node;

public class GameFileMenuLayoutNode extends AbstractLayoutNode{

	public GameFileMenuLayoutNode(double width, double height, Node focus, Object engine, AbstractViewDelegate delegate) {
		super(width, height, focus, engine, delegate);
		
	}

	@Override
	public void initialize(double width, double height) {
		
	}

	@Override
	public void initialize(double width, double height, Node myLinkedObject, Object engine, AbstractViewDelegate delegate) {
		FileMenuBar file=new FileMenuBar(delegate,(ViewObjectDelegate) myLinkedObject);
		file.setPrefSize(width, height);
		myNode=file;
		
	}

	@Override
	public Number getHeight() {
		return ((FileMenuBar) myNode).getPrefHeight();
	}

	@Override
	public Number getWidth() {
		return ((FileMenuBar) myNode).getPrefWidth();
	}

}
