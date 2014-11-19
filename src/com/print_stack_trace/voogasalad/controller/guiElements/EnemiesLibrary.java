package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.scene.layout.Pane;

public class EnemiesLibrary extends PictureLibrary{
public EnemiesLibrary(Number width, Number height, Pane otherPane) {
		super(width, height, otherPane);
		myResources="./com/print_stack_trace/voogasalad/controller/guiResources/EnemyImages.Properties";
		loadAndAddData();
	}
}
