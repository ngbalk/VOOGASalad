package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;

public abstract class AbstractMenuItem extends MenuItem {
	protected AbstractViewDelegate myDelegate;
	public AbstractMenuItem(String name){
		this(name, null);
	}
	public AbstractMenuItem(String name, AbstractViewDelegate delegate){
		setText(name);
		setOnAction(event->doAction());
		myDelegate=delegate;
		
	}
	public abstract void doAction();
	
}
