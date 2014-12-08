package com.print_stack_trace.voogasalad.controller.guiElements;

import java.util.Collection;
import java.util.HashSet;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public abstract class GeneralPane extends Pane{
	protected final static double DEFAULT_WIDTH=500;
	protected final static double DEFAULT_HEIGHT=600;
	protected final static String DEFAULT_NAME="";
	private double myWidth;
	private double myHeight;
	private Stage myStage;
	protected Node myNode;
	private Collection<TextField> myTextFields=new HashSet<TextField>();
	public GeneralPane(){
		createNodePreferences(DEFAULT_WIDTH, DEFAULT_HEIGHT,"");
	}
	public void createNodePreferences(Number width, Number height, String name){
		myWidth=width.doubleValue();
		myHeight=height.doubleValue();
		this.setPrefSize(myWidth, myHeight);
		this.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	}
	public void createNodePreferences(){
		createNodePreferences(DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_NAME);
	}
	public abstract void createTextFields();
	public abstract void makeObservable(Collection toObserve);
	public abstract void loadInData(Collection myData);
	public void openPane(){
		myStage.show();
	}
	public void initiate(){
		if(myStage!=null){
			myStage.close();
		}
		myStage=new Stage();
		
		ScrollBarPane myScroll=new ScrollBarPane(myWidth, myHeight, myNode);
		Scene myScene=new Scene(myScroll, myWidth, myHeight);
		myStage.setScene(myScene);
		myStage.setHeight(myHeight);
		myStage.setWidth(myWidth+15);
	}
	public void close(){
		myStage.close();
	}
	public boolean isOpen(){
		return myStage.isShowing();
	}
	public Node getNode(){
		return myNode;
	}

}
