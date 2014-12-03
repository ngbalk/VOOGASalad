package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.scene.image.ImageView;

import com.print_stack_trace.voogasalad.controller.player.GamePlayer;
import com.print_stack_trace.voogasalad.model.engine.GameEngine;

public class PlayerPlayButton extends PlayerActionButton {

	public PlayerPlayButton(GameEngine gameEngine, GamePlayer gamePlayer) {
		super(gameEngine, gamePlayer);
		// TODO Auto-generated constructor stub
	}

	@Override
	void doAction() {
		myGamePlayer.updateScene(myGameEngine.getSpriteCharacteristics(), myGameEngine.getLevelCharacteristics());

	}

}
