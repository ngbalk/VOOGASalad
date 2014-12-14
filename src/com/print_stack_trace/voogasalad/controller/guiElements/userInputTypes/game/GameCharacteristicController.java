package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.game;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.UserInputText;

public abstract class GameCharacteristicController extends UserInputText{
	protected TextField myTextBox;
	public GameCharacteristicController(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
		mySprite = (GameObject) object;
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
}

