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
	protected String myStyle;
	public AbstractGUI(Number width, Number height){
		setPrefSize(width.doubleValue(), height.doubleValue());
		myWidth= width.doubleValue();
		myHeight=height.doubleValue();
	}
	//add resources file to fix hard coded numbers, fix repetition
	protected Node setBottomPane(){
		Pane bottomPane=new Pane();
		bottomPane.setPrefSize(getPrefWidth(),myHeight*.2);
		setStyle(bottomPane);
		LevelBar myLevelBar=new LevelBar(myWidth*.025, 20, myWidth*.2, myHeight*.05);
		LevelButton myLevelButton=new LevelButton();
		gamePane.addLevelBar(myLevelBar);
		myLevelButton.setOnMouseClicked(e->gamePane.addLevelUpdate(new LevelObject(new ImageView())));
		myLevelButton.relocate(myWidth*.25, 20);
		myLevelButton.setPrefSize(100, 50);
		myLevelButton.getStyleClass().add("buttonTemplate2"
				+ "");
		Button saveButton=new Button("Save");
		saveButton.relocate(myWidth*.35, 20);
		saveButton.setPrefSize(100,50);
		saveButton.getStyleClass().add("buttonTemplate2");
		saveButton.setOnMouseClicked(e->save(saveButton));
		DecisionTable table = new DecisionTable();
		DecisionTableButton tableButton = new DecisionTableButton(table);
		tableButton.getStyleClass().add("buttonTemplate2");
		tableButton.relocate(myWidth*.45, 20);
		tableButton.setPrefSize(200, 50);
		bottomPane.getChildren().addAll(myLevelBar, myLevelButton, tableButton, saveButton);
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
				new MessagePopUp(myStyle).showMessageDialog(ex.getMessage());
			}
		}
	}

	protected Node setCenterPane(){
		GamePane centerPane=new GamePane(myWidth-400, myHeight-130, myGameEngine);
		setBorderAndBackgroundStyle(centerPane);
		gamePane=centerPane;
		ScrollBarPane myScroll=new ScrollBarPane(myWidth-200, myHeight-130, centerPane);

		return myScroll;
	}

	protected Node setTopPane(){
		FileMenuBar topPane=new FileMenuBar(myStyle);
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
		setCenter(setCenterPane());
		setBottom(setBottomPane());
		setLeft(setLeftPane());
		setRight(setRightPane());
		setTop(setTopPane());
		this.setVisible(true);
		Group root = new Group();
		root.getChildren().add(this);
		return root;
	}
}
