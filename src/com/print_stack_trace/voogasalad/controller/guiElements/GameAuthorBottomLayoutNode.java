package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class GameAuthorBottomLayoutNode extends AbstractLayoutNode{

	public GameAuthorBottomLayoutNode(double width, double height, Node node) {
		super(width, height, node);
	}

	@Override
	public void initialize(double width, double height) {
		
	}

	@Override
	public void initialize(double width, double height, Object myLinkedObject) {
		Pane bottomPane=new Pane();
		bottomPane.setPrefSize(width,height*.2);
		LevelBar myLevelBar=new LevelBar(width*.025, 20, width*.2, height*.05);
		LevelButton myLevelButton=new LevelButton();
		((GamePane)myLinkedObject).addLevelBar(myLevelBar);
		myLevelButton.setOnMouseClicked(e->(((GamePane)myLinkedObject).addLevelUpdate(new LevelObject(new ImageView()))));
		myLevelButton.relocate(width*.25, 20);
		myLevelButton.setPrefSize(100, 50);
		myLevelButton.getStyleClass().add("buttonTemplate2"
				+ "");
		Button saveButton=new Button("Save");
		saveButton.relocate(width*.35, 20);
		saveButton.setPrefSize(100,50);
		saveButton.getStyleClass().add("buttonTemplate2");
		saveButton.setOnMouseClicked(e->((GamePane) myLinkedObject).saveGame());
		DecisionTable table = new DecisionTable();
		DecisionTableButton tableButton = new DecisionTableButton(table);
		tableButton.getStyleClass().add("buttonTemplate2");
		tableButton.relocate(width*.45, 20);
		tableButton.setPrefSize(200, 50);
		bottomPane.getChildren().addAll(myLevelBar, myLevelButton, tableButton, saveButton);
		myNode=bottomPane;
		
	}

}
