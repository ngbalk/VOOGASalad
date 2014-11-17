package com.print_stack_trace.voogasalad.controller.guiElements;

public class GoalsLibrary extends AbstractLibraryPane{
	public GoalsLibrary(Number width, Number height, String resources) {
		super(width, height, resources);
		myResources="./com/print_stack_trace/voogasalad/controller/guiResources/TypesOfGoals.Properties";
		loadAndAddData();
	}

	@Override
	protected void loadAndAddData() {
		// TODO Auto-generated method stub
		
	}
}
