package com.print_stack_trace.voogasalad.controller.guiElements;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public abstract class AbstractDialogBox {

	protected Button submitButton = new Button("Submit");
	protected List<TextField> tfList;
	
	public AbstractDialogBox(List<TextField> nodeList) {
		this.tfList = nodeList;
		Stage stage = new Stage();
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
	
	public AbstractDialogBox(TextField node){
		this(constructorConverter(node));
	}
	
	private static List<TextField> constructorConverter(TextField node) {
		List<TextField> nodeList = new ArrayList<TextField>();
		nodeList.add(node);
		return nodeList;
	}
	
	public void close() {
		//TODO: close the stage
	}

	public abstract String submit();
	public abstract List<String> submitAll();
	
}
