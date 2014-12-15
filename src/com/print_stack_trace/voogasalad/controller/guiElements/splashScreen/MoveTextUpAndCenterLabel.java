package com.print_stack_trace.voogasalad.controller.guiElements.splashScreen;

import javafx.event.EventHandler;
import javafx.scene.Group;

public class MoveTextUpAndCenterLabel extends LabelSplashObject{
	public MoveTextUpAndCenterLabel(String source, double width, double height,
			Group group) {
		super(source, width, height, group);
		myLabel.relocate(width/2-myLabel.getPrefWidth()/2, height);
	}

	@Override
	public boolean update() {
		if (myLabel.getLayoutY()>=(myHeight-myHeight/2-myLabel.getPrefHeight()/2))
			myLabel.setLayoutY(myLabel.getLayoutY()-1);
		return (myLabel.getLayoutY()>=(myHeight-myHeight/2-myLabel.getPrefHeight()/2));
	}

	@Override
	public void addEnd(EventHandler event) {
		// TODO Auto-generated method stub

	}
}
