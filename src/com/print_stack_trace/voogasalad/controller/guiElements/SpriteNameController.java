package com.print_stack_trace.voogasalad.controller.guiElements;

import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class SpriteNameController extends SpriteCharacteristicController {

	public SpriteNameController(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
	}
	@Override
	protected void populateDefaultText() {
		myTextBox.setText(((SpriteObject)mySprite).getCharacteristics().getName());
	}
	@Override
	protected void setCharacteristic(String newValue) {
		mySprite.getDelegate().removeSpriteOBjects((SpriteObject) mySprite);
		((SpriteObject)mySprite).getCharacteristics().setName(newValue);
		mySprite.getDelegate().update((SpriteObject) mySprite);
	}
	
}
