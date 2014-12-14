package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.sprite;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;
import com.print_stack_trace.voogasalad.controller.popUpPanes.MessagePopUp;

public abstract  class NumberController extends SpriteCharacteristicController{

	public NumberController(String[] values, double width, double height,
			double x, double y, GameObject object) {
		super(values, width, height, x, y, object);
	}

	@Override
	protected void setCharacteristic(String newValue) {
		Number toChange=getIntegerCharacteristic();
		try{
			toChange = parseNumber(newValue);
		}
		catch(NumberFormatException e){
			new MessagePopUp().showMessageDialog("NOT A NUMBER");
		}
		setCharacteristic(toChange);
		mySprite.update();
	}
	protected abstract Number getIntegerCharacteristic();
	protected abstract Number parseNumber(String value);
	protected abstract void setCharacteristic(Number value);
}
