package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.scene.Node;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;

public class ScrollBarPane extends ScrollPane{
	public ScrollBarPane(Number width, Number height, Node data){
		this.setContent(data);
		setUpScrollBars(width.intValue(), height.intValue(), data);
		
		setHbarPolicy(ScrollBarPolicy.ALWAYS);
		setVbarPolicy(ScrollBarPolicy.ALWAYS);
		this.setWidth(((Region) data).getPrefWidth()/2);
		this.setHeight(((Region) data).getPrefHeight()/2);
		this.setVisible(false);
	}

	private void setUpScrollBars(int width, int height, Node data){
		ScrollingBarPair scrollBars=new ScrollingBarPair(width-15,height-50, data);
		this.getChildren().addAll(scrollBars);
	}
}
