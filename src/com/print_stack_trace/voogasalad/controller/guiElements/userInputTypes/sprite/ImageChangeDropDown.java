package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.sprite;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;

import javax.swing.JOptionPane;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.SpriteObject;
import com.print_stack_trace.voogasalad.controller.guiElements.resourceReader.ResourceReader;
import com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.UserInputDropDownMenu;

public class ImageChangeDropDown extends SpriteUserInputDropDown{
	public ImageChangeDropDown(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
	}

	@Override
	protected void linkMovement(String image) {
		Iterator<String> myValue=Arrays.asList(this.split(data.get(image))).iterator();
		currentMenu.setText(myValue.next());
		String imgPath=myValue.next();
		mySprite.setImage(imgPath);
		mySprite.getDelegate().update((SpriteObject)mySprite);

	}

	@Override
	protected void observableFunction() {
		loadInitial();
	}


	@Override
	protected void loadData() {
		myResourceReader=new ResourceReader("./com/print_stack_trace/voogasalad/controller/guiResources/SpriteImages.Properties");
		data=myResourceReader.getProperties();
	}

	@Override
	protected void loadInitialFunction(String name, Object type) {
		Iterator<String> myValue=Arrays.asList(this.split(data.get(name))).iterator();
		String imgName=myValue.next();
		String imgPath=myValue.next();
		if (imgPath.equals((String) type)){
			checkSelectBox(name);
			setCurrent(imgName);
		}
		else
			uncheckSelectBox(name);
	}

	@Override
	protected Object getCharacteristicType() {
		String path=((SpriteObject) mySprite).getCharacteristics().getImagePath();
		return path;
	}
}
