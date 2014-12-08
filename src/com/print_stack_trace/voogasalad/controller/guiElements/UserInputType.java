package com.print_stack_trace.voogasalad.controller.guiElements;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public abstract class UserInputType  {
	protected Node myNode=null;
	protected String[] myValues;
	protected GameObject mySprite;
	protected ResourceReader myResourceReader;
	protected double myWidth;
	protected double myHeight;
	protected double myX;
	protected double myY;
	protected ArrayList<Pane> root=new ArrayList<Pane>();
	protected VBox myPanes=new VBox();
	protected Label myLabel;
	protected String[] value;
	protected String myStyle="./com/print_stack_trace/voogasalad/controller/guiResources/SpritePane.css";
	public UserInputType(){
	}
	public UserInputType(String[] values,  double width, double height, double x, double y, GameObject object){
		mySprite=object;
		value=values;
		myWidth=width*Double.parseDouble(values[2]);
		myHeight=height*Double.parseDouble(values[3]);
		myX=x*Double.parseDouble(values[4]);
		myY=y*Double.parseDouble(values[5]);
		myPanes.setPrefSize(myWidth, myHeight);
		makeLabel(values[0], values[1], width, height, x, y);
	}
	public Node getType(){
		return myNode;
	}
	public VBox getLabelAndType(){
		return myPanes;
	}
	protected void makeLabel(String name, String style, double width, double height, double x, double y){
		root.add(new Pane());
		Pane labelPane=root.get((root.size()-1));
		myLabel=new Label("  "+name);
		myLabel.getStylesheets().add(myStyle);
		myLabel.getStyleClass().add(style);
		myLabel.setPrefSize(myWidth, myHeight);
		labelPane.getChildren().add(myLabel);
		labelPane.setPrefSize(myWidth, myHeight);
		myPanes.setPrefSize(myWidth, root.size()*myHeight);
		myPanes.getChildren().add(labelPane);
	}
	protected Node makeInitialNode(){
		return makeNode(myNode);
		
	}
	protected Node makeNode(Node node){
		node.relocate(myWidth*.5, myHeight*.25);
		((Region) node).setPrefSize(myWidth*.4, myHeight*.2);
		root.get(root.size()-1).getChildren().add(node);
		return node;
	}
	
	protected void makeLabel(String name, String style, double width, double height, double x, double y, UserInputType type){
		
		makeLabel(name, style, width, height, x, y);
		this.makeNode(type.getType());
		
	}
	public VBox getLabel(){
		return myPanes;
	}
	
}
