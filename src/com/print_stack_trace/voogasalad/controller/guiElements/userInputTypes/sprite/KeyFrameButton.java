package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.sprite;

import com.print_stack_trace.voogasalad.controller.guiElements.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.GeneralPane;
import com.print_stack_trace.voogasalad.controller.guiElements.KeyFramePopUpPane;
import com.print_stack_trace.voogasalad.controller.guiElements.UserInputButton;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class KeyFrameButton extends UserInputButton{
	public KeyFrameButton(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
		((Button) myNode).setText("KeyFrame");
		((Button) myNode).setOnAction(event->makePopUpPane());
	}
	private void makePopUpPane(){
		Pane myPopUp=new KeyFramePopUpPane(mySprite);
		((GeneralPane) myPopUp).openPane();
		
	}
}
