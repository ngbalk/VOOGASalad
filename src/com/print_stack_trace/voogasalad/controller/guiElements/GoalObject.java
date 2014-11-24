package com.print_stack_trace.voogasalad.controller.guiElements;

import com.print_stack_trace.voogasalad.model.GoalCharacteristics;
import com.print_stack_trace.voogasalad.model.environment.GoalFactory.GoalType;

import javafx.scene.image.ImageView;

public class GoalObject extends GameObject {
	private GoalCharacteristics myCharacteristics;
	public GoalObject(ImageView image, ViewObjectDelegate delegate) {
		super(image, delegate);
	}
	public GoalObject(GoalType myType, ViewObjectDelegate delegate){
		super(myType);
		myDelegate=delegate;
		myCharacteristics=new GoalCharacteristics(myType);
	}
	public GoalCharacteristics getCharacteristics(){
		return myCharacteristics;
	}
	public void setCharacteristics(GoalType myType){
		myCharacteristics=new GoalCharacteristics(myType);
	}
}