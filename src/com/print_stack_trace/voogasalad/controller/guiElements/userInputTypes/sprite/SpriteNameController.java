package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.sprite;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.SpriteObject;
import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class SpriteNameController extends SpriteCharacteristicController {

	public SpriteNameController(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
		this.setCharacteristicsObservable();
	}
	@Override
	protected void populateDefaultText() {
		myTextBox.setText(((SpriteObject)mySprite).getCharacteristics().getName());
	}
	@Override
	protected void setCharacteristic(String newValue) {
		mySprite.getDelegate().removeSpriteObjects((SpriteObject) mySprite);
		((SpriteObject)mySprite).getCharacteristics().setName(newValue);
		mySprite.update();
	}
	
}
