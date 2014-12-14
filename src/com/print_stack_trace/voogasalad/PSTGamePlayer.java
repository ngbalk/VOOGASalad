package com.print_stack_trace.voogasalad;

import javafx.stage.Stage;
import com.print_stack_trace.voogasalad.controller.ViewController;
import com.print_stack_trace.voogasalad.controller.player.GamePlayer;
import com.print_stack_trace.voogasalad.model.engine.GameEngine;

public class PSTGamePlayer extends VOOGASalad {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public ViewController getMainGUI(Stage s) {
		GamePlayer gp = new GamePlayer();
		gp.mainStage = s;
	        return gp;
	}
}
