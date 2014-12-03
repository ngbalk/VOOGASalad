package com.print_stack_trace.voogasalad.controller.guiElements;

import com.print_stack_trace.voogasalad.controller.player.GamePlayer;
import com.print_stack_trace.voogasalad.model.engine.GameEngine;

public class PlayerPauseButton extends PlayerActionButton {

	public PlayerPauseButton(GamePlayer gamePlayer) {
		super(gamePlayer);
	}

	@Override
	void doAction() {
		myGamePlayer.pauseGame();

	}

}
