package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public abstract class GoalCharacteristicController extends UserInputText{
	protected TextField myTextBox;
	public GoalCharacteristicController(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
		mySprite = object;
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
	protected void setObservable(SimpleIntegerProperty simpleIntProperty){
		simpleIntProperty.addListener(new ChangeListener<Number>(){
			@Override
			public void changed(ObservableValue<? extends Number> arg0,
					Number arg1,Number arg2) {
					myTextBox.setText(arg2.doubleValue()+"");
				
			}
			
		});
	}
}
