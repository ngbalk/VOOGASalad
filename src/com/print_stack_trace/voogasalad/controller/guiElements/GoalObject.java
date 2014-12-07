package com.print_stack_trace.voogasalad.controller.guiElements;

import com.print_stack_trace.voogasalad.model.GoalCharacteristics;
import com.print_stack_trace.voogasalad.model.environment.GoalFactory.GoalType;

import javafx.scene.image.ImageView;

public class GoalObject extends GameObject {

	private GoalCharacteristics myCharacteristics;
	public GoalObject(ImageView image, String imagePath, ViewObjectDelegate delegate) {
		super(image, imagePath, delegate);
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
	public void setCharacteristics(GoalCharacteristics goalCharacteristics){
		myCharacteristics=goalCharacteristics;
	}
	@Override
	protected void update() {
		myDelegate.update(this);
	}
	@Override
	public void createPane() {
		// TODO Auto-generated method stub
	}
	@Override
	public void showPane() {
		// TODO Auto-generated method stub
	}
	@Override
	public ImageView getImage() {
		return this.myImage;
	}
	
}
