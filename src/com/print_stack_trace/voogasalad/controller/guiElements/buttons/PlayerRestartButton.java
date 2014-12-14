package com.print_stack_trace.voogasalad.controller.guiElements.buttons;

import com.print_stack_trace.voogasalad.controller.player.GamePlayer;

public class PlayerRestartButton extends PlayerActionButton{

	public PlayerRestartButton(GamePlayer gamePlayer) {
		super(gamePlayer);
	}

	@Override
	void doAction() {
		// TODO Auto-generated method stub
		this.myGamePlayer.restartCurrentLevel();
	}
	

}
