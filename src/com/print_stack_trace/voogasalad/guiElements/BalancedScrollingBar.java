package com.print_stack_trace.voogasalad.guiElements;

import javafx.scene.control.ScrollBar;

public class BalancedScrollingBar extends ScrollBar {
	protected int DEFAULT_SIZE=10;
	protected int mySize=0;
	public BalancedScrollingBar(){
		setUp();
	}
	private void setUp(){
		this.setMin(0);
		this.setMax(100);
		this.setValue(50);
	}
	public int getSize(){
		int size=(mySize==0)? DEFAULT_SIZE: mySize;
		return size;
	}
}
