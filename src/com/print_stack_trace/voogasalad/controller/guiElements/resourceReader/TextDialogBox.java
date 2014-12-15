package com.print_stack_trace.voogasalad.controller.guiElements.resourceReader;

import java.util.ArrayList;
import java.util.List;

import com.print_stack_trace.voogasalad.controller.popUpPanes.AbstractDialogBox;

import javafx.scene.control.TextField;

public class TextDialogBox extends AbstractDialogBox<TextField> {

	public TextDialogBox(TextField e) {
		super(constructorConvert(e));
	}

	public TextDialogBox(List<TextField> e) {
		super(e);
	}
	
	private static List<TextField> constructorConvert(TextField e) {
		List<TextField> ret = new ArrayList<TextField>();
		ret.add(e);
		return ret;
	}

	@Override
	public String submit() {
		TextField tf = this.nodeList.get(0);
		return tf.getText();
	}

	@Override
	public List<String> submitAll() {
		List<String> strList = new ArrayList<String>();
		for(TextField tF : this.nodeList) {
			strList.add(tF.getText());
		}
		return strList;
	}


}
