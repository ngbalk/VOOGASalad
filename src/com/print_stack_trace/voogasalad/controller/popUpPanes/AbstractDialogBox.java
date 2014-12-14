package com.print_stack_trace.voogasalad.controller.popUpPanes;

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

	private Button submitButton = new Button("Submit");
	protected List<T> nodeList;
	private Stage myStage;
	
	public AbstractDialogBox(List<T> nodeList) {
		this.nodeList = nodeList;
		myStage = new Stage();
		myStage.setWidth(250);
		myStage.setHeight(250);
		myStage.initStyle(StageStyle.UTILITY);
		Group root = new Group();  
		Scene s = new Scene(root);
		HBox boxForFieldsAndSubmitButton = new HBox();
		VBox vboxForFieldsToBeFilledByUser = new VBox();
		vboxForFieldsToBeFilledByUser.getChildren().addAll(nodeList);
		boxForFieldsAndSubmitButton.getChildren().addAll(vboxForFieldsToBeFilledByUser, getSubmitButton());
		root.getChildren().add(boxForFieldsAndSubmitButton);
		getSubmitButton().setOnAction(e->submit());
		myStage.setScene(s);
		myStage.show();
	}
	
	public void close(){
		myStage.close();
	}

	public abstract String submit();
	public abstract List<String> submitAll();

	public Button getSubmitButton() {
		return submitButton;
	}

	public void setSubmitButton(Button submitButton) {
		this.submitButton = submitButton;
	}
	
}
