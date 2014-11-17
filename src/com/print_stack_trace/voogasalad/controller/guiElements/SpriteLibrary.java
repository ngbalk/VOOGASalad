package com.print_stack_trace.voogasalad.controller.guiElements;

public class SpriteLibrary extends PictureLibrary {
	public SpriteLibrary(Number width, Number height, String resources) {
		super(width, height, resources);
		myResources="./com/print_stack_trace/voogasalad/controller/guiResources/SpriteImages.Properties";
		loadAndAddData();
	}
}