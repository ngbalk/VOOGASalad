package com.print_stack_trace.voogasalad.controller.guiElements.buttons;

import com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor.DecisionTable;

import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DecisionTableButton extends Button {
	private static final int maxDimensionSize = 10000;
	private static final int dimension = 600;
	private static final int barOffset = 30;
	public static final String text = "Edit Collision Table";
	
	public DecisionTableButton(DecisionTable table){
		this.setText(text);
		this.setOnAction(event->showTable(table));
	}

	private void showTable(DecisionTable dt) {
		Stage stage = new Stage();
		stage.setWidth(dimension);
		stage.setHeight(dimension); 
		stage.setResizable(false);
		stage.initStyle(StageStyle.UTILITY);
		Group root = new Group(); 
		ScrollPane sp = new ScrollPane();
		sp.setContent(dt);
		sp.setPannable(true);
		sp.setMaxHeight(maxDimensionSize); 
		sp.setMaxWidth(maxDimensionSize); 
		sp.setPrefSize(dimension-barOffset, dimension-barOffset); 
		sp.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		sp.setHbarPolicy(ScrollBarPolicy.ALWAYS);
		Scene s = new Scene(root);
		root.getChildren().add(sp);
		stage.setScene(s);  
		stage.show();
		return;
	}
}
