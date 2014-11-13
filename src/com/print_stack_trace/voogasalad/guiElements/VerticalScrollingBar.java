package com.print_stack_trace.voogasalad.guiElements;

import javafx.geometry.Orientation;

public class VerticalScrollingBar extends BalancedScrollingBar{
	private int myHeight;
	public VerticalScrollingBar(int height){
		super();
		myHeight=height;
		this.setOrientation(Orientation.VERTICAL);
		this.setPrefSize(DEFAULT_SIZE, height);
	}
	
	public void changeSize(int size){
		this.setPrefSize(myHeight, size);
		mySize=size;
	}
	
	
}
