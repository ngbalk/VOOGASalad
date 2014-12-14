package com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.DraggableItem.DoubleChangeListener;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Region;

public class ScrollBarPane extends ScrollPane{
	private Region myNode;
	public ScrollBarPane(double width, double height, Node data){
		this.setContent(data);
		myNode=(Region) data;
		this.setPrefHeight(((Region) data).getPrefHeight());
		this.setPrefWidth(((Region)data).getPrefWidth());
		setHbarPolicy(ScrollBarPolicy.ALWAYS);
		setVbarPolicy(ScrollBarPolicy.ALWAYS);
		sizeWidth(width);
		sizeHeight(height);
		sizeListener();
	}
	
	private void sizeHeight(double width){
		this.setVmin(0);
		this.setVmax(width);
	}
	
	private void sizeWidth(double height){
		this.setHmin(0);
		this.setHmax(height);
		
	}
	
	private void sizeListener(){
		addDoubleListener(myNode.prefHeightProperty(), (toChange)->sizeHeight(toChange));
		addDoubleListener(myNode.prefWidthProperty(), (toChange)->sizeWidth(toChange));
	}
	
	public void addDoubleListener(ReadOnlyDoubleProperty prop, DoubleChangeListener listener){
		prop.addListener(new ChangeListener<Number>(){
			public void changed(ObservableValue<? extends Number> arg0,
					Number arg1, Number arg2) {
				listener.change(arg2.doubleValue());
			}
		});
	}
}