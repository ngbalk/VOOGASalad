package com.print_stack_trace.voogasalad.guiElements;

import java.util.Collection;
import java.util.HashSet;

import com.print_stack_trace.voogasalad.controller.author.Sprite;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public abstract class GeneralPane extends Pane{
	private final static int DEFAULT_WIDTH=500;
	private final static int DEFAULT_HEIGHT=600;
	private final static String DEFAULT_NAME="";
	private double myWidth;
	private double myHeight;
	private Stage myStage;
	private String myName;
	private Collection<TextField> myTextFields=new HashSet<TextField>();
	public GeneralPane(){
		this(DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_NAME);
	}
	public GeneralPane(Number width, Number height, String name){
		initiate();
		myName=name;	
	}
	public abstract void createTextFields();
	public abstract void makeObservable(Collection toObserve);
	public abstract void loadInData(Collection myData);
	public void openPane(){
		myStage.show();
	}
	private void initiate(){
		if(myStage!=null){
			myStage.close();
		}
		myStage=new Stage();
		Scene myScene=new Scene(this, DEFAULT_WIDTH, DEFAULT_HEIGHT);
		myStage.setScene(myScene);
		this.setPrefSize(myWidth, myHeight);
	}	
}
