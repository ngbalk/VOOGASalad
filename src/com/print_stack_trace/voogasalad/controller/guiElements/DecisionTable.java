package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;

public class DecisionTable extends GridPane {
	public static final int numClasses = GameAuthorEngine.SpriteType.values().length;
	public static final SpriteType[] types = GameAuthorEngine.SpriteType.values();
	public static final int gapSize = 5;
	
	public DecisionTable(){
		this.setHgap(gapSize*2);
		this.setVgap(gapSize);
		for(int i = 0; i<numClasses; i++){
			String s = types[i].toString()+"   ";
			Text t = new Text(s);
			Text t2 = new Text(s); //have to have this to avoid adding duplicate children
			this.add(t, i+1, 0);
			this.add(t2, 0, i+1);
			for(int j=0; j<numClasses; j++){
				ComboBox<String> cb = new ComboBox<String>();
				cb.getItems().add("test string");
				cb.setOnAction(e-> getValForObjectTypes());
				this.add(cb, i+1, j+1);
			} 
		}
	}
	
	public String getValForObjectTypes(){
		int keyIndex = 2;
		int valIndex = 3;
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
}
