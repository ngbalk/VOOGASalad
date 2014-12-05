package com.print_stack_trace.voogasalad.controller.guiElements;

import java.util.List;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public abstract class AbstractDialogBox<T extends Node> {

	protected Button submitButton = new Button("Submit");
	protected List<T> nodeList;
	private Stage stage;
	
	public AbstractDialogBox(List<T> nodeList) {
		this.nodeList = nodeList;
		stage = new Stage();
		stage.setWidth(250);
		stage.setHeight(250);
		stage.initStyle(StageStyle.UTILITY);
		Group root = new Group();  
		Scene s = new Scene(root);
		HBox box = new HBox();
		VBox vbox = new VBox();
		vbox.getChildren().addAll(nodeList);
		box.getChildren().addAll(vbox, submitButton);
		root.getChildren().add(box);
		submitButton.setOnAction(e->submit());
		stage.setScene(s);
		stage.show();
	}
	
	public void close(){
		stage.close();
	}

	public abstract String submit();
	public abstract List<String> submitAll();
	
}
