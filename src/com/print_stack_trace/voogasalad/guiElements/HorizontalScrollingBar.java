package com.print_stack_trace.voogasalad.guiElements;

import javafx.geometry.Orientation;

public class HorizontalScrollingBar extends BalancedScrollingBar{
	private int myWidth;
	public HorizontalScrollingBar(int width){
		super();
		myWidth=width;
		this.setPrefSize(width,DEFAULT_SIZE);
	}
	public void changeSize(int size){
		this.setPrefSize(myWidth, size);
	}
}
