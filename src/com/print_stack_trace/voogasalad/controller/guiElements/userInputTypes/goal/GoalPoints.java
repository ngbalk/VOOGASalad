package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.goal;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GoalObject;
import com.print_stack_trace.voogasalad.controller.popUpPanes.MessagePopUp;


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
			new MessagePopUp().showMessageDialog("NOT A NUMBER");
		}
		((GoalObject)mySprite).getCharacteristics().setPointsTotal(points);
		mySprite.getDelegate().update((GoalObject) mySprite);
		
	}
	

}
