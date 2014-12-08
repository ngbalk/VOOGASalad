package com.print_stack_trace.voogasalad.controller.guiElements;

public class LevelCameraX extends LevelCharacteristicController{
	
	public LevelCameraX(String[] values, double width, double height, double x,
			double y, GameObject object) {
		super(values, width, height, x, y, object);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void populateDefaultText() {
		myTextBox.setText(((LevelObject)mySprite).getCharacteristics().getCameraStartPosition().getX()+"");
	}

	@Override
	protected void setCharacteristic(String newValue) {
		double newXValue = ((LevelObject)mySprite).getCharacteristics().getCameraStartPosition().getX();
		try{
			newXValue = Double.parseDouble(newValue);
		}
		catch(NumberFormatException e){
			
		}
		((LevelObject)mySprite).getCharacteristics().setCameraX(newXValue);
	}
	
}