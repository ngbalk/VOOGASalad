package com.print_stack_trace.voogasalad.controller.guiElements;

import java.util.HashMap;

import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;

public class SetBackground extends UserInputDropDownMenu{
	private HashMap<String, String> myImages=new HashMap<String, String>();
	public SetBackground(GameObject object){
		super(object);
		myResourceReader=new ResourceReader("./com/print_stack_trace/voogasalad/controller/guiResources/LevelImages.Properties");
		myImages=myResourceReader.getProperties();
		addMenus();
	}
	private void linkToImage(String itemName, String imageString){
		Image imageLinked=new Image(imageString);
		currentMenu.setText(itemName);
		mySprite.getImage().setImage(imageLinked);
		mySprite.getImage().setVisible(true);
		((LevelObject) mySprite).getColorPane().setVisible(false);
		((LevelObject)mySprite).getCharacteristics().setBackground(imageLinked);
		mySprite.getDelegate().update((LevelObject)mySprite);
	}
	protected void addMenus(){
		for (String imageName: myImages.keySet()){
			MenuItem itemToAdd=new MenuItem(imageName);
			itemToAdd.setOnAction(event->linkToImage((String) imageName, 
					myImages.get(imageName)));
			currentMenu.getItems().add(itemToAdd);	
		}
	}
}
