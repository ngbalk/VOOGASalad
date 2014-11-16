package com.print_stack_trace.voogasalad.controller.guiElements;

public class ObstaclesLibrary extends PictureLibrary{
	public ObstaclesLibrary(Number width, Number height, String resources) {
		super(width, height, resources);
		myResources="./com/print_stack_trace/voogasalad/guiResources/ObstacleImages.Properties";
		loadAndAddData();
	}
}
