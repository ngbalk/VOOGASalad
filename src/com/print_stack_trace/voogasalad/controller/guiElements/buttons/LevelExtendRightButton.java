package com.print_stack_trace.voogasalad.controller.guiElements.buttons;

import com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor.ViewObjectDelegate;

public class LevelExtendRightButton extends AbstractButton {

	public LevelExtendRightButton(String text, ViewObjectDelegate viewObjectDelegate) {
		super(text,viewObjectDelegate);
	}
	@Override
	protected void behavior() {
		myViewObjectDelegate.extendRight();
	}
	

}
