package com.print_stack_trace.voogasalad.controller.guiElements;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import com.print_stack_trace.voogasalad.model.engine.GameEngine;

public class PlayerSaveButton extends PlayerActionButton {

	public PlayerSaveButton(GameEngine gameEngine) {
		super(gameEngine);
		// TODO Auto-generated constructor stub
	}

	@Override
	void doAction() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save Level");
		Stage newStage=new Stage();
		File file = fileChooser.showSaveDialog(newStage);
		if (file != null) {
			try {
				FileOutputStream myFile=new FileOutputStream(file);
				myGameEngine.saveGame();
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
	
	}

}
