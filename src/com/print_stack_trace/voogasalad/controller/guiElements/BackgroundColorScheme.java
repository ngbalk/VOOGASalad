package com.print_stack_trace.voogasalad.controller.guiElements;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;

import javax.swing.JOptionPane;

import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class BackgroundColorScheme extends UserInputType{
	public BackgroundColorScheme(){
		myNode=makeColors();

	}
	private HBox makeColors(){
		int startX=0;
		HBox myBox=new HBox();
		HashSet<String> color=this.loadColors();
		for (String myColor: color){
			Circle colorCircle=new Circle();
			colorCircle.setStyle("-fx-fill: #"+myColor);
			colorCircle.setRadius(10);
			colorCircle.relocate(startX, 0);
			myBox.getChildren().add(colorCircle);
		}
		return myBox;
	}
	private HashSet<String> loadColors(){
		HashSet<String> myColors=new HashSet<String>();
		try{
			Properties prop = new Properties();
			InputStream stream = getClass().getClassLoader().getResourceAsStream("./com/print_stack_trace/voogasalad/controller/guiResources/BackgroundColors.Properties");
			prop.load(stream);
			for(Object labelName : prop.keySet()){
				myColors.add((String)prop.get((String) labelName));
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "File not found");
		}
		return myColors;
	}
	
}
