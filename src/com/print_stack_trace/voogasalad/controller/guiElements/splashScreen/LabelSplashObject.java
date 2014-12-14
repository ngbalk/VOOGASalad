package com.print_stack_trace.voogasalad.controller.guiElements.splashScreen;

import javafx.scene.Group;
import javafx.scene.control.Label;

public abstract class LabelSplashObject extends SplashScreenObject {
	protected Label myLabel;
	public LabelSplashObject(String source, double width, double height, Group group) {
		super(source, width, height, group);
		myLabel=new Label(source);
		myNode=myLabel;
		myLabel.getStylesheets().add(myStyle);
	}

}
