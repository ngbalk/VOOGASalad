package com.print_stack_trace.voogasalad.controller.guiElements;

public class EnemiesLibrary extends PictureLibrary{
	public EnemiesLibrary(Number width, Number height, String resources) {
		super(width, height, resources);
		myResources="./com/print_stack_trace/voogasalad/controller/guiResources/EnemyImages.Properties";
		loadAndAddData();
	}
}
