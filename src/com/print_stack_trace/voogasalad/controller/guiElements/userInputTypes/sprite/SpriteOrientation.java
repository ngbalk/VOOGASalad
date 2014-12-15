package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.sprite;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.SpriteObject;

public class SpriteOrientation extends NumberController {
	public SpriteOrientation(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
	}
	@Override
	protected void populateDefaultText() {
		myTextBox.setText(((SpriteObject) mySprite).getCharacteristics().getOrientation()+"");
	}
	@Override
	protected Number getIntegerCharacteristic() {
		return mySprite.getImage().getRotate();
	}
	@Override
	protected Number parseNumber(String value) {
		return Double.parseDouble(value);
	}
	@Override
	protected void setCharacteristic(Number value) {
		mySprite.getImage().setRotate(value.doubleValue());
		((SpriteObject)mySprite).getCharacteristics().setOrientation(value.doubleValue());	
	}
}


