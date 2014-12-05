package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.scene.control.Button;

public class AddGoal extends UserInputType{
	public AddGoal(GameObject object){
		super(object);
		myNode=new Button();
		((Button) myNode).setText("Add");
		((Button) myNode).setOnAction(event->doAction());
	}
	public void doAction(){
		
		if (((GoalObject) mySprite).getCharacteristics()!=null){
			mySprite.getDelegate().update((GoalObject) mySprite);
		}	
	
	}
}
