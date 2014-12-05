package com.print_stack_trace.voogasalad.controller.guiElements;


public class GoalObjectID extends GoalCharacteristicController{
	public GoalObjectID (GameObject goal){
		super(goal);
	}
	@Override
	public void setCharacteristic(String newValue){
		if (!isNull()){
			double newPointsValue =  ((GoalObject) mySprite).getCharacteristics().getObjectID();
			try{
				newPointsValue = Double.parseDouble(newValue);
			}
			catch(NumberFormatException e){

			}
			((GoalObject) mySprite).getCharacteristics().setObjectID(new Integer((int) newPointsValue));
		}
	}
	@Override
	protected void populateDefaultText() {
		if (!isNull()){
			this.myTextBox.setText(""+((GoalObject) mySprite).getCharacteristics().getObjectID());
		}
	}
}

