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
import com.print_stack_trace.voogasalad.model.engine.GameEngine;

public class PlayerLoadButton extends PlayerActionButton {

	public PlayerLoadButton(GameEngine gameEngine) {
		super(gameEngine);
		// TODO Auto-generated constructor stub
	}


	@Override
	void doAction() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Load level");
		Stage newStage=new Stage();
		File file = fileChooser.showSaveDialog(newStage);
		if (file != null) {
			try {
				FileInputStream myFile=new FileInputStream(file);
				myGameEngine.loadGame(new BufferedInputStream(myFile));
			} catch (IOException | JsonSyntaxException | ClassNotFoundException ex) {
				System.out.println(ex.getMessage());
			}
		}

	}

}
