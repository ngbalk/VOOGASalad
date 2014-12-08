package com.print_stack_trace.voogasalad.controller.guiElements;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;

import javax.swing.JOptionPane;

import javafx.scene.control.ColorPicker;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class BackgroundColorScheme extends UserInputType{
	public BackgroundColorScheme(){
		myNode= new ColorPicker();
	}
	public BackgroundColorScheme(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
		myNode= new ColorPicker();
		mySprite=object;
		((ColorPicker) myNode).setOnAction(e -> changeColor(((ColorPicker) myNode).getValue()));
		this.makeInitialNode();
	}
	private void changeColor(Color color){
		((LevelObject) mySprite).setColorPane(Integer.toHexString(color.hashCode()));
		((LevelObject) mySprite).getCharacteristics().setBackgroundColor(Integer.toHexString(color.hashCode()));
		((LevelObject) mySprite).getDelegate().update((LevelObject)mySprite);
	}
	
}
