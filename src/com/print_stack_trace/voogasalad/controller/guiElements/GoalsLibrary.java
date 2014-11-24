package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class GoalsLibrary extends AbstractLibraryPane{
	public GoalsLibrary(Number width, Number height, Pane otherPane) {
		super(width, height, otherPane);
		myResources="./com/print_stack_trace/voogasalad/controller/guiResources/TypesOfGoals.Properties";
		loadAndAddData();
	}

	@Override
	protected void loadAndAddData() {
		PopUpPane myPopUpPane=new PopUpPane(this.getPrefWidth(), this.getPrefHeight(),"GoalPane",
				new GoalObject(new ImageView(), (ViewObjectDelegate) this.myMainPane));
		myPopUpPane.close();
		this.getChildren().add(myPopUpPane);
	}
}
