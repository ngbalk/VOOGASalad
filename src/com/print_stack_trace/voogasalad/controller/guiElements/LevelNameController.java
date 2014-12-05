package com.print_stack_trace.voogasalad.controller.guiElements;

import com.print_stack_trace.voogasalad.model.engine.authoring.LevelModel;

public class LevelNameController extends LevelCharacteristicController {
	
	public LevelNameController(GameObject level) {
		super(level);
	}
	@Override
	protected void populateDefaultText(){
		myTextBox.setText(((LevelObject) mySprite).getCharacteristics().getName());
	}
	@Override
	protected void setCharacteristic(String newValue) {
		((LevelObject)mySprite).getCharacteristics().setName(newValue);
		((LevelObject)mySprite).getDelegate().update((LevelObject)mySprite);
	}
}
