package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.sprite;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

import javax.swing.JOptionPane;

import com.print_stack_trace.voogasalad.controller.guiElements.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.SpriteObject;

public class SpriteHealth extends SpriteCharacteristicController{
	public SpriteHealth(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
	}
	@Override
	public void setCharacteristic(String newValue){
		int newHealth = ((SpriteObject)mySprite).getCharacteristics().getStartingHealth();
		try{
			newHealth = Integer.parseInt(newValue);
		}
		catch(NumberFormatException e){
			
		}
		
		((SpriteObject)mySprite).getCharacteristics().setStartingHealth(newHealth);
		mySprite.getDelegate().update((SpriteObject) mySprite);
	}
	@Override
	protected void populateDefaultText() {
		myTextBox.setText(Double.toString(((SpriteObject)mySprite).getCharacteristics().getStartingHealth()));
	}

}
