package com.print_stack_trace.voogasalad;

import com.print_stack_trace.voogasalad.controller.ViewController;
import com.print_stack_trace.voogasalad.controller.player.GamePlayer;

public class PSTGamePlayer extends VOOGASalad {

	@Override
	public void main(String[] args) {
		launch(args);
	}

	@Override
	public ViewController getMainGUI() {
		return new GamePlayer();
	}
}
