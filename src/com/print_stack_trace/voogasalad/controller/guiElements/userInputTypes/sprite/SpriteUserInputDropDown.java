package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.sprite;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.SpriteObject;
import com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.UserInputDropDownMenu;
import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;

public abstract class SpriteUserInputDropDown extends UserInputDropDownMenu{
	public SpriteUserInputDropDown(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
		loadData();
		addMenus();
		loadInitial();
		setObservable();

	}

	@Override
	protected abstract void linkMovement(String dataValue);
	protected void setObservable(){
		((SpriteObject) mySprite).characteristicsProperty().addListener(new ChangeListener <SpriteCharacteristics> (){
			@Override
			public void changed(
					ObservableValue<? extends SpriteCharacteristics> arg0,
					SpriteCharacteristics arg1, SpriteCharacteristics newVal) {
				observableFunction();	
			}
		});
	}

	protected void observableFunction(){
		loadInitial();
	}
	protected void loadInitial(){
		Object type=getCharacteristicType();
		for (String menuItemName: menuMap.keySet()){
			loadInitialFunction(menuItemName,type);
		}
	}
	protected abstract void loadInitialFunction(String name, Object type);
	protected abstract void loadData();
	protected abstract Object getCharacteristicType();
}