package com.print_stack_trace.voogasalad.controller.guiElements;

import java.util.Map;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import com.print_stack_trace.voogasalad.controller.player.GamePlayer;
import com.print_stack_trace.voogasalad.model.data.HighScore;
import com.print_stack_trace.voogasalad.model.engine.GameEngine;

public class PlayerShowHighScoresButton extends PlayerActionButton {

	public PlayerShowHighScoresButton(GamePlayer gamePlayer) {
		super(gamePlayer);
		// TODO Auto-generated constructor stub
	}

	@Override
	void doAction() {
		myGamePlayer.showHighScores();
	}

}
