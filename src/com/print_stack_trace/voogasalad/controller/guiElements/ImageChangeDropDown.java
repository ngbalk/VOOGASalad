package com.print_stack_trace.voogasalad.controller.guiElements;

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

public class ImageChangeDropDown extends UserInputDropDownMenu{
	public ImageChangeDropDown(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
		myResourceReader=new ResourceReader("./com/print_stack_trace/voogasalad/controller/guiResources/SpriteImages.Properties");
		data=myResourceReader.getProperties();
		addMenus();
	}
		
	@Override
	protected void linkMovement(String image) {
		Iterator<String> myValue=Arrays.asList(this.split(data.get(image))).iterator();
		System.out.println(image);
		currentMenu.setText(myValue.next());
		Image imageLinked=new Image(myValue.next());
		System.out.println(imageLinked);
		mySprite.getImage().setImage(imageLinked);
		((SpriteObject)mySprite).getCharacteristics().setImage(imageLinked);
		mySprite.getDelegate().update((SpriteObject)mySprite);
		
	}
}
