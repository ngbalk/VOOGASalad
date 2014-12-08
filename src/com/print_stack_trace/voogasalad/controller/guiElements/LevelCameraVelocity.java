package com.print_stack_trace.voogasalad.controller.guiElements;

public class LevelCameraVelocity extends LevelCharacteristicController{
	
	public LevelCameraVelocity(String[] values, double width, double height, double x,
			double y, GameObject object) {
		super(values, width, height, x, y, object);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void populateDefaultText() {
		myTextBox.setText(((LevelObject)mySprite).getCharacteristics().getCameraSpeed()+"");
	}

	@Override
	protected void setCharacteristic(String newValue) {
		double newSpeed = ((LevelObject)mySprite).getCharacteristics().getCameraSpeed();
		try{
			newSpeed = Double.parseDouble(newValue);
		}
		catch(NumberFormatException e){
			
		}
		((LevelObject)mySprite).getCharacteristics().setCameraX(newSpeed);
	}
	
}
