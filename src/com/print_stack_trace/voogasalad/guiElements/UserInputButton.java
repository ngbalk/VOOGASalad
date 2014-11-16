package com.print_stack_trace.voogasalad.guiElements;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class UserInputButton extends UserInputType {
	public UserInputButton(){
		myNode=new Button();
		((Button) myNode).setText("KeyFrame");
		((Button) myNode).setOnAction(event->makePopUpPane());
		
	}
	private void makePopUpPane(){
		Pane myPopUp=new KeyFramePopUpPane();
		((GeneralPane) myPopUp).openPane();
		
	}
}
