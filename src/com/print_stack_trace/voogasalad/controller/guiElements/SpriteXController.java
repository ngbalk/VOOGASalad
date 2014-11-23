package com.print_stack_trace.voogasalad.controller.guiElements;

import javax.swing.JOptionPane;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class SpriteXController extends SpriteCharacteristicController{
	public SpriteXController (GameObject sprite){
		super(sprite);
	}
	@Override
	public void setCharacteristic(String newValue){
		double newXValue = mySprite.getImage().getLayoutX();
		try{
			newXValue = Double.parseDouble(newValue);
		}
		catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Not a valid X location");
		}
		mySprite.getImage().setLayoutX(newXValue);
		mySprite.getCharacteristics().setX(newXValue);
	}
	@Override
	protected void populateDefaultText() {
		myTextBox.setText(Double.toString(mySprite.getImage().getLayoutX()));
	}

}
