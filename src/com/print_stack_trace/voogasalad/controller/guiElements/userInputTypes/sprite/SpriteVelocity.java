package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.sprite;



import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

import javax.swing.JOptionPane;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.SpriteObject;

public class SpriteVelocity extends NumberController{
	public SpriteVelocity(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
	}
	@Override
	protected void populateDefaultText() {
		myTextBox.setText(Double.toString(((SpriteObject)mySprite).getCharacteristics().getStartingSpeed()));
	}
	@Override
	protected Number getIntegerCharacteristic() {
		return ((SpriteObject)mySprite).getCharacteristics().getStartingSpeed();
	}
	@Override
	protected Number parseNumber(String value) {
		return Double.parseDouble(value);
	}
	@Override
	protected void setCharacteristic(Number value) {
		((SpriteObject)mySprite).getCharacteristics().setStartingSpeed(value.doubleValue());
	}

}

