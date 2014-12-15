package com.print_stack_trace.voogasalad.controller.popUpPanes;

import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Properties;

import javax.swing.JOptionPane;










import com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor.GeneralPane;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.resourceReader.ResourceReader;
import com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.UserInputFactory;
import com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.UserInputType;

import javafx.scene.Node;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class PopUpPane extends GeneralPane{
	protected GameObject myGameObject;
	private String DEFAULT_RESOURCE="./com/print_stack_trace/voogasalad/controller/guiResources/";
	protected String myResourceName="";
	protected String DEFAULT_STYLE="./com/print_stack_trace/voogasalad/controller/guiResources/SpritePane.css";
	protected String myName="";
	protected HashMap<Integer, Node> myObjects=new HashMap<Integer, Node>();

	public PopUpPane(String resource, GameObject myObject){
		this(GeneralPane.DEFAULT_WIDTH, GeneralPane.DEFAULT_HEIGHT,resource, myObject);
	}

	public PopUpPane(Number width, Number height, String name, GameObject gameObject){
		super();
		myNode=new VBox();
		((VBox)myNode).setPrefSize(width.doubleValue(), height.doubleValue());
		((VBox)myNode).getStylesheets().add(DEFAULT_STYLE);
		myNode.setStyle("-fx-background-color: BLACK");
		myResourceName=name;
		myGameObject=gameObject;
		createNodePreferences(width, height, name);
		initiate();
		makeLabels();
		addNodes();

	}

	public void createTextFields(){}
	public void makeObservable(Collection toObserve){}
	public void loadInData(Collection myData){}

	private void makeLabelAndTextBox(String[] values, double width, double height, double x, double y){
		UserInputFactory myInput=new UserInputFactory();
		UserInputType typeOfInput=myInput.createUserInput(values[6], values,  
				this.getPrefWidth(), this.getPrefHeight(),  x, y, myGameObject);
		Node myInputType=typeOfInput.getLabelAndType();
		Node toAdd=(typeOfInput.getType()!=null)? myInputType: typeOfInput.getLabel();
		myObjects.put(Integer.parseInt(values[7]), toAdd);
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
				((VBox) myNode).setPrefSize(((VBox) myNode).getPrefWidth()
						+((VBox)myObjects.get(i)).getPrefWidth(),((VBox) myNode).getPrefHeight()
						+((VBox)myObjects.get(i)).getPrefHeight());
			}
		}

		if (((Region) myNode).getPrefHeight()<this.getPrefHeight()||((Region) myNode).getPrefWidth()<this.getPrefWidth()){
			((Region)myNode).setPrefSize(this.getPrefWidth(), this.getPrefHeight());
		}
	}

	private void makeLabels(){
		HashMap<String, String> resource=new ResourceReader(DEFAULT_RESOURCE+myResourceName+".Properties").getProperties();
		for(String labelName : resource.keySet()){
			String[] value=resource.get(labelName).split(";");
			makeLabelAndTextBox(value,((VBox)myNode).getPrefWidth()*Double.parseDouble(value[2]),((VBox)myNode).getPrefHeight()*Double.parseDouble(value[3]),
					((VBox)myNode).getPrefWidth()*Double.parseDouble(value[4]),((VBox)myNode).getPrefHeight()*Double.parseDouble(value[5]));
		}
	}
}
