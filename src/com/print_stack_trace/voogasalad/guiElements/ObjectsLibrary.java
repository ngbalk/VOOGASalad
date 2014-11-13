package com.print_stack_trace.voogasalad.guiElements;

import javafx.scene.layout.Pane;

public class ObjectsLibrary extends PictureLibrary{

	public ObjectsLibrary(Number width, Number height, Pane otherPane) {
		super(width, height, otherPane);
		myResources="./com/print_stack_trace/voogasalad/guiResources/ObjectImages.Properties";
		loadAndAddData();
	}
}
