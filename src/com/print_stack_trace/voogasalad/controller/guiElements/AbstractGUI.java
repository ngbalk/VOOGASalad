package com.print_stack_trace.voogasalad.controller.guiElements;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.print_stack_trace.voogasalad.model.engine.GameEngine;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public abstract class AbstractGUI extends BorderPane {
	private double myWidth;
	private double myHeight;
	private GamePane gamePane;
	private GameEngine myGameEngine;
	public AbstractGUI(Number width, Number height){
		setPrefSize(width.doubleValue(), height.doubleValue());
		myWidth= width.doubleValue();
		myHeight=height.doubleValue();
		setCenter(setCenterPane());
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
		gamePane.addLevelBar(myLevelBar);
		gamePane.addLevelUpdate(new LevelObject(new ImageView()));
		myLevelButton.setOnMouseClicked(e->gamePane.addLevelUpdate(new LevelObject(new ImageView())));
		myLevelButton.relocate(myWidth*.3, 20);
		myLevelButton.setPrefSize(100, 50);
		Button saveButton=new Button("Save");
		saveButton.relocate(myWidth*.5, 20);
		saveButton.setPrefSize(100,50);
		saveButton.setOnMouseClicked(e->save(saveButton));
		DecisionTable table = new DecisionTable();
		DecisionTableButton tableButton = new DecisionTableButton(table);
		bottomPane.getChildren().addAll(myLevelBar, currentLevel, myLevelButton, tableButton, saveButton);
		this.setVisible(true);
		return bottomPane;
	}
	public void save(Button myButton){
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save Level");
		Stage newStage=new Stage();
		File file = fileChooser.showSaveDialog(newStage);
		if (file != null) {
			try {
				FileOutputStream myFile=new FileOutputStream(file);
				myGameEngine.saveGame(new BufferedOutputStream(myFile));
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	protected Node setCenterPane(){
		GamePane centerPane=new GamePane(myWidth-400, myHeight-130);
		setBorderAndBackgroundStyle(centerPane);
		gamePane=centerPane;
		ScrollBarPane myScroll=new ScrollBarPane(myWidth-200, myHeight-130, centerPane);

		return myScroll;
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
