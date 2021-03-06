
package com.print_stack_trace.voogasalad.controller.guiElements.layout;
import com.print_stack_trace.voogasalad.controller.ViewController;

import javafx.scene.Node;

public class GreenGUI extends AbstractGUI implements ViewController{
	public GreenGUI(double width, double height){
		super(width, height);
		myStyle="./com/print_stack_trace/voogasalad/controller/guiResources/SpritePane.css";
		this.getStylesheets().add(myStyle);
		setLeft(null);
		this.setBorderStyle(this);
	}
	protected void setStyle(Node myPane){
		myPane.setStyle("-fx-background-color: BLACK");
	}
	protected void setBorderStyle(Node myPane){
		myPane.setStyle("-fx-border-color: BLACK; -fx-border-width: 2");
	}
	protected void setBorderAndBackgroundStyle(Node myPane){
		myPane.setStyle("-fx-background-color: BLACK; -fx-border-color: #0099CC; -fx-border-width: 2");
	}
	protected String getStyleSheet(){
		return myStyle;
	}
}