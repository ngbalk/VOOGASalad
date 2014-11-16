package com.print_stack_trace.voogasalad.guiElements;

import com.print_stack_trace.voogasalad.controller.TabController;
import com.print_stack_trace.voogasalad.controller.ViewController;

import com.print_stack_trace.voogasalad.controller.author.GameAuthor;
import com.print_stack_trace.voogasalad.model.engine.GameEngine;

import javafx.scene.Group;
import javafx.scene.Node;

public class GreenGUI extends AbstractGUI implements ViewController{
	private double myWidth;
	private double myHeight;
	private GameEngine myGameEngine;
	public GreenGUI(double width, double height){
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
		myGameEngine = gameEngine;
		Group root = new Group();
		root.getChildren().add(this);
		return root;
	}

	

}