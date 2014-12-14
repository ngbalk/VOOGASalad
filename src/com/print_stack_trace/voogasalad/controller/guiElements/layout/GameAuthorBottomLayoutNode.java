package com.print_stack_trace.voogasalad.controller.guiElements.layout;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import com.print_stack_trace.voogasalad.controller.guiElements.buttons.AbstractButton;
import com.print_stack_trace.voogasalad.controller.guiElements.buttons.DecisionTableButton;
import com.print_stack_trace.voogasalad.controller.guiElements.buttons.LevelExtendDownButton;
import com.print_stack_trace.voogasalad.controller.guiElements.buttons.LevelExtendRightButton;
import com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor.AbstractViewDelegate;
import com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor.DecisionTable;
import com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor.GamePane;
import com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor.LevelBar;
import com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor.ViewObjectDelegate;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.LevelObject;
import com.print_stack_trace.voogasalad.controller.guiElements.resourceReader.ResourceReader;
import com.print_stack_trace.voogasalad.model.engine.GameEngine;
import com.print_stack_trace.voogasalad.utilities.reflection.Reflection;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;


public class GameAuthorBottomLayoutNode extends AbstractLayoutNode{
	public GameAuthorBottomLayoutNode(double width, double height, Node toBeLinked, Object engine, AbstractViewDelegate delegate) {
		super(width, height, toBeLinked, engine, delegate);
		DecisionTable decisiontable=new DecisionTable((GameEngine) engine);
		DecisionTableButton tableButton= new DecisionTableButton(decisiontable);
		tableButton.getStyleClass().add("buttonTemplate2");
		tableButton.relocate(width*.80, 20);
		tableButton.setPrefSize(200, 50);
		((Pane) myNode).getChildren().add(tableButton);
	}

	@Override
	public void initialize(double width, double height) {
		
	}

	@Override
	public void initialize(double width, double height, Node myLinkedObject, Object engine, AbstractViewDelegate delegate) {
		
		Pane bottomPane=new Pane();
		bottomPane.setPrefSize(width, height*.2);
		LevelBar myLevelBar=new LevelBar(width*.025, 20, width*.2, height*.05, ((GamePane) myLinkedObject).currentLevelProperty(), 
				((GamePane) myLinkedObject).addLevelProperty(), ((GamePane) myLinkedObject).eventLevelProperty());	
		HBox myToolBar=new HBox();
		myToolBar.getChildren().add(myLevelBar);
		for (String values: myResource.values()){
			Iterator<String> it=Arrays.asList(values.split(";")).iterator();
			if (it.hasNext()&&it.next().equals("toolBar")){
				String className=this.iterate(it); 
				String buttonText=this.iterate(it);
				AbstractButton newButton=(AbstractButton) new Reflection().createInstance
						(className, buttonText, (ViewObjectDelegate) myLinkedObject);
				newButton.setPrefSize(Double.parseDouble(this.iterate(it))*width, Double.parseDouble(this.iterate(it))*height);
				newButton.getStyleClass().add(iterate(it));
				myToolBar.getChildren().add(newButton);
			}
		}
		
		bottomPane.getChildren().add(myToolBar);
		myNode=bottomPane;
		
	}
	private String iterate(Iterator<String> myValueIterator){
		return (myValueIterator.hasNext())? myValueIterator.next():null;
	}
	
	@Override
	public Number getHeight() {
		return ((Pane) myNode).getPrefHeight();
	}
	@Override
	public Number getWidth() {
		return ((Pane) myNode).getPrefWidth();
	}
	

}
