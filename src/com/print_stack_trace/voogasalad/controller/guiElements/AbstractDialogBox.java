package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public abstract class AbstractDialogBox {

	protected Button submitButton = new Button("Submit");
	protected Node myNode;
	
	public AbstractDialogBox(Node node){
		Stage stage = new Stage();
		stage.setWidth(250);
		stage.setHeight(250);
		stage.initStyle(StageStyle.UTILITY);
		Group root = new Group();  
		Scene s = new Scene(root);
		HBox box = new HBox();
		myNode = node; 
		box.getChildren().addAll(myNode, submitButton);
		root.getChildren().add(box);
		submitButton.setOnAction(e->submit());
		stage.setScene(s);
		stage.show();
	}

	public abstract String submit();
	
	
}
