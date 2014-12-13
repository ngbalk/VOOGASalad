package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.sprite;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

import javax.swing.JOptionPane;

import com.print_stack_trace.voogasalad.controller.guiElements.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.ResourceReader;
import com.print_stack_trace.voogasalad.controller.guiElements.SpriteObject;
import com.print_stack_trace.voogasalad.controller.guiElements.UserInputDropDownMenu;

public class DoubleJump extends SpriteUserInputDropDown{
	public DoubleJump(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
	}

	@Override
	protected void linkMovement(String dataValue) {
		((SpriteObject)mySprite).getCharacteristics().setDoubleJump(Boolean.parseBoolean(dataValue));
		setCurrent(data.get(dataValue));
		mySprite.getDelegate().update((SpriteObject)mySprite);
	}

	@Override
	protected void observableFunction() {
		loadInitial();
	}

	@Override
	protected void loadInitialFunction(String menuItemName, Object initial) {
		if (Boolean.parseBoolean(menuItemName)==((boolean)initial)){
			checkSelectBox(menuItemName);
		}
		else
			uncheckSelectBox(menuItemName);
	}

	protected Object getCharacteristicType(){
		boolean type=((SpriteObject) mySprite).getCharacteristics().canDoubleJump();
		return type;
	}
	@Override
	protected void loadData() {
		myResourceReader=new ResourceReader("./com/print_stack_trace/voogasalad/controller/guiResources/Boolean.Properties");
		data=myResourceReader.getProperties();		
	}
}

