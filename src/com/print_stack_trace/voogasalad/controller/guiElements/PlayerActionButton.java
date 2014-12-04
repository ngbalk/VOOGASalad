package com.print_stack_trace.voogasalad.controller.guiElements;

import com.print_stack_trace.voogasalad.controller.player.GamePlayer;
import com.print_stack_trace.voogasalad.model.engine.GameEngine;

import javafx.scene.Node;
import javafx.scene.control.Button;

abstract public class PlayerActionButton extends Button {
	GamePlayer myGamePlayer;
	public PlayerActionButton(GamePlayer gamePlayer) {
		myGamePlayer = gamePlayer;
		this.setOnAction(e -> doAction());
	}

	abstract void doAction();
	public void setLabel(String label){
		this.setText(label);
	}


}
