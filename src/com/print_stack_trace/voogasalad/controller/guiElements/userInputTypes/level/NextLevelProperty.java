package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.level;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.LevelObject;
import com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.UserInputDropDownMenu;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;

public class NextLevelProperty extends LevelProperty{
	public NextLevelProperty (String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
		createDataMap();
	}

	@Override
	protected void linkMovement(String dataValue) {
		((LevelObject)mySprite).getCharacteristics().setNextLevel(Integer.parseInt(dataValue));
		mySprite.update();
		currentMenu.setText(dataValue);


	}
}






