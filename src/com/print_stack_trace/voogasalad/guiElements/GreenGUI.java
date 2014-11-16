package com.print_stack_trace.voogasalad.guiElements;

import com.print_stack_trace.voogasalad.controller.author.GameAuthor;
import com.print_stack_trace.voogasalad.model.engine.GameEngine;
import javafx.scene.Group;
import javafx.scene.Node;

public class GreenGUI extends AbstractGUI {
	private double myWidth;
	private double myHeight;
	public GreenGUI(Number width, Number height){
		super(width, height);
		setLeft(null);
		this.setBorderStyle(this);
	}
	
	protected void setStyle(Node myPane){
		myPane.setStyle("-fx-background-color: BLACK");

	}
	protected void setBorderStyle(Node myPane){
		myPane.setStyle("-fx-border-color: BLACK; -fx-border-width: 5");
	}
	protected void setBorderAndBackgroundStyle(Node myPane){
		myPane.setStyle("-fx-background-color: BLACK; -fx-border-color: #0099CC; -fx-border-width: 5");
	}


	public Group initialize(GameEngine gameEngine) {
		Group myGroup=new Group();
		myGroup.getChildren().add(this);
		return new Group(myGroup);
	}

	

}