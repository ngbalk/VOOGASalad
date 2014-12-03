package com.print_stack_trace.voogasalad.controller.guiElements;

import com.print_stack_trace.voogasalad.model.LevelCharacteristics;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class LevelObject extends GameObject{
	private LevelCharacteristics myCharacteristics=new LevelCharacteristics();
	private Pane colorPane;
	public LevelObject(ImageView image) {
		super(image);	
		colorPane=new Pane();
		colorPane.setVisible(false);
		createPane();
		this.getImage().setOnMouseClicked(e->showPane());
		colorPane.setOnMouseClicked(e->showPane());
	}
	public LevelObject(ImageView imgView, ViewObjectDelegate myDelegate) {
		super(imgView, myDelegate);	
	}
	public LevelCharacteristics getCharacteristics(){
		return myCharacteristics;
	}
	public void setImageView(ImageView myView){
		myImage=myView;
		this.getImage().setOnMouseClicked(e->showPane());
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
