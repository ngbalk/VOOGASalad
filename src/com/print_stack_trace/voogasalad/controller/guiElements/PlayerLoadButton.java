package com.print_stack_trace.voogasalad.controller.guiElements;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import com.google.gson.JsonSyntaxException;
import com.print_stack_trace.voogasalad.controller.player.GamePlayer;
import com.print_stack_trace.voogasalad.model.engine.GameEngine;

public class PlayerLoadButton extends PlayerActionButton {

	public PlayerLoadButton(GamePlayer gamePlayer) {
		super(gamePlayer);
		// TODO Auto-generated constructor stub
	}


	@Override
	void doAction() {
		myGamePlayer.loadGame();
	}
	
	
	
	

}
