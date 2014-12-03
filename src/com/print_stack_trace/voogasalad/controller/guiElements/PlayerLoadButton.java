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

	public PlayerLoadButton(GameEngine gameEngine, GamePlayer gamePlayer) {
		super(gameEngine);
		// TODO Auto-generated constructor stub
	}


	@Override
	void doAction() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Load level");
		fileChooser.setInitialDirectory(new File(System.getProperty("user.dir") + "/src/com/print_stack_trace/voogasalad/model/data/"));

		Stage newStage=new Stage();
		File file = fileChooser.showOpenDialog(newStage);
		if (file != null) {
			try {
				FileInputStream myFile=new FileInputStream(file);
				myGameEngine.loadGame(myFile);
			} catch (IOException | JsonSyntaxException | ClassNotFoundException ex) {
				System.out.println(ex.getMessage());
			}
		}

	}
	
	
	
	

}
