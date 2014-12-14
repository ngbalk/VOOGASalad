package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.sprite;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

import javax.swing.JOptionPane;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.SpriteObject;

public class SpriteWidthController extends SpriteCharacteristicController{
	public SpriteWidthController(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
	}
	@Override
	public void setCharacteristic(String newValue){
		double newWidth = ((SpriteObject)mySprite).getCharacteristics().getWidth();
		try{
			newWidth = Double.parseDouble(newValue);
		}
		catch(NumberFormatException e){
			
		}
		
		((SpriteObject)mySprite).setSpriteWidth(newWidth);

	}
	@Override
	protected void populateDefaultText() {
		myTextBox.setText(Double.toString(((SpriteObject)mySprite).getCharacteristics().getWidth()));
	}

}
