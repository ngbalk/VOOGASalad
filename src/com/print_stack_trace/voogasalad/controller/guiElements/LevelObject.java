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
	}
	public LevelObject(ImageView imgView, ViewObjectDelegate myDelegate) {
		super(imgView, myDelegate);	
	}
	public LevelCharacteristics getCharacteristics(){
		return myCharacteristics;
	}
	public void setImageView(ImageView myView){
		myImage=myView;
	}
	public void setDelegate(ViewObjectDelegate delegate){
		myDelegate=delegate;
	}
	public void setColorPane(Color color){
		this.setImage(null);
		colorPane.setVisible(true);
		colorPane.setStyle("-fx-background-color: #"+Integer.toHexString(color.hashCode()));
	}
	public Pane getColorPane (){
		return colorPane;
	}

}
