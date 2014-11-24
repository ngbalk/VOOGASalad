package com.print_stack_trace.voogasalad.controller.guiElements;

import java.util.List;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class LabelMessage extends Stage{
	private Pane myMessagePane;
	protected double width=400;
	protected double height=200;
	public LabelMessage(){
		myMessagePane=new Pane();
		myMessagePane.setStyle("-fx-background-color: BLACK");
		myMessagePane.setPrefSize(width, height);
		setWidth(width);
		setHeight(height);
		Scene myScene=new Scene(myMessagePane, width, height);
		setScene(myScene);
		makeMessage("");
	}
	protected void add(Node toAdd){
		myMessagePane.getChildren().add(toAdd);
	}
	protected void makeMessage(String message){
		Label myLabel=new Label();
		myLabel.setText(message);
		myLabel.setWrapText(true);
		myLabel.setPrefSize(width, height/2);
		myLabel.setTextFill(Paint.valueOf("WHITE"));
		myMessagePane.getChildren().add(myLabel);
	}
	
	public void showMessageDialog(String message){
		makeMessage(message);
		showStage();
	}
	protected void showStage(){
		showAndWait();
	}
	

}
