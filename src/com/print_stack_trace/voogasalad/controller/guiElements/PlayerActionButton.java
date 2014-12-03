package com.print_stack_trace.voogasalad.controller.guiElements;

import com.print_stack_trace.voogasalad.model.engine.GameEngine;

import javafx.scene.Node;
import javafx.scene.control.Button;

abstract public class PlayerActionButton extends Button {
	GameEngine myGameEngine;
	public PlayerActionButton(GameEngine gameEngine) {
		myGameEngine = gameEngine;
		this.setOnAction(e -> doAction());
	}
	abstract void doAction();
	public void setLabel(String label){
		this.setText(label);
	}


}
