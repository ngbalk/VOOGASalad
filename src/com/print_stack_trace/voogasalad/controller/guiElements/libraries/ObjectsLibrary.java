package com.print_stack_trace.voogasalad.controller.guiElements.libraries;

import javafx.scene.layout.Pane;

public class ObjectsLibrary extends PictureLibrary{
	public ObjectsLibrary(Number width, Number height, Pane otherPane) {
		super(width, height, otherPane);
		myResources="./com/print_stack_trace/voogasalad/controller/guiResources/ObjectImages.Properties";
		loadAndAddData();
	}
}
