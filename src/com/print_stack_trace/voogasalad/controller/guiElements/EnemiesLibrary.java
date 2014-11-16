package com.print_stack_trace.voogasalad.guiElements;

public class EnemiesLibrary extends PictureLibrary{
	public EnemiesLibrary(Number width, Number height, String resources) {
		super(width, height, resources);
		myResources="./com/print_stack_trace/voogasalad/guiResources/EnemyImages.Properties";
		loadAndAddData();
	}
}
