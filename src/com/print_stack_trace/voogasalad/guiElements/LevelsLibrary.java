package com.print_stack_trace.voogasalad.guiElements;

public class LevelsLibrary extends PictureLibrary{
	public LevelsLibrary(Number width, Number height, String resources) {
		super(width, height, resources);
		myResources="./com/print_stack_trace/voogasalad/guiResources/LevelImages.Properties";
		loadAndAddData();
	}

	
}
