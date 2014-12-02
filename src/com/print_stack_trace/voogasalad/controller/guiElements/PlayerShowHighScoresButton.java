package com.print_stack_trace.voogasalad.controller.guiElements;

import java.util.Map;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import com.print_stack_trace.voogasalad.model.data.HighScore;
import com.print_stack_trace.voogasalad.model.engine.GameEngine;

public class PlayerShowHighScoresButton extends PlayerActionButton {

	public PlayerShowHighScoresButton(GameEngine gameEngine) {
		super(gameEngine);
		// TODO Auto-generated constructor stub
	}

	@Override
	void doAction() {
		Map<String, HighScore> scores = myGameEngine.getHighScoreList();
		Group root = new Group();
		Scene scene = new Scene(root);
		Stage dialog = new Stage();
		dialog.setScene(scene);
		dialog.initModality(Modality.WINDOW_MODAL);
		VBox scoresVBox = new VBox();
		for(HighScore score : scores.values()){
			System.out.println(score.getPlayerName() + ":" + score.getMyScore());
			scoresVBox.getChildren().add(new Text(score.getPlayerName() + ":" + score.getMyScore()));
		}
		root.getChildren().add(scoresVBox);
		dialog.show();
	}

}
