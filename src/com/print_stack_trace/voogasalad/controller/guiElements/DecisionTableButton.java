package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DecisionTableButton extends Button {
	public static final String text = "Edit Collision Table";
	private ScrollBar scroller = new ScrollBar(); 
	
	public DecisionTableButton(DecisionTable table){
		this.setText(text);
		this.setOnAction(event->showTable(table));
	}

	private void showTable(DecisionTable dt) {
		Stage stage = new Stage();
		stage.setWidth(500);
		stage.setHeight(500); 
		stage.initStyle(StageStyle.UTILITY);
		Group root = new Group();  
		Scene s = new Scene(root);
		root.getChildren().addAll(dt, scroller);
		scroller.setLayoutX(s.getWidth()-scroller.getWidth());
        scroller.setMin(0);
        scroller.setOrientation(Orientation.VERTICAL);  
        scroller.setPrefHeight(180);
        scroller.setMax(360);
		stage.setScene(s);
		stage.show();
		return;
	}
}
