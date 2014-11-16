package com.print_stack_trace.voogasalad.guiElements;
import com.print_stack_trace.voogasalad.controller.TabController;
import com.print_stack_trace.voogasalad.controller.ViewController;
import com.print_stack_trace.voogasalad.controller.author.GameAuthor;
import com.print_stack_trace.voogasalad.model.engine.GameEngine;

import javafx.scene.Group;
import javafx.scene.Node;
/**
 * 
 * PETRA! WE ARE NO LONGER USING THIS CLASS, MAKE CHANGES IN GAMEAUTHOR.JAVA!!!
 *
 */
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
		myPane.setStyle("-fx-background-color: BLACK; -fx-border-color: #00ced1; -fx-border-width: 5");
	}

	@Override
	public Group initialize(GameEngine gameEngine) {
		myGameEngine = gameEngine;
		Group myGroup = new Group();
		myGroup.getChildren().add(this);
		return myGroup;
	}

}