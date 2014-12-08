package com.print_stack_trace.voogasalad.controller.guiElements;

public class SpriteRewardCharacteristic extends SpriteCharacteristicController{

	public SpriteRewardCharacteristic(String[] values, double width,
			double height, double x, double y, GameObject object) {
		super(values, width, height, x, y, object);
		// TODO Auto-generated constructor stub
	}


	@Override
	protected void populateDefaultText() {
		myTextBox.setText(((SpriteObject)mySprite).getCharacteristics().getValue()+"");
	}

	@Override
	protected void setCharacteristic(String newValue) {
		int newPointsValue = ((SpriteObject)mySprite).getCharacteristics().getValue();
		try{
			newPointsValue = Integer.parseInt(newValue);
		}
		catch(NumberFormatException e){

		}
		((SpriteObject)mySprite).getCharacteristics().setValue(newPointsValue);
	}
}