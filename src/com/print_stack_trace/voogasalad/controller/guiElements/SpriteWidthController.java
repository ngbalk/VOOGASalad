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
		double newWidth = ((SpriteObject)mySprite).getCharacteristics().getWidth();
		try{
			newWidth = Double.parseDouble(newValue);
		}
		catch(NumberFormatException e){
			
		}
		mySprite.getImage().setFitWidth(newWidth);
		mySprite.getImage().setPreserveRatio(false);
		((SpriteObject)mySprite).getCharacteristics().setWidth(newWidth);
		mySprite.getDelegate().update((SpriteObject) mySprite);
	}
	@Override
	protected void populateDefaultText() {
		myTextBox.setText(Double.toString(((SpriteObject)mySprite).getCharacteristics().getWidth()));
	}

}
