package com.print_stack_trace.voogasalad.controller.guiElements;

public class GoalPoints extends GoalCharacteristicController {
	public GoalPoints (GameObject goal){
		super(goal);
	}
	@Override
	public void setCharacteristic(String newValue){
		double newPointsValue =  ((GoalObject) mySprite).getCharacteristics().getPointsTotal();
		try{
			newPointsValue = Double.parseDouble(newValue);
		}
		catch(NumberFormatException e){
			
		}
		((GoalObject) mySprite).getCharacteristics().setPointsTotal(new Integer((int) newPointsValue));
	}
	@Override
	protected void populateDefaultText() {
		this.myTextBox.setText(""+((GoalObject) mySprite).getCharacteristics().getPointsTotal());
	}
}
