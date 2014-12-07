package com.print_stack_trace.voogasalad.controller.guiElements;

import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.print_stack_trace.voogasalad.controller.gameElements.Sprite;
import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class PopUpPane extends GeneralPane{
	protected GameObject myGameObject;
	private String DEFAULT_RESOURCE="./com/print_stack_trace/voogasalad/controller/guiResources/";
	protected String myResourceName="";
	protected String myName="";
	protected VBox myNode=new VBox();
	protected HashMap<Integer, Node> myObjects=new HashMap<Integer, Node>();
	public PopUpPane(String resource, GameObject myObject){
		super();
		initiate(resource, myObject);
		this.getChildren().add(myNode);
	}
	public PopUpPane(Number width, Number height, String name, GameObject gameObject){
		super(width, height, name);
		myNode.setPrefSize(width.doubleValue(), height.doubleValue());
		initiate(name, gameObject);
		this.getChildren().add(myNode);
	}
	private void initiate(String resource, GameObject myObject){
		myResourceName=resource;
		myGameObject=myObject;
		myNode.getStylesheets().add("./com/print_stack_trace/voogasalad/controller/guiResources/SpritePane.css");
		myNode.setStyle("-fx-background-color: BLACK");
		makeLabels();
		addNodes();
	}
	public void createTextFields(){}
	public void makeObservable(Collection toObserve){}
	public void loadInData(Collection myData){}
	private void makeLabelAndTextBox(String[] values, double width, double height, double x, double y){
		UserInputFactory myInput=new UserInputFactory();
		UserInputType typeOfInput=myInput.createUserInput(values[6], values,  this.getPrefWidth(), this.getPrefHeight(),  x, y, myGameObject);
		Node myInputType=typeOfInput.getLabelAndType();
		
		if (typeOfInput.getType()!=null){
			myObjects.put(Integer.parseInt(values[7]), myInputType);
			
		}
		else{
			myObjects.put(Integer.parseInt(values[7]),typeOfInput.getLabel());
			
		}
		
	}
	private void addNodes(){
		int max=0;
		for (Integer index: myObjects.keySet()){
			max=Math.max(max, index.intValue());
		}
		for (int i=0; i<=max; i++){
			if (myObjects.get(i)!=null){
				myNode.getChildren().add(myObjects.get(i));
			}
		}
	}
	private void makeLabels(){
		try{
			Properties prop = new Properties();
			InputStream stream = getClass().getClassLoader().getResourceAsStream(DEFAULT_RESOURCE+myResourceName+".Properties");
			prop.load(stream);
			for(Object labelName : prop.keySet()){
				
				String[] value=prop.getProperty((String) labelName).split(";");
				makeLabelAndTextBox(value,myNode.getPrefWidth()*Double.parseDouble(value[2]),myNode.getPrefHeight()*Double.parseDouble(value[3]),
						myNode.getPrefWidth()*Double.parseDouble(value[4]),myNode.getPrefHeight()*Double.parseDouble(value[5]));
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, myResourceName+" Not Available");
		}
	}

}
