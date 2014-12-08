package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

import javax.swing.JOptionPane;

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
		System.out.println(newWidth);
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
