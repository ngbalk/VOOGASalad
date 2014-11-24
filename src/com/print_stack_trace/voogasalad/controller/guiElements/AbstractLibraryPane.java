package com.print_stack_trace.voogasalad.controller.guiElements;


import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
public abstract class AbstractLibraryPane extends GridPane{
	protected String myResources;
	protected Pane myMainPane;
	protected double myWidth;
	protected double myHeight;
	public AbstractLibraryPane(Number width, Number height, Pane otherPane){
		this.setPrefSize((double)width, (double)height);	
		myMainPane=otherPane;
	}
	protected abstract void loadAndAddData();
	
}
