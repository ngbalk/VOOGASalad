package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DecisionTableButton extends Button {
	public static final String text = "Edit Collision Table";
	
	public DecisionTableButton(){
		this.setText(text);
		this.setOnAction(event->showTable());
	}

	private void showTable() {
		Stage stage = new Stage();
		stage.setWidth(500);
		stage.setHeight(500);
		stage.initStyle(StageStyle.UTILITY);
		Group root = new Group();  
		Scene s = new Scene(root);
		root.getChildren().add(new DecisionTable());
		stage.setScene(s);
		stage.show();
		return;
	}
}
