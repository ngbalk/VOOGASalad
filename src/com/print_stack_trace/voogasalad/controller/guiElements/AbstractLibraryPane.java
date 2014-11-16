package com.print_stack_trace.voogasalad.controller.guiElements;
import javafx.scene.layout.Pane;
public abstract class AbstractLibraryPane extends Pane{
	protected String myResources;
	public AbstractLibraryPane(Number width, Number height, String resources){
		this.setPrefSize((double)width, (double)height);	
		myResources=resources;
	}
	protected abstract void loadAndAddData();
	
}
