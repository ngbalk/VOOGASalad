package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.scene.control.Button;

public abstract class LevelSpaceExtenderButton extends Button{
	protected ViewObjectDelegate myViewObjectDelegate;
	public LevelSpaceExtenderButton(ViewObjectDelegate viewObjectDelegate) {
		myViewObjectDelegate = viewObjectDelegate;
		this.setOnAction(e->behavior());
		this.setDefaultText();
	}
	protected abstract void setDefaultText();
	protected abstract void behavior();

}
