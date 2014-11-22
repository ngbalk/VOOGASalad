package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.scene.Node;
import javafx.scene.control.TextField;

public class TextDialogBox extends AbstractDialogBox {

	public TextDialogBox(Node e) {
		super((TextField) e);
	}

	@Override
	public String submit() {
		TextField tf = (TextField) this.myNode;
		return tf.getText();
	}


}
