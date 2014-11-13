package com.print_stack_trace.voogasalad.guiElements;

import com.print_stack_trace.voogasalad.gameElements.GameObject;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

public class DoubleClickItem {
	private int clicks;
	private Node myData;
	public DoubleClickItem(Node data){
		myData=data;
		clicks=0;
	}
	private void doAction(){
		myData.setOnMousePressed(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				clicks++;
				if (clicks>=2){
					
				}
			}
		});
	}
}
