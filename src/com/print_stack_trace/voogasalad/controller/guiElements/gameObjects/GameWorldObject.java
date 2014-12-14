package com.print_stack_trace.voogasalad.controller.guiElements.gameObjects;

import com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor.ViewObjectDelegate;
import com.print_stack_trace.voogasalad.model.GameWorldCharacteristics;
import com.print_stack_trace.voogasalad.model.environment.GoalFactory.GoalType;

public class GameWorldObject extends GameObject{
	private GameWorldCharacteristics myCharacteristics;
	public GameWorldObject(String imagePath, ViewObjectDelegate delegate) {
		super(imagePath, delegate);
	}
	@Override
	public void setImageCharacteristics() {
	}

	@Override
	protected void update() {
		// TODO Auto-generated method stub
	}

	@Override
	public void createPane() {
	}
	
	public GameWorldCharacteristics getCharacteristics(){
		return myCharacteristics;
	}
}
