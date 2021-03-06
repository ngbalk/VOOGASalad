
package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.level;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.LevelObject;
import com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.CharacteristicController;
import com.print_stack_trace.voogasalad.controller.popUpPanes.MessagePopUp;

public class LevelCameraY extends CharacteristicController{

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
			new MessagePopUp().showMessageDialog("Not A Number");
		}
		((LevelObject)mySprite).getCharacteristics().setCameraY(newYValue);
	}
}



