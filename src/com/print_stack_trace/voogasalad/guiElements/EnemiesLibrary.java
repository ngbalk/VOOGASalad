package com.print_stack_trace.voogasalad.guiElements;

import javafx.scene.layout.Pane;

public class EnemiesLibrary extends PictureLibrary{
	public EnemiesLibrary(Number width, Number height, Pane otherPane) {
		super(width, height, otherPane);
		myResources="./com/print_stack_trace/voogasalad/guiResources/EnemyImages.Properties";
		loadAndAddData();
	}
}
