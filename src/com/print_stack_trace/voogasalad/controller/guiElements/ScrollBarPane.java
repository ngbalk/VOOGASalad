package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.scene.Node;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.Pane;

public class ScrollBarPane extends Pane{
	private Node myData;
	public ScrollBarPane(Number width, Number height, Node data){
		myData=data;
		this.getChildren().add(data);
		setUpScrollBars(width.intValue(), height.intValue());
	}

	private void setUpScrollBars(int width, int height){
		ScrollingBarPair scrollBars=new ScrollingBarPair(width-15,height-50);
		this.getChildren().addAll(scrollBars);
	}
}
