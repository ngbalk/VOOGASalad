package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.level;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.resourceReader.ResourceReader;
import com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.UserInputDropDownMenu;
import com.print_stack_trace.voogasalad.model.engine.physics.SoloPhysicsGenerator.ProgramPhysicEngine;


public class LevelPhysics extends UserInputDropDownMenu {
	public LevelPhysics(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
		currentMenu.setText("Pick Types of Physics");
		myResourceReader=new ResourceReader("./com/print_stack_trace/voogasalad/"
				+ "controller/guiResources/PhysicsTypes.Properties");
		data=myResourceReader.getProperties();
		addMenus();
	}

	@Override
	protected void linkMovement(String dataValue) {
		for (ProgramPhysicEngine physics: ProgramPhysicEngine.values()){
			if (physics.name().equals(dataValue));
				setCurrent(data.get(dataValue));
				mySprite.getDelegate().setPhysics(physics);
				break;
		}	
	}
}
