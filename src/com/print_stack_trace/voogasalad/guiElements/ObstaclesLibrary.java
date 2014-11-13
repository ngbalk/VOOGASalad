package com.print_stack_trace.voogasalad.guiElements;

import javafx.scene.layout.Pane;

public class ObstaclesLibrary extends PictureLibrary{
	public ObstaclesLibrary(Number width, Number height, Pane otherPane) {
		super(width, height, otherPane);
		myResources="./com/print_stack_trace/voogasalad/guiResources/ObstacleImages.Properties";
		loadAndAddData();
	}
}
