package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.scene.control.Button;

public class DeleteButton extends UserInputButton {

	public DeleteButton(GameObject object, ViewObjectDelegate view){
		super(object);
		((Button) myNode).setText("Delete This Object");
		((Button) myNode).setOnAction(e->view.deleteObject((SpriteObject) object));
	}
}
