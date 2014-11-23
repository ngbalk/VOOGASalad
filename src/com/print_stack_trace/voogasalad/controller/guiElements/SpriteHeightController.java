package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

import javax.swing.JOptionPane;

public class SpriteHeightController extends SpriteCharacteristicController{
	public SpriteHeightController(GameObject sprite){
		super(sprite);
	}
	@Override	
	protected void setCharacteristic(String newValue){
		double newHeight = mySprite.getCharacteristics().getHeight();
		try{
			newHeight = Double.parseDouble(newValue);
		}
		catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Not a valid Height");
		}
		mySprite.getImage().setFitHeight(newHeight);
		mySprite.getCharacteristics().setHeight(newHeight);
	}
	@Override 
	protected void populateDefaultText(){
		myTextBox.setText(Double.toString(mySprite.getCharacteristics().getHeight()));
	}

}
