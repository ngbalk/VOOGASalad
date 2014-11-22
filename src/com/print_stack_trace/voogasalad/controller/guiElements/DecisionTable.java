package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionFactory.CollisionResult;
import com.print_stack_trace.voogasalad.model.engine.physics.PhysicsEngine;
public class DecisionTable extends GridPane {
	public static final int numClasses = GameAuthorEngine.SpriteType.values().length;
	public static final SpriteType[] types = GameAuthorEngine.SpriteType.values();
	public static final CollisionResult[] collisions = PhysicsEngine.CollisionResult.values();  
	public static final int gapSize = 5;
	private int currentRowColCount;
	
	public DecisionTable(){
		this.setHgap(gapSize*2);
		this.setVgap(gapSize);
		currentRowColCount = numClasses;
		Button b = new Button("Add Type");
		this.add(b, 0, 0);
		b.setOnAction(e->promptForType());//this.addType("fdfs"));
		for(int i = 0; i<numClasses; i++){
			String s = types[i].toString()+"   ";
			Text t = new Text(s); 
			Text t2 = new Text(s); //have to have this to avoid adding duplicate children
			this.add(t, i+1, 0);
			this.add(t2, 0, i+1);
			for(int j=0; j<numClasses; j++){
				ComboBox<String> cb =  createPopulatedBox();
				int temp1= i+1; int temp2=j+1;
				cb.setOnAction(e-> getValForObjectTypes(temp2,temp1)); 
				this.add(cb, i+1, j+1);
			} 
		} 
	}
	
	public String getValForObjectTypes(int keyIndex, int valIndex){
		ComboBox cb = (ComboBox) getNodeByRowColumnIndex(keyIndex, valIndex, this);		
		String s = (String) cb.getValue();
		System.out.println(s);
		return s;
	}
	
	//from http://stackoverflow.com/questions/20825935/javafx-get-node-by-row-and-column
	//will look for better code to replace this with
	private Node getNodeByRowColumnIndex(final int row,final int column,GridPane gridPane) {
		Node result = null;
		ObservableList<Node> childrens = gridPane.getChildren();
		for(Node node : childrens) {
			if(gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
				result = node;
				break;
			}
		}
		return result;
	}
	
	public void promptForType(){
		TextDialogBox prompter = new TextDialogBox(new TextField());
		prompter.submitButton.setOnAction(e->addType(prompter.submit()));
	}
	
	private void addType(String s){
		Text t = new Text(s);  
		Text t2 = new Text(s);
		currentRowColCount++;  
		this.add(t2, 0, currentRowColCount);
		this.add(t, currentRowColCount, 0);
		for(int i = 1; i<currentRowColCount;i++){
			ComboBox<String> cb = createPopulatedBox();
			this.add(cb, currentRowColCount, i);
		}
		for(int i = 1; i<currentRowColCount+1;i++){
			ComboBox<String> cb = createPopulatedBox();
			this.add(cb, i, currentRowColCount);
		}
	}
	
	private ComboBox<String> createPopulatedBox(){
		ComboBox<String> cb = new ComboBox<String>();
		String[] collisionStrings = new String[collisions.length];
		for(int i=0; i <collisions.length; i++){
			collisionStrings[i] = collisions[i].toString();
		}
		cb.getItems().addAll(collisionStrings);
		return cb;
	}
}
