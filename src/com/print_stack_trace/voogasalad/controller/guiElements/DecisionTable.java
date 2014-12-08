package com.print_stack_trace.voogasalad.controller.guiElements;

/**
 * Table to be used for collisions. Uses enumerations so no code needs to be added on frontend
 * 
 * @author danielmacdonald 
 */

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import com.print_stack_trace.voogasalad.model.engine.GameEngine;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionFactory;
import com.print_stack_trace.voogasalad.model.engine.physics.CollisionFactory.CollisionResult;

public class DecisionTable extends GridPane {
	private static final CollisionResult DEFAULT_COLLISION = CollisionFactory.CollisionResult.ObjectBothNoDisplacement;
	public static final int numClasses = GameAuthorEngine.SpriteType.values().length;
	public static final SpriteType[] types = GameAuthorEngine.SpriteType.values();
	public static final CollisionResult[] collisions = CollisionFactory.CollisionResult.values();  
	public static final int gapSize = 5;
	public static final int maxDimension = 1000;
	private int currentRowColCount;
	
	
	public DecisionTable(GameEngine engine){
		this.setHgap(gapSize*2);
		this.setVgap(gapSize);
		this.setMaxSize(maxDimension, maxDimension);
		currentRowColCount = numClasses;
		Button b = new Button("Add Type");
		this.add(b, 0, 0);
		b.setOnAction(e->promptForType());
		for(int i = 0; i<numClasses; i++){
			String s = types[i].toString()+"   ";
			this.add(new Text(s), i+1, 0);
			this.add(new Text(s), 0, i+1);
			for(int j=0; j<numClasses; j++){
				ComboBox<String> cb =  createPopulatedBox();
				int temp1= i+1; int temp2=j+1; //cannot use i and j because they are changing each iteration
				cb.setOnAction(e-> engine.setResultOfCollision(getValForObjectTypes(temp2,temp1)
						, types[temp1-1], types[temp2-1]));
				this.add(cb, i+1, j+1);
			} 
		} 
	}
	
	public CollisionResult getValForObjectTypes(int keyIndex, int valIndex){
		ComboBox cb = (ComboBox) getNodeByRowColumnIndex(keyIndex, valIndex, this);		
		String s = (String) cb.getValue();
		for(CollisionResult result : collisions){
			if(result.toString().equals(s)){
				return result;
			}
		}
		return DEFAULT_COLLISION;
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
		prompter.submitButton.setOnAction(e->addType(prompter.submit(), prompter));
	}
	
	private void addType(String s, TextDialogBox prompter){
		Text t = new Text(s);  
		Text t2 = new Text(s);
		currentRowColCount++;  
		this.add(t2, 0, currentRowColCount);
		this.add(t, currentRowColCount, 0);
		for(int i = 1; i<currentRowColCount;i++){
			this.add(createPopulatedBox(), currentRowColCount, i);
			this.add(createPopulatedBox(), i, currentRowColCount);
		}
		this.add(createPopulatedBox(), currentRowColCount, currentRowColCount);
		prompter.close();
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
