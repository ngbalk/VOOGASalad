package com.print_stack_trace.voogasalad.controller.guiElements;

import java.util.HashSet;

import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;

public class ScrollingBarPair extends HashSet<ScrollBar> {
	private Node myPane;
	public ScrollingBarPair(int width, int height, Node data){
		VerticalScrollingBar vertical=new VerticalScrollingBar(height);
		HorizontalScrollingBar horizontal=new HorizontalScrollingBar(width);
		vertical.relocate(width-vertical.getSize(), 5);
		horizontal.relocate(5, height-horizontal.getSize());
		myPane=data;
		change(horizontal);
		add(vertical);
		add(horizontal);
	}
	private void change(ScrollBar myBar){
		myBar.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov,
					Number old_val, Number new_val) {
				if (new_val.doubleValue()>0){
					((Region) myPane).setPrefWidth(((Region) myPane).getPrefWidth()+(new_val.doubleValue()-old_val.doubleValue()));
					Node background=((Pane) myPane).getChildren().get(0);
					background.relocate(((Region) myPane).getPrefWidth(), ((Region) myPane).getPrefHeight());
					((Pane) myPane).getChildren().add(0, background);
				}
			}
		});

	}
}
