package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.goal;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GoalObject;
import com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.UserInputType;

import javafx.scene.control.Button;

public class AddGoal extends UserInputType{
	public AddGoal(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
		myNode=new Button();
		((Button) myNode).setText("Add");
		((Button) myNode).setOnAction(event->doAction());
		makeInitialNode();
	}
	public void doAction(){
		if (((GoalObject) mySprite).getCharacteristics()!=null){
			mySprite.getDelegate().update((GoalObject) mySprite);
		}	
	}
}
