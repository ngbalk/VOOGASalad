package com.print_stack_trace.voogasalad.controller.guiElements;




import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;

public class ScrollBarPane extends ScrollPane{
	public ScrollBarPane(Number width, Number height, Node data){
		this.setContent(data);
		this.setPrefHeight(height.doubleValue());
		this.setPrefWidth(width.doubleValue());
		setUpScrollBars(width.intValue(), height.intValue(), data);
		setHbarPolicy(ScrollBarPolicy.ALWAYS);
		setVbarPolicy(ScrollBarPolicy.ALWAYS);
	}

	private void setUpScrollBars(int width, int height, Node data){
		ScrollingBarPair scrollBars=new ScrollingBarPair(width-15,height-50, data);
		this.getChildren().addAll(scrollBars);
	}
	private void changeViewpoint(){
		this.viewportBoundsProperty().addListener(new ChangeListener < Bounds>(){
		

			@Override
			public void changed(ObservableValue<? extends Bounds> arg0,
					Bounds arg1, Bounds arg2) {
				
			}
			
		});
	}
}