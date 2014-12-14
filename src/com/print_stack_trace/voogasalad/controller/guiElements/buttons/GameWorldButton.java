package com.print_stack_trace.voogasalad.controller.guiElements.buttons;

import com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor.ViewObjectDelegate;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameWorldObject;
import com.print_stack_trace.voogasalad.controller.popUpPanes.PopUpPane;


public class GameWorldButton extends AbstractButton{

	public GameWorldButton(String text, ViewObjectDelegate viewObjectDelegate) {
		super(text, viewObjectDelegate);
		
	}

	@Override
	protected void behavior() {
		PopUpPane myPane=new PopUpPane("GAMEWORLD", new GameWorldObject("", myViewObjectDelegate));
		myPane.openPane();
	}

}
