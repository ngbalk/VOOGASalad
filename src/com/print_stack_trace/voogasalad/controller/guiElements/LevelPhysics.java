package com.print_stack_trace.voogasalad.controller.guiElements;

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
		ProgramPhysicEngine type=null;
		for (ProgramPhysicEngine physics: ProgramPhysicEngine.values()){
			if (physics.name().equals(dataValue));
				this.setCurrent(data.get(dataValue));
				type=physics;
				mySprite.getDelegate().setPhysics(type);
				break;
		}	
	}
	
}
