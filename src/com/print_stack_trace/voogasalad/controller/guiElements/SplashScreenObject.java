package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;

public abstract class SplashScreenObject {
	protected Node myNode;
	protected String mySource;
	protected double myWidth;
	protected double myHeight;
	protected Group root;
	protected String myStyle="./com/print_stack_trace/voogasalad/"
			+ "controller/guiResources/SplashPane.css";
	public SplashScreenObject(String source, double width, double height, Group group){
		mySource=source;
		myWidth=width;
		myHeight=height;
		root=group;
	}
	public abstract boolean update();
	public Node getNode(){
		return myNode;
	}
	public abstract void addEnd(EventHandler event);
}
