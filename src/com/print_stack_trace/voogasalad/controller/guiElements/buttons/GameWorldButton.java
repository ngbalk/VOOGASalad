package com.print_stack_trace.voogasalad.controller.guiElements.buttons;

import com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor.ViewObjectDelegate;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameWorldObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GoalObject;
import com.print_stack_trace.voogasalad.controller.popUpPanes.PopUpPane;


public class GameWorldButton extends AbstractButton{
	private PopUpPane myPane;
	public GameWorldButton(String text, ViewObjectDelegate viewObjectDelegate) {
		super(text, viewObjectDelegate);
		myPane=new PopUpPane("GameWorldPane",new GameWorldObject("", myViewObjectDelegate));
	}
	
	@Override
	protected void behavior() {if (!myPane.isOpen()) myPane.openPane();};

}
