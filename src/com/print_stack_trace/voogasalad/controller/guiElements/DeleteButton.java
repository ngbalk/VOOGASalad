package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.scene.control.Button;

public class DeleteButton extends UserInputButton {

	public DeleteButton(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
		((Button) myNode).setText("Delete This Object");
		((Button) myNode).setOnAction(e->mySprite.getDelegate().deleteObject((SpriteObject) object));
	}

	public void setPrefSize(int dim1, int dim2) {
		((Button) myNode).setPrefSize(dim1, dim2);
	}
	
	public Button getButton(){
		return (Button) myNode;
	}
}
