package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.level;

import com.print_stack_trace.voogasalad.controller.guiElements.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.LevelObject;



public class LevelNameController extends LevelCharacteristicController {
	
	public LevelNameController(String[] values,  double width, double height, double x, double y, GameObject object){
		
		super(values, width, height, x, y, object);
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
