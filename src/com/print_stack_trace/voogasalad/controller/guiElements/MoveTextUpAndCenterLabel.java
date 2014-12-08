package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.event.EventHandler;
import javafx.scene.Group;

public class MoveTextUpAndCenterLabel extends LabelSplashObject{


	public MoveTextUpAndCenterLabel(String source, double width, double height,
			Group group) {
		super(source, width, height, group);
		myLabel.setPrefSize(500, 100);
		myLabel.relocate(width/2-myLabel.getPrefWidth(), height);
	}

	@Override
	public boolean update() {

		if (myLabel.getLayoutX()!=(myHeight-myHeight/2-myHeight/2)){
			myLabel.setLayoutX(myLabel.getLayoutX()-30);
			return true;
		}
		return false;
	}

	@Override
	public void addEnd(EventHandler event) {
		// TODO Auto-generated method stub

	}
}
