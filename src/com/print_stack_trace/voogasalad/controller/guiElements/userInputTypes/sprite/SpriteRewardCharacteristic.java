package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.sprite;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.SpriteObject;

public class SpriteRewardCharacteristic extends NumberController{

	public SpriteRewardCharacteristic(String[] values, double width,
			double height, double x, double y, GameObject object) {
		super(values, width, height, x, y, object);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void populateDefaultText() {
		myTextBox.setText(((SpriteObject)mySprite).getCharacteristics().getValue()+"");
	}
	@Override
	protected Number getIntegerCharacteristic() {
		return ((SpriteObject)mySprite).getCharacteristics().getValue();
	}
	@Override
	protected Number parseNumber(String value) {
		return Integer.parseInt(value);
	}
	@Override
	protected void setCharacteristic(Number value) {
		((SpriteObject)mySprite).getCharacteristics().setValue(value.intValue());
	}
}
