package com.print_stack_trace.voogasalad.controller.guiElements;

import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Properties;

import javax.swing.JOptionPane;





import javafx.scene.Node;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class PopUpPane extends GeneralPane{
	protected GameObject myGameObject;
	private String DEFAULT_RESOURCE="./com/print_stack_trace/voogasalad/controller/guiResources/";
	protected String myResourceName="";
	protected String myName="";
	protected HashMap<Integer, Node> myObjects=new HashMap<Integer, Node>();
	public PopUpPane(String resource, GameObject myObject){
		this(GeneralPane.DEFAULT_WIDTH, GeneralPane.DEFAULT_HEIGHT,resource, myObject);
	}
	public PopUpPane(Number width, Number height, String name, GameObject gameObject){
		super();
		myNode=new VBox();
		((VBox)myNode).setPrefSize(width.doubleValue(), height.doubleValue());
		((VBox)myNode).getStylesheets().add("./com/print_stack_trace/voogasalad/controller/guiResources/SpritePane.css");
		myNode.setStyle("-fx-background-color: BLACK");
		myResourceName=name;
		myGameObject=gameObject;
		this.createNodePreferences(width, height, name);
		this.initiate();
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
		((VBox)myNode).setPrefSize(0, 0);
		int max=0;
		for (Integer index: myObjects.keySet()){
			max=Math.max(max, index.intValue());
		}
		for (int i=0; i<=max; i++){
			if (myObjects.get(i)!=null){
				((VBox)myNode).getChildren().add(myObjects.get(i));
				((VBox) myNode).setPrefSize(((VBox) myNode).getPrefWidth()+((VBox)myObjects.get(i)).getPrefWidth(),((VBox) myNode).getPrefHeight()+((VBox)myObjects.get(i)).getPrefHeight());
			}
		}
		if (((Region) myNode).getPrefHeight()<this.getPrefHeight()||((Region) myNode).getPrefWidth()<this.getPrefWidth()){
			((Region)myNode).setPrefSize(this.getPrefWidth(), this.getPrefHeight());
		}
	}
	private void makeLabels(){
		try{
			Properties prop = new Properties();
			InputStream stream = getClass().getClassLoader().getResourceAsStream(DEFAULT_RESOURCE+myResourceName+".Properties");
			prop.load(stream);
			for(Object labelName : prop.keySet()){
				String[] value=prop.getProperty((String) labelName).split(";");
				makeLabelAndTextBox(value,((VBox)myNode).getPrefWidth()*Double.parseDouble(value[2]),((VBox)myNode).getPrefHeight()*Double.parseDouble(value[3]),
						((VBox)myNode).getPrefWidth()*Double.parseDouble(value[4]),((VBox)myNode).getPrefHeight()*Double.parseDouble(value[5]));
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, myResourceName+" Not Available");
		}
	}

}
