package com.print_stack_trace.voogasalad.controller.guiElements;



import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

import com.print_stack_trace.voogasalad.model.engine.authoring.LevelModel;

public abstract class LevelCharacteristicController extends UserInputText{
	protected GameObject myLevel;
	protected TextField myTextBox;
	public LevelCharacteristicController(GameObject level){
		myLevel = level;
		myTextBox = (TextField) myNode;
		populateDefaultText();
		myTextBox.textProperty().addListener(new ChangeListener<String>(){
			@Override
			public void changed(ObservableValue<? extends String> arg0,
					String oldVal, String newVal) {
					setCharacteristic(newVal);
			}
		});
	}
	abstract protected void populateDefaultText();
	abstract protected void setCharacteristic(String newValue);
}
