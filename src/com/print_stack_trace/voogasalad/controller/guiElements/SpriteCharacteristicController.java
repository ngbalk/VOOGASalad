package com.print_stack_trace.voogasalad.controller.guiElements;


import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public abstract class SpriteCharacteristicController extends UserInputText {
	protected TextField myTextBox;
	public SpriteCharacteristicController(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
		myTextBox = (TextField) myNode;
		mySprite = object;
		populateDefaultText();
		myTextBox.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>(){
			public void handle(KeyEvent e){
				if (e.getCode()==KeyCode.ENTER){
					setCharacteristic(myTextBox.getText());
					System.out.println(myTextBox.getText());
				}
			}
		});
		
	}
	
	abstract protected void populateDefaultText();
	abstract protected void setCharacteristic(String newValue);
	protected void setObservable(SimpleDoubleProperty simpleDoubleProperty){
		simpleDoubleProperty.addListener(new ChangeListener<Number>(){
			@Override
			public void changed(ObservableValue<? extends Number> arg0,
					Number arg1,Number arg2) {
					myTextBox.setText(arg2.doubleValue()+"");
				
			}
			
		});
	}
}
