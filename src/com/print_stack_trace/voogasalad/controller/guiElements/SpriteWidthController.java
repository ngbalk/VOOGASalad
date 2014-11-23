package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

import javax.swing.JOptionPane;

public class SpriteWidthController extends SpriteCharacteristicController{
	public SpriteWidthController(GameObject sprite){
		super(sprite);
	}
	@Override
	public void setCharacteristic(String newValue){
		double newWidth = mySprite.getCharacteristics().getWidth();
		try{
			newWidth = Double.parseDouble(newValue);
		}
		catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Not a valid Width");
		}
		mySprite.getImage().setFitWidth(newWidth);
		mySprite.getCharacteristics().setWidth(newWidth);
	}
	@Override
	protected void populateDefaultText() {
		myTextBox.setText(Double.toString(mySprite.getCharacteristics().getWidth()));
	}

}
