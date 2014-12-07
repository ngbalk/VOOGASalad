package com.print_stack_trace.voogasalad.controller.guiElements;

import com.print_stack_trace.voogasalad.model.engine.GameEngine;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class GameAuthorBottomLayoutNode extends AbstractLayoutNode{

	//private DecisionTableButton tableButton;// = new DecisionTableButton(new DecisionTable());
	
	public GameAuthorBottomLayoutNode(double width, double height, Node toBeLinked, Object engine, AbstractViewDelegate delegate) {
		super(width, height, toBeLinked, engine, delegate);
		DecisionTable decisiontable=new DecisionTable((GameEngine) engine);
		DecisionTableButton tableButton= new DecisionTableButton(decisiontable);
		tableButton.getStyleClass().add("buttonTemplate2");
		tableButton.relocate(width*.45, 20);
		tableButton.setPrefSize(200, 50);
		((Pane) myNode).getChildren().add(tableButton);
	}

	@Override
	public void initialize(double width, double height) {
		
	}

	@Override
	public void initialize(double width, double height, Node myLinkedObject, Object engine, AbstractViewDelegate delegate) {
		Pane bottomPane=new Pane();
		bottomPane.setPrefSize(width,height*.2);
		LevelBar myLevelBar=new LevelBar(width*.025, 20, width*.2, height*.05);
		
		//LEVEL BUTTON
		LevelButton myLevelButton=new LevelButton();
		((GamePane)myLinkedObject).addLevelBar(myLevelBar);
		myLevelButton.setOnMouseClicked(e->(((GamePane)myLinkedObject).addLevelUpdate(new LevelObject(new ImageView(), null))));
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
		Button loadLevelButton=new Button("Load Level");
		loadLevelButton.relocate(width*.40, 20);
		loadLevelButton.setPrefSize(100,50);
		loadLevelButton.getStyleClass().add("buttonTemplate2");
		loadLevelButton.setOnMouseClicked(e->((GamePane) myLinkedObject).loadLevel());
		myNode=bottomPane;

		//LOAD GAME WORLD BUTTON
		//TODO: Abstract this to load gameworld data button

		
		//ADD ALL BUTTONS TO BOTTOM PANE
		bottomPane.getChildren().addAll(myLevelBar, myLevelButton, loadLevelButton, saveButton);
		
		
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
