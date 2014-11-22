package com.print_stack_trace.voogasalad.controller.guiElements;

import com.print_stack_trace.voogasalad.model.engine.GameEngine;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;

public abstract class AbstractGUI extends BorderPane {
	private double myWidth;
	private double myHeight;
	private Pane gamePane;
	private GameEngine myGameEngine;
	public AbstractGUI(Number width, Number height){
		setPrefSize(width.doubleValue(), height.doubleValue());
		myWidth= width.doubleValue();
		myHeight=height.doubleValue();
		gamePane=(Pane) setCenterPane();
		setCenter(gamePane);
		setBottom(setBottomPane());
		setLeft(setLeftPane());
		setRight(setRightPane());
		setTop(setTopPane());
		this.setVisible(true);
	
	}

	//add resources file to fix hard coded numbers, fix repetition
	protected Node setBottomPane(){
		Pane bottomPane=new Pane();
		setStyle(bottomPane);
		bottomPane.setPrefSize(myWidth, 100);
		Label currentLevel=new Label("Current Level");
		currentLevel.relocate(20, 20);
		currentLevel.setStyle("-fx-font-size: 15");
		currentLevel.setPrefSize(100, 20);
		currentLevel.setTextFill(Paint.valueOf("WHITE"));
		LevelBar myLevelBar=new LevelBar(myWidth*.1, 20, 100, 20);
		LevelButton myLevelButton=new LevelButton();
		myLevelButton.relocate(myWidth*.3, 20);
		myLevelButton.setPrefSize(100, 50);
		bottomPane.getChildren().addAll(myLevelBar, currentLevel, myLevelButton);
		this.setVisible(true);
		return bottomPane;
	}
	protected Node setCenterPane(){
		GamePane centerPane=new GamePane(myWidth-400, myHeight-130);
		setBorderAndBackgroundStyle(centerPane);
		return centerPane;
	}
	
	protected Node setTopPane(){
		FileMenuBar topPane=new FileMenuBar();
		topPane.setPrefSize(myWidth, 20);
		return topPane;
	}
	
	protected Node setLeftPane(){
		Pane leftPane=null;
		return leftPane;
	}
	
	protected Node setRightPane(){
		MultipleLibraryPane myTabPane=new MultipleLibraryPane(400, myHeight-130, gamePane);
		myTabPane.setPrefSize(400, myHeight-130);
		setBorderAndBackgroundStyle(myTabPane);
		return myTabPane;
	}
	
	protected abstract void setBorderAndBackgroundStyle(Node stylePane);
	protected abstract void setStyle(Node stylePane);
	protected abstract void setBorderStyle(Node stylePane);
	public Group initialize(GameEngine gameEngine) {
		myGameEngine = gameEngine;
		Group root = new Group();
		root.getChildren().add(this);
		((GamePane) gamePane).addGameEngine(myGameEngine);
		return root;
	}
}
