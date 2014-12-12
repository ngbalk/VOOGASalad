package com.print_stack_trace.voogasalad.controller.guiElements;

import java.io.File;

import com.print_stack_trace.voogasalad.model.engine.GameEngine;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class GameAuthorBottomLayoutNode extends AbstractLayoutNode{

	//private DecisionTableButton tableButton;// = new DecisionTableButton(new DecisionTable());
	public GameAuthorBottomLayoutNode(double width, double height, Node toBeLinked, Object engine, AbstractViewDelegate delegate) {
		super(width, height, toBeLinked, engine, delegate);
		DecisionTable decisiontable=new DecisionTable((GameEngine) engine);
		DecisionTableButton tableButton= new DecisionTableButton(decisiontable);
		tableButton.getStyleClass().add("buttonTemplate2");
		tableButton.relocate(width*.80, 20);
		tableButton.setPrefSize(200, 50);
		((Pane) myNode).getChildren().add(tableButton);
		//DeleteButton deleteButton = new DeleteButton(null, null);
	}

	@Override
	public void initialize(double width, double height) {
		
	}

	@Override
	public void initialize(double width, double height, Node myLinkedObject, Object engine, AbstractViewDelegate delegate) {
		Pane bottomPane=new Pane();
		bottomPane.setPrefSize(width,height*.2);
		LevelBar myLevelBar=new LevelBar(width*.025, 20, width*.2, height*.05, ((GamePane) myLinkedObject).currentLevelProperty(), 
				((GamePane) myLinkedObject).addLevelProperty(), ((GamePane) myLinkedObject).eventLevelProperty());
		
		//LEVEL BUTTON
		LevelButton myLevelButton=new LevelButton();

		myLevelButton.setOnMouseClicked(e->(((GamePane)myLinkedObject).addLevelUpdate(new LevelObject("", (ViewObjectDelegate) myLinkedObject))));

		myLevelButton.relocate(width*.25, 20);
		myLevelButton.setPrefSize(100, 50); 
		myLevelButton.getStyleClass().add("buttonTemplate2"+ "");
		
		//SAVE BUTTON
		Button saveButton=new Button("Save");
		saveButton.relocate(width*.35, 20);
		saveButton.setPrefSize(100,50);
		saveButton.getStyleClass().add("buttonTemplate2");
		saveButton.setOnMouseClicked(e->((GamePane) myLinkedObject).saveGame());
		myNode=bottomPane;
		
		//LOAD LEVEL DATA BUTTON
		/*
		Button loadLevelButton=new Button("Load Level");
		loadLevelButton.relocate(width*.40, 20);
		loadLevelButton.setPrefSize(100,50);
		loadLevelButton.getStyleClass().add("buttonTemplate2");
		loadLevelButton.setOnMouseClicked(e->((GamePane) myLinkedObject).loadLevel());
		myNode=bottomPane;
		*/

		//LOAD GAME WORLD BUTTON
		Button loadGameWorldButton=new Button("Load Game");
		loadGameWorldButton.relocate(width*.40, 20);
		loadGameWorldButton.setPrefSize(100,50);
		loadGameWorldButton.getStyleClass().add("buttonTemplate2");
		loadGameWorldButton.setOnMouseClicked(e->((GamePane) myLinkedObject).loadGame());
		myNode=bottomPane;
		
		//EXTEND BACKGROUND BUTTONS
		LevelSpaceExtenderButton levelExtendRightButton = new LevelExtendRightButton((ViewObjectDelegate) myLinkedObject);
		levelExtendRightButton.relocate(width*.45, 20);
		levelExtendRightButton.setPrefSize(100,50);
		levelExtendRightButton.getStyleClass().add("buttonTemplate2");
		
		LevelSpaceExtenderButton levelExtendUpButton = new LevelExtendDownButton((ViewObjectDelegate) myLinkedObject);
		levelExtendUpButton.relocate(width*.50, 20);
		levelExtendUpButton.setPrefSize(100,50);
		levelExtendUpButton.getStyleClass().add("buttonTemplate2");
		
		//ADD ALL BUTTONS TO BOTTOM PANE
		bottomPane.getChildren().add(new HBox(myLevelBar, myLevelButton, loadGameWorldButton, saveButton, levelExtendRightButton, levelExtendUpButton));
		
		
	}

	@Override
	public Number getHeight() {
		return ((Pane) myNode).getPrefHeight();
	}

	@Override
	public Number getWidth() {
		return ((Pane) myNode).getPrefWidth();
	}
	

}
