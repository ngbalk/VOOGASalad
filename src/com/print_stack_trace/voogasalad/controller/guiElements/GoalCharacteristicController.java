package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public abstract class GoalCharacteristicController extends UserInputText{
	protected TextField myTextBox;
	public GoalCharacteristicController(GameObject goal){
		mySprite = goal;
		myTextBox = (TextField) myNode;
		populateDefaultText();
		myTextBox.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent e) {
				if (e.getCode()==KeyCode.ENTER){
					setCharacteristic(myTextBox.getText());
				}
			}
		});
	}
	abstract protected void populateDefaultText();
	abstract protected void setCharacteristic(String newValue);
	protected boolean isNull(){
		if (((GoalObject) mySprite).getCharacteristics()==null){
			return true;
		}
		else
			return false;
	}
}
