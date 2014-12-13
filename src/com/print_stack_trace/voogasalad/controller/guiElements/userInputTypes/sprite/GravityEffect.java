package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.sprite;
import com.print_stack_trace.voogasalad.controller.guiElements.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.ResourceReader;
import com.print_stack_trace.voogasalad.controller.guiElements.SpriteObject;
import com.print_stack_trace.voogasalad.controller.guiElements.UserInputDropDownMenu;

public class GravityEffect extends SpriteUserInputDropDown{
	public GravityEffect(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
	}

	@Override
	protected void linkMovement(String dataValue) {
		((SpriteObject)mySprite).getCharacteristics().setInteractive(Boolean.parseBoolean(dataValue));
		mySprite.getDelegate().update((SpriteObject)mySprite);
	}

	@Override
	protected void observableFunction() {
		loadInitial();
	}

	@Override
	protected void loadInitialFunction(String menuItemName, Object initial) {
		if (Boolean.parseBoolean(menuItemName)==(boolean)initial){
			checkSelectBox(menuItemName);
		}
		else
			uncheckSelectBox(menuItemName);
	}

	@Override
	protected void loadData() {
		myResourceReader=new ResourceReader("./com/print_stack_trace/voogasalad/controller/guiResources/Boolean.Properties");
		data=myResourceReader.getProperties();
	}


	@Override
	protected Object getCharacteristicType() {
		boolean type=((SpriteObject) mySprite).getCharacteristics().isInteractive();
		return type;
	}
}
