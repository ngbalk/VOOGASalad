package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DecisionTableButton extends Button {
	public static final String text = "Edit Collision Table";
	//private ScrollBar scroller = new ScrollBar(); 
	
	public DecisionTableButton(DecisionTable table){
		this.setText(text);
		this.setOnAction(event->showTable(table));
	}

	private void showTable(DecisionTable dt) {
		Stage stage = new Stage();
		stage.setWidth(600);
		stage.setHeight(600); 
		stage.setResizable(false);
		stage.initStyle(StageStyle.UTILITY);
		Group root = new Group(); 
		ScrollPane sp = new ScrollPane();
		sp.setContent(dt);
		sp.setPannable(true);
		sp.setMaxHeight(10000);
		sp.setMaxWidth(10000); 
		sp.setPrefSize(580, 570); 
		sp.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		sp.setHbarPolicy(ScrollBarPolicy.ALWAYS);
		Scene s = new Scene(root);
		root.getChildren().addAll(sp);
		stage.setScene(s); 
		stage.show();
		return;
	}
}
