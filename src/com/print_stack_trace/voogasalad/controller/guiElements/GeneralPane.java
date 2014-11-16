package com.print_stack_trace.voogasalad.guiElements;

import java.util.Collection;
import java.util.HashSet;

import com.print_stack_trace.voogasalad.gameElements.GameObject;

import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public abstract class GeneralPane extends Pane{
	private final int DEFAULT_WIDTH=200;
	private final int DEFAULT_HEIGHT=300;
	private final String DEFAULT_NAME="";
	private GameObject myGameObject;
	private String myName;
	private Collection<TextField> myTextFields=new HashSet<TextField>();
	public GeneralPane(){
		this.setPrefSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		myName=DEFAULT_NAME;
		myGameObject=null;
	}
	
	public GeneralPane(Number width, Number height, String name, GameObject gameObject){
		this.setMaxSize((double)width, (double)height);
		myName=name;
		myGameObject=gameObject;	
	}
	
	
	public abstract void createTextFields();
	public abstract void makeObservable(Collection toObserve);
	public abstract void loadInData(Collection myData);
	
	
}
