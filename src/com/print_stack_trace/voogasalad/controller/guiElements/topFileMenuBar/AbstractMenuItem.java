package com.print_stack_trace.voogasalad.controller.guiElements.topFileMenuBar;

import com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor.AbstractViewDelegate;
import com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor.ViewObjectDelegate;

import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;

public abstract class AbstractMenuItem extends MenuItem {
	protected AbstractViewDelegate myDelegate;
	protected ViewObjectDelegate myGame;
	public AbstractMenuItem(String name){
		this(name, null, null);
		this.setOnAction(e->doAction());
	}
	
	public AbstractMenuItem(String name, AbstractViewDelegate delegate,
			ViewObjectDelegate game) {
		setText(name);
		setOnAction(event->doAction());
		myDelegate=delegate;
		myGame=game;
	}
	public abstract void doAction();
	
}
