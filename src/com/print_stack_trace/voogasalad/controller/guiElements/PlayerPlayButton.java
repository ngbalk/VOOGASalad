package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.scene.image.ImageView;

import com.print_stack_trace.voogasalad.controller.player.GamePlayer;
import com.print_stack_trace.voogasalad.model.engine.GameEngine;

public class PlayerPlayButton extends PlayerActionButton {

    public PlayerPlayButton(GamePlayer gamePlayer) {
        super(gamePlayer);
    }

    @Override
    void doAction() {
        myGamePlayer.startNewGame();
        myGamePlayer.resumeGame();
    }

}
