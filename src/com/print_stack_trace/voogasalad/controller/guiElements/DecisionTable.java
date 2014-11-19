package com.print_stack_trace.voogasalad.controller.guiElements;

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
				this.add(new ComboBox(), i+1, j+1);
			} 
		}
		
	}
}
