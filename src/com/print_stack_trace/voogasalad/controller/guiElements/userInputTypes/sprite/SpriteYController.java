package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.sprite;

import javax.swing.JOptionPane;

import com.print_stack_trace.voogasalad.controller.guiElements.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.SpriteObject;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class SpriteYController extends SpriteCharacteristicController{
	public SpriteYController(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
	}
	@Override
	public void setCharacteristic(String newValue){
	
		double newYValue = ((SpriteObject)mySprite).getCharacteristics().getY();
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
