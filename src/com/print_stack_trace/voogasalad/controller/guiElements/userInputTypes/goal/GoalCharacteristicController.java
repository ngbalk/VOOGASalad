package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.goal;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GoalObject;
import com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.CharacteristicController;
import com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.UserInputText;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public abstract class GoalCharacteristicController extends CharacteristicController{
	public GoalCharacteristicController(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
	}
	
	abstract protected void populateDefaultText();
	
	abstract protected void setCharacteristic(String newValue);
	
	protected boolean isNull(){
		return (((GoalObject) mySprite).getCharacteristics()==null);
	}
	
	protected void setObservable(SimpleIntegerProperty simpleIntProperty){
		simpleIntProperty.addListener(new ChangeListener<Number>(){
			@Override
			public void changed(ObservableValue<? extends Number> arg0,
					Number arg1,Number arg2) {
					myTextBox.setText(arg2.doubleValue()+"");
			}
		});
	}
}
