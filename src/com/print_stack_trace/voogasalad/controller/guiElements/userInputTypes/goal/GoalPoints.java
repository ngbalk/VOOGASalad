package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.goal;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GoalObject;


public class GoalPoints extends GoalCharacteristicController {
	public GoalPoints(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);

	}
	@Override
	protected void populateDefaultText() {
		this.setObservable(((GoalObject) mySprite).getPointsProperty());
	}

	@Override
	protected void setCharacteristic(String newValue) {
		int points = ((GoalObject)mySprite).getCharacteristics().getPointsTotal();
		try{
			points =Integer.parseInt(newValue);
		}
		catch(NumberFormatException e){
			
		}
		((GoalObject)mySprite).getCharacteristics().setPointsTotal(points);
		mySprite.getDelegate().update((GoalObject) mySprite);
		
	}
	

}
