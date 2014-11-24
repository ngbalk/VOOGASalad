package com.print_stack_trace.voogasalad.controller.guiElements;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;

import javax.swing.JOptionPane;

public class ImageChangeDropDown extends UserInputDropDownMenu{
	private HashMap<String, String> myImages=new HashMap<String, String>();
	public ImageChangeDropDown(GameObject myObject){
		super(myObject);
		myResourceReader=new ResourceReader("./com/print_stack_trace/voogasalad/controller/guiResources/SpriteImages.Properties");
		myImages=myResourceReader.getProperties();
		addMenus();
	}
	private void linkToImage(String itemName, String imageString){
		Image imageLinked=new Image(imageString);
		currentMenu.setText(itemName);
		mySprite.getImage().setImage(imageLinked);
		((SpriteObject)mySprite).getCharacteristics().setImage(imageLinked);
		mySprite.getDelegate().update((SpriteObject)mySprite);
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
