package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.LevelObject;
import com.print_stack_trace.voogasalad.controller.guiElements.resourceReader.ResourceReader;
import com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.UserInputDropDownMenu;

import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;

public class SetBackground extends UserInputDropDownMenu{
	public SetBackground(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
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
		mySprite.setImage(image);
		((LevelObject) mySprite).getColorPane().setVisible(false);
		((LevelObject)mySprite).getCharacteristics().setBackground(imageLinked);
		mySprite.update();
		currentMenu.setText(imgName);
	}
	
}
