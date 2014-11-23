package com.print_stack_trace.voogasalad.controller.guiElements;



import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class InputMessage extends LabelMessage{
	private TextField myTextField;
	private boolean isEntered=false;
	public InputMessage() {
		super();
		myTextField=new TextField();
		myTextField.relocate(0, height/2);
		myTextField.setPrefSize(width/1.3, height/5);
		myTextField.setOnKeyPressed(new EventHandler<KeyEvent>(){
			public void handle(KeyEvent e){
				if (e.getCode().equals(KeyCode.ENTER)){
					getTextFieldText();
					close();
				}
			}
		});
		add(myTextField);
	}

	public String showInputDialog(String message){
		makeMessage(message);
		showStage();
		return myTextField.getText();
	}
	public boolean getEntered(){
		return isEntered;
	}
	public void getTextFieldText(){
		isEntered=true;
	}
	

}
