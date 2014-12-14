package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.level;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.LevelObject;
import com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.UserInputDropDownMenu;

public abstract class LevelProperty extends UserInputDropDownMenu {

	public LevelProperty(String[] values, double width, double height,
			double x, double y, GameObject object) {
		super(values, width, height, x, y, object);
	}
	@Override
	protected abstract void linkMovement(String dataValue);
	protected void createDataMap(){
		if (mySprite.getDelegate()!=null){
			mySprite.getDelegate().currentLevelProperty().addListener(new ChangeListener<LevelObject>(){
				@Override
				public void changed(ObservableValue<? extends LevelObject> arg0, LevelObject arg1, LevelObject arg2) {
					mySprite.getDelegate().actionToAllLevels((type)->addData(type));
				}
			});
		}
	}
	
	protected void addData(Object toAdd){
		if (toAdd instanceof LevelObject){
			LevelObject myObject=(LevelObject)toAdd;
			data.put(myObject.getID()+"",myObject.getCharacteristics().getName());
			addMenu(myObject.getID()+"");
		}
	}


}
