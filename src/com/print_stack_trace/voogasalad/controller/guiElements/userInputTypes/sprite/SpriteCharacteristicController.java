package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.sprite;


import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.SpriteObject;
import com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.CharacteristicController;
import com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.UserInputText;
import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public abstract class SpriteCharacteristicController extends CharacteristicController {
	public SpriteCharacteristicController(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
	}
	abstract protected void populateDefaultText();
	
	abstract protected void setCharacteristic(String newValue);
	
	protected void setObservable(SimpleDoubleProperty simpleDoubleProperty){
		simpleDoubleProperty.addListener(new ChangeListener<Number>(){
			@Override
			public void changed(ObservableValue<? extends Number> arg0,
					Number arg1,Number arg2) {
					myTextBox.setText(arg2.doubleValue()+"");
			}
		});
	}
	
	protected void setCharacteristicsObservable(){
		((SpriteObject)mySprite).characteristicsProperty().addListener(new ChangeListener<SpriteCharacteristics>(){
			@Override
			public void changed(
					ObservableValue<? extends SpriteCharacteristics> ar0,
					SpriteCharacteristics arg1, SpriteCharacteristics newVal) {
					populateDefaultText();
			}
		});
	}
}
