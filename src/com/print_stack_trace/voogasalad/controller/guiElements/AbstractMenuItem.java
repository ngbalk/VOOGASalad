package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;

public abstract class AbstractMenuItem extends MenuItem {
	
	public AbstractMenuItem(){
		setOnAction(event->doAction());
	}
	public abstract void doAction();
	
}
