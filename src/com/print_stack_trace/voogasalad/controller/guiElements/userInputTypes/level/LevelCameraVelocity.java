package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.level;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.LevelObject;
import com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.CharacteristicController;
import com.print_stack_trace.voogasalad.controller.popUpPanes.MessagePopUp;

public class LevelCameraVelocity extends CharacteristicController{
	
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
			new MessagePopUp().showMessageDialog("Not A Number");
		}
		((LevelObject)mySprite).getCharacteristics().setCameraX(newSpeed);
	}
	
}
