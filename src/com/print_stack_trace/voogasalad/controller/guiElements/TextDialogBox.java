package com.print_stack_trace.voogasalad.controller.guiElements;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.TextField;

public class TextDialogBox extends AbstractDialogBox {

	public TextDialogBox(TextField e) {
		super(e);
	}
	
	public TextDialogBox(List<TextField> e) {
		super(e);
	}

	@Override
	public String submit() {
		TextField tf = this.tfList.get(0);
		return tf.getText();
	}

	@Override
	public List<String> submitAll() {
		List<String> strList = new ArrayList<String>();
		for(TextField tF : this.tfList) {
			strList.add(tF.getText());
		}
		return strList;
	}


}
