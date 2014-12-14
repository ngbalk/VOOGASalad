package com.print_stack_trace.voogasalad.controller.guiElements.splashScreen;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Label;

public class Print_Stack_Trace_Label extends LabelSplashObject{
	public Print_Stack_Trace_Label(String source, double width, double height,
			Group group) {
		super(source, width, height, group);
		myLabel.relocate(width, height-100);
		myLabel.setLayoutX(width);
	}

	@Override
	public boolean update() {
		int speed=1;
		if(myLabel.getLayoutX()>=200){
			myLabel.setLayoutX(myLabel.getLayoutX()-speed*2);
			return true;
		}
		return false;	
	}

	@Override
	public void addEnd(EventHandler event) {}
}
