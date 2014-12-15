package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.sprite;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.SpriteObject;

public class SpriteXController extends NumberController{
	public SpriteXController(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
	}
	
	@Override
	protected void populateDefaultText() {
		this.setObservable(((SpriteObject) mySprite).getObservableX());
	}
	@Override
	protected Number getIntegerCharacteristic() {		
		return ((SpriteObject) mySprite).getCharacteristics().getX();
	}
	@Override
	protected Number parseNumber(String value) {
		return Double.parseDouble(value);
	}
	@Override
	protected void setCharacteristic(Number value) {
		((SpriteObject)mySprite).setSpriteX(value.doubleValue());
		
	}
}
