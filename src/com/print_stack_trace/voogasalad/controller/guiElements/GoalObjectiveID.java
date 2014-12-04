package com.print_stack_trace.voogasalad.controller.guiElements;


public class GoalObjectiveID extends GoalCharacteristicController{
	public GoalObjectiveID (GameObject goal){
		super(goal);
	}
	@Override
	public void setCharacteristic(String newValue){
		double newPointsValue =  ((GoalObject) mySprite).getCharacteristics().getObjectiveID();
				try{
					newPointsValue = Double.parseDouble(newValue);
				}
		catch(NumberFormatException e){

		}
		((GoalObject) mySprite).getCharacteristics().setObjectID(new Integer((int) newPointsValue));
	}
	@Override
	protected void populateDefaultText() {
		this.myTextBox.setText(""+((GoalObject) mySprite).getCharacteristics().getObjectiveID());
	}
}


