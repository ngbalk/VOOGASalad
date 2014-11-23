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
			JOptionPane.showMessageDialog(null, "Not a valid X location");
		}
		mySprite.getImage().setLayoutY(newYValue);
		mySprite.getCharacteristics().setY(newYValue);
	}
	@Override
	protected void populateDefaultText() {
		myTextBox.setText(Double.toString(mySprite.getImage().getLayoutY()));
		
	}

}
