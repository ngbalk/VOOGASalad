package com.print_stack_trace.voogasalad.controller.guiElements;

import javax.swing.JOptionPane;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class SpriteYController extends SpriteCharacteristicController{
	public SpriteYController(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
	}
	@Override
	public void setCharacteristic(String newValue){
	
		double newYValue = mySprite.getImage().getLayoutY();
		try{
			newYValue = Double.parseDouble(newValue);
		}
		catch(NumberFormatException e){
			
		}
		((SpriteObject)mySprite).setMyY(newYValue);
	}
	@Override
	protected void populateDefaultText() {
		this.setObservable(((SpriteObject) mySprite).getObservableY());
		
	}

}
