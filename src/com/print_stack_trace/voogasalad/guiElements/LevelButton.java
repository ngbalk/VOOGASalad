package com.print_stack_trace.voogasalad.guiElements;

import javafx.scene.control.Button;

public class LevelButton extends Button {
	public LevelButton(){
		this.setText("ADD LEVEL");
		this.setOnAction(event->createPane());
	}
	private void createPane(){
		PopUpPane myPane=new PopUpPane("LevelPane");
		myPane.openPane();
	}
}
