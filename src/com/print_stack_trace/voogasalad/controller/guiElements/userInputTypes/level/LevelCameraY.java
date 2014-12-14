
package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.level;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.LevelObject;

public class LevelCameraY extends LevelCharacteristicController{

	public LevelCameraY(String[] values, double width, double height, double x,
			double y, GameObject object) {
		super(values, width, height, x, y, object);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void populateDefaultText() {
		myTextBox.setText(((LevelObject)mySprite).getCharacteristics().getCameraStartPosition().getY()+"");
	}

	@Override
	protected void setCharacteristic(String newValue) {
		double newYValue = ((LevelObject)mySprite).getCharacteristics().getCameraStartPosition().getY();
		try{
			newYValue = Double.parseDouble(newValue);
		}
		catch(NumberFormatException e){

		}
		((LevelObject)mySprite).getCharacteristics().setCameraY(newYValue);
	}

}



