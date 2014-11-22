package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.scene.control.Button;

public class LevelButton extends Button {
	public LevelButton(){
		this.setText("ADD LEVEL");
		this.setOnAction(event->createPane());
	}
	private void createPane(){
		GeneralPane myPane=new PopUpPane("LevelPane", null);
		myPane.openPane();
	}
}
