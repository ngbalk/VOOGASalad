package com.print_stack_trace.voogasalad.controller.guiElements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;

public class SetBackground extends UserInputDropDownMenu{

	public SetBackground(GameObject object){
		super(object);
		myResourceReader=new ResourceReader("./com/print_stack_trace/voogasalad/controller/guiResources/LevelImages.Properties");
		data=myResourceReader.getProperties();
		addMenus();

	}
	@Override
	protected void linkMovement(String property) {
		Iterator<String> nextValue=Arrays.asList(split(data.get(property))).iterator();
		String imgName=nextValue.next();
		String image=nextValue.next();
		Image imageLinked=new Image(image);
		mySprite.getImage().setImage(imageLinked);
		mySprite.getImage().setVisible(true);
		((LevelObject) mySprite).getColorPane().setVisible(false);
		((LevelObject)mySprite).getCharacteristics().setBackground(imageLinked);
		mySprite.getDelegate().update((LevelObject)mySprite);
		currentMenu.setText(imgName);
	}
	
}
