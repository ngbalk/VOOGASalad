package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.sprite;



import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

import javax.swing.JOptionPane;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.SpriteObject;

public class SpriteVelocity extends SpriteCharacteristicController{
	public SpriteVelocity(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
	}
	@Override
	public void setCharacteristic(String newValue){
		double newSpeed = ((SpriteObject)mySprite).getCharacteristics().getStartingSpeed();
		try{
			newSpeed = Double.parseDouble(newValue);
		}
		catch(NumberFormatException e){
			
		}
		
		((SpriteObject)mySprite).getCharacteristics().setStartingSpeed(newSpeed);
		mySprite.getDelegate().update((SpriteObject) mySprite);
	}
	@Override
	protected void populateDefaultText() {
		myTextBox.setText(Double.toString(((SpriteObject)mySprite).getCharacteristics().getStartingSpeed()));
	}

}

