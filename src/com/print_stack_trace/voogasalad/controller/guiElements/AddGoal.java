package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.scene.control.Button;

public class AddGoal extends UserInputType{
	public AddGoal(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
		myNode=new Button();
		((Button) myNode).setText("Add");
		((Button) myNode).setOnAction(event->doAction());
		this.makeInitialNode();
	}
	public void doAction(){
		if (((GoalObject) mySprite).getCharacteristics()!=null){
			mySprite.getDelegate().update((GoalObject) mySprite);
		}	
	}
}
