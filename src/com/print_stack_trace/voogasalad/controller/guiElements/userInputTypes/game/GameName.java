package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.game;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameWorldObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.LevelObject;

public class GameName extends GameCharacteristicController{
	public GameName(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
	}
	
	@Override
	protected void populateDefaultText(){
		myTextBox.setText(((GameWorldObject)mySprite).getCharacteristics().getGameTitle()+"");
	}
	@Override
	protected void setCharacteristic(String newValue) {
		((GameWorldObject)mySprite).getCharacteristics().setGameTitle(newValue);
		mySprite.update();
	}
}
