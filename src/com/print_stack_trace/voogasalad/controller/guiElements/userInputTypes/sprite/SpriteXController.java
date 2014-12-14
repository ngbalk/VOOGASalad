package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.sprite;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.SpriteObject;

public class SpriteXController extends SpriteCharacteristicController{
	public SpriteXController(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
	}
	@Override
	public void setCharacteristic(String newValue){
		double newXValue = ((SpriteObject) mySprite).getCharacteristics().getX();
		try{
			newXValue = Double.parseDouble(newValue);
		}
		catch(NumberFormatException e){
			
		}
		((SpriteObject)mySprite).setSpriteX(newXValue);
	}
	@Override
	protected void populateDefaultText() {
		this.setObservable(((SpriteObject) mySprite).getObservableX());
	}
}
