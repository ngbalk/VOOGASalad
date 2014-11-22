package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DecisionTableButton extends Button {
	public static final String text = "Edit Collision Table";
	private DecisionTable myTable;
	
	public DecisionTableButton(DecisionTable table){
		this.setText(text);
		this.setOnAction(event->showTable());
		myTable = table;
	}

	private void showTable() {
		Stage stage = new Stage();
		stage.setWidth(500);
		stage.setHeight(500);
		stage.initStyle(StageStyle.UTILITY);
		Group root = new Group();  
		Scene s = new Scene(root);
		root.getChildren().add(myTable);  
		stage.setScene(s);
		stage.show();
		return;
	}
}
