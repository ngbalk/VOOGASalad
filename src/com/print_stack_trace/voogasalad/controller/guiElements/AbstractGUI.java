package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.scene.Node;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public abstract class AbstractGUI extends BorderPane {
	private double myWidth;
	private double myHeight;
	public AbstractGUI(double width, double height){
		//setPrefSize((double)width, (double)height);
		myWidth= width;
		myHeight=height;
		setCenter(setCenterPane());
		setBottom(setBottomPane());
		setLeft(setLeftPane());
		setRight(setRightPane());
		setTop(setTopPane());
		this.setVisible(true);
	
	}
	
	//add resources file to fix hard coded numbers, fix repetition
	protected Node setBottomPane(){
		Pane bottomPane=new Pane();
		setStyle(bottomPane);
		bottomPane.setPrefSize(myWidth, 100);
		this.setVisible(true);
		return bottomPane;
	}
	protected Node setCenterPane(){
		Pane centerPane=new Pane();
		centerPane.setPrefSize(myWidth-400, myHeight-100);
		setBorderAndBackgroundStyle(centerPane);
		return centerPane;
	}
	
	protected Node setTopPane(){
		FileMenuBar topPane=new FileMenuBar();
		topPane.setPrefSize(myWidth-20, 20);
		return topPane;
	}
	
	protected Node setLeftPane(){
		Pane leftPane=null;
		return leftPane;
	}
	
	protected Node setRightPane(){
		MultipleLibraryPane myTabPane=new MultipleLibraryPane(myWidth, myHeight);
		myTabPane.setPrefSize(400, myHeight-130);
		setBorderAndBackgroundStyle(myTabPane);
		return myTabPane;
	}
	
	protected abstract void setBorderAndBackgroundStyle(Node stylePane);
	protected abstract void setStyle(Node stylePane);
	protected abstract void setBorderStyle(Node stylePane);
}
