package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.scene.control.Button;

public class DeleteButton extends UserInputButton {

	public DeleteButton(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
		System.out.println("FUCK");
		((Button) myNode).setText("Delete This Object");
		((Button) myNode).setOnAction(e->mySprite.getDelegate().deleteObject((SpriteObject) object));
	}
}
