package com.print_stack_trace.voogasalad.guiElements;

import java.util.HashSet;

import javafx.scene.control.ScrollBar;

public class ScrollingBarPair extends HashSet<ScrollBar> {
	public ScrollingBarPair(int width, int height){
		VerticalScrollingBar vertical=new VerticalScrollingBar(height);
		HorizontalScrollingBar horizontal=new HorizontalScrollingBar(width);
		vertical.relocate(width-vertical.getSize(), 5);
		horizontal.relocate(5, height-horizontal.getSize());
		add(vertical);
		add(horizontal);
	}
}
