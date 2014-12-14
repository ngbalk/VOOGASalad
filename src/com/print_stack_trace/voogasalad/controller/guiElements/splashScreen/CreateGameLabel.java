package com.print_stack_trace.voogasalad.controller.guiElements.splashScreen;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Label;

public class CreateGameLabel extends LabelSplashObject{

	
	public CreateGameLabel(String source, double width, double height,
			Group group) {
		super(source, width, height, group);
		
	}

	@Override
	public boolean update() {
		int speed=1;
		if(myLabel.getLayoutX()<=400){
			myLabel.setLayoutX(myLabel.getLayoutX()+speed);
			return true;
		}
		return false;
		
	}

	@Override
	public void addEnd(EventHandler event) {
		// TODO Auto-generated method stub
		
	}

}
