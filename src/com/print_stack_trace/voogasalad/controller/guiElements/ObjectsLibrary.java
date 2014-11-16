package com.print_stack_trace.voogasalad.controller.guiElements;

public class ObjectsLibrary extends PictureLibrary{

	public ObjectsLibrary(Number width, Number height, String resources) {
		super(width, height, resources);
		myResources="./com/print_stack_trace/voogasalad/guiResources/ObjectImages.Properties";
		loadAndAddData();
	}
}
