package com.print_stack_trace.voogasalad.controller.guiElements.gameObjects;

import com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor.ViewObjectDelegate;
import com.print_stack_trace.voogasalad.model.GoalCharacteristics;
import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.environment.GoalFactory.GoalType;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.image.ImageView;

public class GoalObject extends GameObject {
	private SimpleObjectProperty<GoalCharacteristics> myCharacteristics=new SimpleObjectProperty<GoalCharacteristics>();
	private SimpleIntegerProperty pointsProperty=new SimpleIntegerProperty(0);
	public GoalObject(String imagePath, ViewObjectDelegate delegate) {
		super(imagePath, delegate);
	}
	public GoalObject(GoalType myType, ViewObjectDelegate delegate){
		super(myType, delegate);
		myCharacteristics.setValue(new GoalCharacteristics(myType));
		pointsProperty.setValue(myCharacteristics.getValue().getPointsTotal());
	}
	public SimpleIntegerProperty getPointsProperty(){
		return pointsProperty;
	}
	public void setPointsTotal(Integer points){
		this.getCharacteristics().setPointsTotal(points);
		pointsProperty.setValue(points);
	}
	public GoalCharacteristics getCharacteristics(){
		return myCharacteristics.getValue();
	}
	public SimpleObjectProperty<GoalCharacteristics> characteristicsProperty(){
		return myCharacteristics;
	}
	public void setCharacteristics(GoalType myType){
		myCharacteristics.setValue(new GoalCharacteristics(myType));
	}
	public void setCharacteristics(GoalCharacteristics goalCharacteristics){
		myCharacteristics.setValue(goalCharacteristics);
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
	public void setImageCharacteristics() {
		// TODO Auto-generated method stub
		
	}


}
