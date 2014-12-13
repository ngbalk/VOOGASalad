package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.sprite;

import com.print_stack_trace.voogasalad.controller.guiElements.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.SpriteObject;
import com.print_stack_trace.voogasalad.controller.guiElements.UserInputButton;

import javafx.scene.control.Button;

public class DeleteButton extends UserInputButton {

	public DeleteButton(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
		((Button) myNode).setText("Delete This Object");
		((Button) myNode).setOnAction(e->mySprite.getDelegate().deleteObject((SpriteObject) object));
	}
}
