package com.print_stack_trace.voogasalad.controller.guiElements;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;

import javafx.scene.Group;

import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
public class SpriteLocationController extends Group{
	private String DEFAULT_RESOURCE="./com/print_stack_trace/voogasalad/controller/guiResources/InputLabels.Properties";
	private String SET_X_NAME = "SetX";
	private String SET_Y_NAME = "SetY";
	private HBox myXHBox;
	private HBox myYHBox;
	private TextField mySetXTextBox;
	private TextField mySetYTextBox;
	private ImageView mySpriteImage;
	private SpriteCharacteristics mySpriteCharacteristics;
	public SpriteLocationController(ImageView spriteImage, SpriteCharacteristics spriteCharacteristics){
		mySpriteImage = spriteImage;
		mySpriteCharacteristics = spriteCharacteristics;
		mySetXTextBox = new TextField();
		mySetYTextBox = new TextField();
		mySetXTextBox.setText(Double.toString(spriteImage.getLayoutX()));
		mySetYTextBox.setText(Double.toString(spriteImage.getLayoutY()));
		makeLabels();
	}
	private void makeLabels(){
		Properties properties = new Properties();
		try {
			properties.load(this.getClass().getClassLoader().getResourceAsStream(DEFAULT_RESOURCE));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Labels File Not Available");
		}
		Label xLabel = new Label(properties.getProperty(SET_X_NAME));
		Label yLabel = new Label(properties.getProperty(SET_Y_NAME));
		myXHBox =  new HBox(xLabel, mySetXTextBox);
		myYHBox = new HBox(yLabel, mySetYTextBox);
		this.getChildren().addAll(myXHBox, myYHBox);
	}
	//Maybe we can have one button that calls this method, and have a similar method on all of these 
	//GUI elements, maybe they should implement the same interface so we can do this with a loop?
	public void setCharacteristic(){
		double newXValue = mySpriteImage.getLayoutX();
		double newYValue = mySpriteImage.getLayoutY();
		try{
			if(!mySetXTextBox.getText().isEmpty()){
				newXValue = Double.parseDouble(mySetXTextBox.getText());
			}
			if(!mySetYTextBox.getText().isEmpty()){
				newYValue = Double.parseDouble(mySetYTextBox.getText());
			}
		}
		catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Not a valid X or Y location");
		}
		mySpriteImage.setLayoutX(newXValue);
		mySpriteImage.setLayoutY(newYValue);
		
//		TO IMPLEMENT
//		mySpriteCharacteristics.setX(newXValue);
//		mySpriteCharacteristics.setY(newYValue);
	}

}
