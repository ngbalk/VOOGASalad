package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public abstract class SpriteCharacteristicController extends UserInputText {
	protected TextField myTextBox;
	public SpriteCharacteristicController(GameObject sprite) {
		super(sprite);
		myTextBox = (TextField) myNode;
		mySprite = sprite;
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
