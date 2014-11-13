package com.print_stack_trace.voogasalad.guiElements;

import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;

import javax.swing.JOptionPane;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class SpritePane extends GeneralPane {
	private int buffer=5;
	public SpritePane(){
		super();
		this.getStylesheets().add("./com/print_stack_trace/voogasalad/guiResources/SpritePane.css");
		this.setStyle("-fx-background-color: BLACK");
		//createTextFields();
		makeLabels();
	}

	@Override
	public void createTextFields() {
		TextField myTextField=new TextField();
		myTextField.getStyleClass().add("text-field1");
		this.getChildren().add(myTextField);
		
		
	}
	private void makeLabels(){
		try{
			Properties prop = new Properties();
			InputStream stream = getClass().getClassLoader().getResourceAsStream("./com/print_stack_trace/voogasalad/guiResources/SpritePane.Properties");
			prop.load(stream);
			for(Object labelName : prop.keySet()){
				String[] value=prop.getProperty((String) labelName).split(";");
				makeLabelAndTextBox(value,this.getWidth()*Double.parseDouble(value[2]),this.getHeight()*Double.parseDouble(value[3]),
						this.getWidth()*Double.parseDouble(value[4]),this.getHeight()*Double.parseDouble(value[5]));
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "File not found");
		}
	}
	
	private void makeLabelAndTextBox(String[] values, double width, double height, double x, double y){
		Label myLabel=new Label("  "+values[0]);
		myLabel.getStyleClass().add(values[1]);
		myLabel.setPrefSize(width, height);
		myLabel.relocate(x, y);
		TextField myTextField=new TextField();
		myTextField.relocate(x+width*.3, y+height*.3);
		myTextField.setPrefSize(width*.5,height*.2);
		this.getChildren().addAll(myLabel, myTextField);
	}
	@Override
	public void makeObservable(Collection toObserve) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadInData(Collection myData) {
		// TODO Auto-generated method stub
		
	}
	
	
}
