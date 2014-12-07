package com.print_stack_trace.voogasalad.controller.guiElements;

import java.io.InputStream;
import java.util.Collection;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.print_stack_trace.voogasalad.controller.gameElements.Sprite;
import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

public class PopUpPane extends GeneralPane{
	protected GameObject myGameObject;
	private String DEFAULT_RESOURCE="./com/print_stack_trace/voogasalad/controller/guiResources/";
	protected String myResourceName="";
	protected String myName="";
	public PopUpPane(String resource, GameObject myObject){
		super();
		initiate(resource, myObject);
	}
	public PopUpPane(Number width, Number height, String name, GameObject gameObject){
		super(width, height, name);
		initiate(name, gameObject);
	}
	private void initiate(String resource, GameObject myObject){
		myResourceName=resource;
		myGameObject=myObject;
		this.getStylesheets().add("./com/print_stack_trace/voogasalad/controller/guiResources/SpritePane.css");
		this.setStyle("-fx-background-color: BLACK");
		makeLabels();
		Button submit = new Button("Submit");
		submit.setOnAction(e->this.close());
		submit.setPrefSize(80,20);
//		this.getChildren().add(submit);
		DeleteButton delete = new DeleteButton(myObject, myObject.getDelegate());
		delete.setPrefSize(80, 20);
		HBox buttonBox = new HBox();
		buttonBox.getChildren().addAll(delete.getButton(), submit);
		buttonBox.toFront();
		buttonBox.relocate(0, 0);//yCoord);
		this.getChildren().add(buttonBox);
	}
	public void createTextFields(){}
	public void makeObservable(Collection toObserve){}
	public void loadInData(Collection myData){}

	private void makeLabelAndTextBox(String[] values, double width, double height, double x, double y){
		Label myLabel=new Label("  "+values[0]);
		myLabel.getStyleClass().add(values[1]);
		myLabel.setPrefSize(width, height);
		myLabel.relocate(x, y);
		UserInputFactory myInput=new UserInputFactory();
		Node myInputType=myInput.createUserInput(values[6], values, myGameObject).getType();
		
		//needs refactoring
		this.getChildren().add(myLabel);
		if (myInputType!=null){
			myInputType.relocate(x+width*.4, y+height*.25);
			((Region) myInputType).setPrefSize(width*.5,height*.2);
			this.getChildren().add(myInputType);
		}
	}
	private void makeLabels(){
		try{
			Properties prop = new Properties();
			InputStream stream = getClass().getClassLoader().getResourceAsStream(DEFAULT_RESOURCE+myResourceName+".Properties");
			prop.load(stream);
			for(Object labelName : prop.keySet()){
				String[] value=prop.getProperty((String) labelName).split(";");
				makeLabelAndTextBox(value,this.getPrefWidth()*Double.parseDouble(value[2]),this.getPrefHeight()*Double.parseDouble(value[3]),
						this.getPrefWidth()*Double.parseDouble(value[4]),this.getPrefHeight()*Double.parseDouble(value[5]));
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, myResourceName+" Not Available");
		}
	}

}
