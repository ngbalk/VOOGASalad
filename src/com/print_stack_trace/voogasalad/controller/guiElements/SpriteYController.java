package com.print_stack_trace.voogasalad.controller.guiElements;

import javax.swing.JOptionPane;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class SpriteYController extends SpriteCharacteristicController{
	public SpriteYController (GameObject sprite){
		super(sprite);
	}
	@Override
	public void setCharacteristic(String newValue){
		double newYValue = mySprite.getImage().getLayoutY();
		try{
			newYValue = Double.parseDouble(newValue);
		}
		catch(NumberFormatException e){
			
		}
		mySprite.getImage().setLayoutY(newYValue);
		((SpriteObject)mySprite).getCharacteristics().setY(newYValue);
		mySprite.getDelegate().update((SpriteObject) mySprite);
	}
	@Override
	protected void populateDefaultText() {
		myTextBox.setText(Double.toString(mySprite.getImage().getLayoutY()));
		
	}

}
