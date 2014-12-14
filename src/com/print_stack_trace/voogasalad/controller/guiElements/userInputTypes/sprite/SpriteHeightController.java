package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.sprite;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

import javax.swing.JOptionPane;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.SpriteObject;

public class SpriteHeightController extends SpriteCharacteristicController{
	public SpriteHeightController(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
	}
	@Override	
	protected void setCharacteristic(String newValue){
		double newHeight = ((SpriteObject)mySprite).getCharacteristics().getHeight();
		try{
			newHeight = Double.parseDouble(newValue);
		}
		catch(NumberFormatException e){
			
		}
		((SpriteObject) mySprite).setSpriteHeight(newHeight);
	}
	@Override 
	protected void populateDefaultText(){
		myTextBox.setText(Double.toString(((SpriteObject)mySprite).getCharacteristics().getHeight()));
	}

}
