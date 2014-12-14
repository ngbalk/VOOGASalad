package com.print_stack_trace.voogasalad.controller.guiElements.buttons;

import com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor.ViewObjectDelegate;

import javafx.scene.control.Button;

public abstract class AbstractButton extends Button{
	protected ViewObjectDelegate myViewObjectDelegate;
	public AbstractButton(String text,ViewObjectDelegate viewObjectDelegate) {
		myViewObjectDelegate = viewObjectDelegate;
		this.setOnAction(e->behavior());
		this.setText(text);
	}
	protected abstract void behavior();

}
