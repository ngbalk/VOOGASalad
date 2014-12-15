package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.sprite;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;


public abstract class BooleanController extends SpriteUserInputDropDown{
	public BooleanController(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
	}
	@Override
	protected abstract void linkMovement(String dataValue);
	protected abstract Object getCharacteristicType();
	@Override
	protected abstract void loadData();
	@Override
	protected void loadInitialFunction(String menuItemName, Object initial) {
		if (Boolean.parseBoolean(menuItemName)==((boolean)initial))
			checkSelectBox(menuItemName);
		else
			uncheckSelectBox(menuItemName);
	}
	
}

