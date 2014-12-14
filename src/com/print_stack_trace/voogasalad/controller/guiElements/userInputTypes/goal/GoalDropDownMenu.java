package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.goal;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GoalObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.SpriteObject;
import com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.UserInputDropDownMenu;
import com.print_stack_trace.voogasalad.model.GoalCharacteristics;
import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;

public abstract class GoalDropDownMenu extends UserInputDropDownMenu{
	public GoalDropDownMenu(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
		loadData();
		addMenus();
		loadInitial();
		setObservable();

	}

	@Override
	protected abstract void linkMovement(String dataValue);
	protected void setObservable(){
		((GoalObject) mySprite).characteristicsProperty().addListener(new ChangeListener <GoalCharacteristics> (){
			@Override
			public void changed(
					ObservableValue<? extends GoalCharacteristics> arg0,
					GoalCharacteristics arg1, GoalCharacteristics newVal) {
				observableFunction();	
			}
		});
	}

	protected abstract void observableFunction();
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