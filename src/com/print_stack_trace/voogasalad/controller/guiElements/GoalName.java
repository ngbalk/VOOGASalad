package com.print_stack_trace.voogasalad.controller.guiElements;

public class GoalName extends GoalCharacteristicController{
	public GoalName(GameObject object){
		super(object);
		
	}
	@Override
	protected void populateDefaultText(){
	
		myTextBox.setText(((GoalObject) mySprite).getCharacteristics().getName());
		
	}
	@Override
	protected void setCharacteristic(String newValue) {
		((GoalObject) mySprite).getCharacteristics().setName(newValue);
		((GoalObject) mySprite).getDelegate().update((GoalObject)mySprite);
	}
}
