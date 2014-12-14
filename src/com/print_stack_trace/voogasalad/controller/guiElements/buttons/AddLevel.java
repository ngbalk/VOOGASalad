package com.print_stack_trace.voogasalad.controller.guiElements.buttons;

import com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor.ViewObjectDelegate;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.LevelObject;

public class AddLevel extends AbstractButton{

	public AddLevel(String text, ViewObjectDelegate viewObjectDelegate) {
		super(text, viewObjectDelegate);
	}

	@Override
	protected void behavior() {
		myViewObjectDelegate.addNewLevel(new LevelObject("", (ViewObjectDelegate) myViewObjectDelegate));
	}
	
}
