package com.print_stack_trace.voogasalad.controller.guiElements;

public class SpriteOrientation extends SpriteCharacteristicController {
	public SpriteOrientation(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
	}
	@Override
	protected void populateDefaultText() {
		myTextBox.setText(((SpriteObject) mySprite).getCharacteristics().getOrientation()+"");

	}

	@Override
	protected void setCharacteristic(String newValue) {
		double newOrientationValue = mySprite.getImage().getRotate();
		try{
			newOrientationValue = Double.parseDouble(newValue);
		}
		catch(NumberFormatException e){

		}
		mySprite.getImage().setRotate(newOrientationValue);
		((SpriteObject)mySprite).getCharacteristics().setOrientation(newOrientationValue);
		((SpriteObject)mySprite).getDelegate().update((SpriteObject) mySprite);
	}
}


