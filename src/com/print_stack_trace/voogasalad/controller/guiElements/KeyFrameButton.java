package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class KeyFrameButton extends UserInputButton{
	public KeyFrameButton(GameObject object){
		super(object);
		((Button) myNode).setText("KeyFrame");
		((Button) myNode).setOnAction(event->makePopUpPane());
	}
	private void makePopUpPane(){
		Pane myPopUp=new KeyFramePopUpPane((SpriteObject)mySprite);
		((GeneralPane) myPopUp).openPane();
		
	}
}
