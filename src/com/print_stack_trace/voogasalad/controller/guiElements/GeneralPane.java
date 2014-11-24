package com.print_stack_trace.voogasalad.controller.guiElements;

import java.util.Collection;
import java.util.HashSet;

import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public abstract class GeneralPane extends Pane{
	private final static double DEFAULT_WIDTH=500;
	private final static double DEFAULT_HEIGHT=600;
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
		myName=name;
		myWidth=width.doubleValue();
		myHeight=height.doubleValue();
		this.setPrefSize(myWidth, myHeight);
		initiate();
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
		ScrollBarPane myScroll=new ScrollBarPane(myWidth, myHeight, this);
		Scene myScene=new Scene(myScroll, myWidth, myHeight);
		myStage.setScene(myScene);
		myStage.setHeight(myHeight);
		myStage.setWidth(myWidth+15);
	}
	public void close(){
		myStage.close();
	}
	
}
