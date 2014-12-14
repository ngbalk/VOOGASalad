package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.level;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.LevelObject;
import com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.UserInputDropDownMenu;


public class PreviousLevelProperty extends LevelProperty{
	public PreviousLevelProperty (String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
		createDataMap();
	}
	@Override
	protected void linkMovement(String dataValue) {
		((LevelObject) mySprite).getCharacteristics().setPreviousLevel(Integer.parseInt(dataValue));
		mySprite.update();
	}
}





