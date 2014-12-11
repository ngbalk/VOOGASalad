package com.print_stack_trace.voogasalad.controller.guiElements;

import java.util.ArrayList;

import com.print_stack_trace.voogasalad.model.LevelCharacteristics;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class LevelObject extends GameObject{
	private LevelCharacteristics myCharacteristics;
	private Pane colorPane;
	private ArrayList<ImageView> myImages=new ArrayList<ImageView>();
	private ArrayList<Pane> myColorPanes=new ArrayList<Pane>();
	
	public LevelObject(String imagePath, ViewObjectDelegate myDelegate) {
		this(imagePath, myDelegate, new LevelCharacteristics());
		
	}
	public LevelObject(String imagePath, ViewObjectDelegate myDelegate, LevelCharacteristics levelCharacteristics) {
		super(imagePath, myDelegate);
		this.myDelegate=myDelegate;
		myCharacteristics = levelCharacteristics;
		colorPane=new Pane();
		colorPane.setVisible(false);
		myCharacteristics=new LevelCharacteristics();
		myCharacteristics.setBackgroundImagePath(imagePath);
		createPane();
		this.getImage().setOnMouseClicked(e->showPane());
		colorPane.setOnMouseClicked(e->showPane());
	}
	public LevelObject(String imagePath) {
		super(imagePath);
	}
	
	public LevelCharacteristics getCharacteristics(){
		return myCharacteristics;
	}
	public void setImageView(ImageView myView){
		myImage=myView;
		this.getImage().setOnMouseClicked(e->showPane());
	}
	public void setImagePath(String imagePath){
		myImagePath = imagePath;
		myCharacteristics.setBackgroundImagePath(imagePath);
	}
	public void setDelegate(ViewObjectDelegate delegate){
		myDelegate=delegate;
	}
	public void setColorPane(String color){
		this.setImage(null);
		myImage.setVisible(false);
		myCharacteristics.setBackground(null);
		colorPane.setVisible(true);
		update();
		colorPane.setStyle("-fx-background-color: #"+color);
	}
	public Pane getColorPane (){
		return colorPane;
	}
	@Override
	protected void update() {
		myDelegate.update(this);
	}

	@Override
	public void createPane() {
		PaneChooser myPaneChooser=new PaneChooser();
		myPane=myPaneChooser.createPane("level background", this);
	}
	

}
