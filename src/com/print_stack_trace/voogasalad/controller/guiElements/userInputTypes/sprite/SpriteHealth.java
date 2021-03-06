package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.sprite;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

import javax.swing.JOptionPane;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.SpriteObject;

public class SpriteHealth extends NumberController{
	public SpriteHealth(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
	}
	@Override
	protected void populateDefaultText() {
		myTextBox.setText(Double.toString(((SpriteObject)mySprite).getCharacteristics().getStartingHealth()));
	}
	@Override
	protected Number getIntegerCharacteristic() {
		return ((SpriteObject)mySprite).getCharacteristics().getStartingHealth();
	}
	@Override
	protected Number parseNumber(String value) {
		return Integer.parseInt(value);
	}
	@Override
	protected void setCharacteristic(Number value) {
		((SpriteObject)mySprite).getCharacteristics().setStartingHealth(value.intValue());
	}

}
