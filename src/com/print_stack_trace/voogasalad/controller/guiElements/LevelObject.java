package com.print_stack_trace.voogasalad.controller.guiElements;

import com.print_stack_trace.voogasalad.model.LevelCharacteristics;

import javafx.scene.image.ImageView;

public class LevelObject extends GameObject{
	private LevelCharacteristics myCharacteristics=new LevelCharacteristics();
	public LevelObject(ImageView image) {
		super(image);	
	}
	public LevelObject(ImageView imgView, ViewObjectDelegate myDelegate) {
		super(imgView, myDelegate);	
	}
	public LevelCharacteristics getCharacteristics(){
		return myCharacteristics;
	}

}
