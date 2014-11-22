package com.print_stack_trace.voogasalad.controller.guiElements;

import javax.swing.JOptionPane;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class SpriteXController extends UserInputText{
	private TextField myTextBox;
	public SpriteXController (GameObject sprite){
		myTextBox = (TextField) myNode;
		mySprite = sprite;
		myTextBox.setText(Double.toString(sprite.getImage().getLayoutX()));
		myTextBox.textProperty().addListener(new ChangeListener<String>(){
			@Override
			public void changed(ObservableValue<? extends String> arg0,
					String oldVal, String newVal) {
					setCharacteristic(newVal);
			}
			
		});
	}
	//Maybe we can have one button that calls this method, and have a similar method on all of these 
	//GUI elements, maybe they should implement the same interface so we can do this with a loop?
	
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
		mySprite.getCharacteristics().setY(newXValue);
	}

}
