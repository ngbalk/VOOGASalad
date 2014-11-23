package com.print_stack_trace.voogasalad.controller.guiElements;

import com.print_stack_trace.voogasalad.model.engine.authoring.LevelModel;

public class LevelNameController extends LevelCharacteristicController {
	
	public LevelNameController(LevelModel level) {
		super(level);
	}
	@Override
	protected void populateDefaultText() {
		myTextBox.setText(myLevel.getLevelCharacteristics().getName());
	}
	@Override
	protected void setCharacteristic(String newValue) {
		mySprite.getCharacteristics().setName(newValue);

	}

}
