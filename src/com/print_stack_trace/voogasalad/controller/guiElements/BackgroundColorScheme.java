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
	public BackgroundColorScheme(GameObject object){
		this();
		mySprite=object;
		((ColorPicker) myNode).setOnAction(e -> changeColor(((ColorPicker) myNode).getValue()));
	}
	private void changeColor(Color color){
		((LevelObject) mySprite).getImage().setVisible(false);
		((LevelObject) mySprite).getCharacteristics().setBackground(null);
		((LevelObject) mySprite).setColorPane(color);
		((LevelObject) mySprite).getCharacteristics().setBackgroundColor(color);
		((LevelObject) mySprite).getDelegate().update((LevelObject)mySprite);
	}
	
}
