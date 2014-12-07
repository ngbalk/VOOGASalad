package com.print_stack_trace.voogasalad.controller.guiElements;


public class GoalObjectiveID extends GoalCharacteristicController{
	public GoalObjectiveID (String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
	}
	@Override
	public void setCharacteristic(String newValue){
		if (!isNull()){
			double newPointsValue =  ((GoalObject) mySprite).getCharacteristics().getObjectiveID();
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
			this.myTextBox.setText(""+((GoalObject) mySprite).getCharacteristics().getObjectiveID());
		}
	}
}


