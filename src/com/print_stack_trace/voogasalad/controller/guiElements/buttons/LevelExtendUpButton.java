package com.print_stack_trace.voogasalad.controller.guiElements.buttons;

import com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor.ViewObjectDelegate;

public class LevelExtendUpButton extends AbstractButton {

	public LevelExtendUpButton(String text, ViewObjectDelegate viewObjectDelegate) {
		super(text,viewObjectDelegate);
	}

	@Override
	protected void behavior() {
		this.myViewObjectDelegate.extendUp();

	}

}
