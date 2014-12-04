package com.print_stack_trace.voogasalad.controller.guiElements;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import com.print_stack_trace.voogasalad.controller.player.GamePlayer;
import com.print_stack_trace.voogasalad.model.engine.GameEngine;

public class PlayerSaveButton extends PlayerActionButton {

	public PlayerSaveButton(GamePlayer gamePlayer) {
		super(gamePlayer);
	}

	@Override
	void doAction() {
		myGamePlayer.saveGame();
	
	}

}
