package com.print_stack_trace.voogasalad.controller.popUpPanes;

import java.util.List;


import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class MessagePopUp extends Stage{
	private Pane myMessagePane;
	protected double width=400;
	protected double height=200;
	private String dropDownString="";
	private static String DEFAULT_STYLE="./com/print_stack_trace/voogasalad/controller/guiResources/SpritePane.css";
	public MessagePopUp(String style){
		myMessagePane=new Pane();
		myMessagePane.setStyle("-fx-background-color: BLACK");
		myMessagePane.setPrefSize(width, height);
		setWidth(width);
		setHeight(height);
		Scene myScene=new Scene(myMessagePane, width, height);
		setScene(myScene);
		makeMessage("");
		myMessagePane.getStylesheets().add(style);
	}
	public MessagePopUp() {
		this(DEFAULT_STYLE);
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

	public String showInputDialog(String message){
		TextField myTextField=new TextField();
		myTextField.relocate(0, height/2);
		myTextField.setPrefSize(width/1.3, height/5);
		myTextField.setOnKeyPressed(new EventHandler<KeyEvent>(){
			public void handle(KeyEvent e){
				if (e.getCode().equals(KeyCode.ENTER)){
					close();
				}
			}
		});

		add(myTextField);
		makeMessage(message);
		showStage();
		return myTextField.getText();
	}

	public String showDropDownDialog(String message, String[] options){
		MenuBar bar=new MenuBar();
		bar.relocate(0, height/2);
		bar.setPrefSize(width/1.3, height/5);
		Menu menuName=new Menu("Please Pick One");
		for (int i=0; i<options.length; i++){
			MenuItem item=new MenuItem(options[i]);
			item.setOnAction(e->{
				dropDownString=item.getText();
				close();
			});
			menuName.getItems().add(item);
		}
		bar.getMenus().add(menuName);
		add(bar);
		makeMessage(message);
		showStage();
		return dropDownString;
	}

}
