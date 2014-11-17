package com.print_stack_trace.voogasalad.controller.guiElements;

public class LevelsLibrary extends PictureLibrary{
	public LevelsLibrary(Number width, Number height, String resources) {
		super(width, height, resources);
		myResources="./com/print_stack_trace/voogasalad/controller/guiResources/LevelImages.Properties";
		loadAndAddData();
	}

	
}
