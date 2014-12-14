package com.print_stack_trace.voogasalad.controller.guiElements.gameObjects;

import java.util.ArrayList;

import com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor.ViewObjectDelegate;
import com.print_stack_trace.voogasalad.controller.popUpPanes.PaneChooser;
import com.print_stack_trace.voogasalad.model.LevelCharacteristics;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class LevelObject extends GameObject{
	private LevelCharacteristics myCharacteristics;
	private Pane colorPane;
	public LevelObject(String imagePath, ViewObjectDelegate myDelegate) {
		this(imagePath, myDelegate, new LevelCharacteristics());
	}

	public LevelObject(String imagePath, ViewObjectDelegate myDelegate, LevelCharacteristics levelCharacteristics) {
		super(imagePath, myDelegate);
		myCharacteristics = levelCharacteristics;
		colorPane=new Pane();
		colorPane.setVisible(false);
		myCharacteristics=new LevelCharacteristics();
		myCharacteristics.setBackgroundImagePath(imagePath);
		colorPane.setOnMouseClicked(e->showPane());
		createPane();
		getImage().setOnMouseClicked(e->showPane());
	}

	public LevelObject(String imagePath) {
		super(imagePath);
	}

	public LevelCharacteristics getCharacteristics(){
		return myCharacteristics;
	}

	private void setImageView(ImageView myView){
		myImage=myView;
		getImage().setOnMouseClicked(e->showPane());
	}
	public void setImageViewWithImage(ImageView view, String path){
		setImageView(view);
		setImage(path);
		getColorPane().setVisible(false);
	}

	public void setColorPane(String color){
		setImage(null);
		myImage.setVisible(false);
		myCharacteristics.setBackground(null);
		colorPane.setVisible(true);
		colorPane.setStyle("-fx-background-color: #"+color);
		update();
	}

	public Pane getColorPane (){
		return colorPane;
	}

	@Override
	public void update() {
		myDelegate.update(this);
	}

	@Override
	public void createPane() {
		PaneChooser myPaneChooser=new PaneChooser();
		myPane=myPaneChooser.createPane("level background", this);
	}
	public ImageView createBackgroundImageView(Number width, Number height){
		getImage().setFitWidth(width.doubleValue());
		getImage().setFitHeight(height.doubleValue());
		getImage().setSmooth(true);
		getImage().setPreserveRatio(false);
		getCharacteristics().setBackground(getImage().getImage());
		return getImage();
	}

	@Override
	public void setImageCharacteristics() {
		myCharacteristics.setBackgroundImagePath(myImagePath);	
	}
}
