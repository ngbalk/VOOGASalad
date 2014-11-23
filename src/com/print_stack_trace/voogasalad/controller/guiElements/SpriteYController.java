package com.print_stack_trace.voogasalad.controller.guiElements;

import javax.swing.JOptionPane;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class SpriteYController extends UserInputText{
	private GameObject mySprite;
	private TextField myTextBox;
	public SpriteYController (GameObject sprite){
		myTextBox = (TextField) myNode;
		mySprite = sprite;
		myTextBox.setText(Double.toString(sprite.getImage().getLayoutY()));
		myTextBox.textProperty().addListener(new ChangeListener<String>(){
			@Override
			public void changed(ObservableValue<? extends String> arg0,
					String oldVal, String newVal) {
					setCharacteristic(newVal);
			}
			
		});
	}
	public void setCharacteristic(String newValue){
		double newYValue = mySprite.getImage().getLayoutY();
		try{
			newYValue = Double.parseDouble(newValue);
		}
		catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Not a valid X location");
		}
		mySprite.getImage().setLayoutY(newYValue);
		((SpriteObject)mySprite).getCharacteristics().setY(newYValue);
		mySprite.getDelegate().update((SpriteObject) mySprite);
	}

}
