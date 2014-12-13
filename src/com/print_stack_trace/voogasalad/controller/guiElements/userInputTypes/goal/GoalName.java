package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.goal;

import com.print_stack_trace.voogasalad.controller.guiElements.GameObject;

public class GoalName extends GoalCharacteristicController{
	public GoalName(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);

	}
	@Override
	protected void populateDefaultText(){
		if (!isNull()){
			myTextBox.setText(((GoalObject) mySprite).getCharacteristics().getName());
		}
	}
	@Override
	protected void setCharacteristic(String newValue) {
		if (!isNull()){
			((GoalObject) mySprite).getCharacteristics().setName(newValue);
			((GoalObject) mySprite).getDelegate().update((GoalObject)mySprite);
		}
	}
	
}
