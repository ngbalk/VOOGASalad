package com.print_stack_trace.voogasalad.controller.guiElements;

public class SpriteNameController extends SpriteCharacteristicController {

	public SpriteNameController(GameObject sprite) {
		super(sprite);
	}
	@Override
	protected void populateDefaultText() {
		myTextBox.setText(((SpriteObject)mySprite).getCharacteristics().getName());
	}
	@Override
	protected void setCharacteristic(String newValue) {
		((SpriteObject)mySprite).getCharacteristics().setName(newValue);
	}

}
