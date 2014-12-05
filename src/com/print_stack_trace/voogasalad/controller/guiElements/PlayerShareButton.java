package com.print_stack_trace.voogasalad.controller.guiElements;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.TextField;

import com.print_stack_trace.voogasalad.controller.ViewController;
import com.print_stack_trace.voogasalad.controller.player.GamePlayer;
import com.print_stack_trace.voogasalad.utilities.PSTTwillioCore;
import com.print_stack_trace.voogasalad.utilities.PSTTwillioException;

public class PlayerShareButton extends PlayerActionButton {
	private final String SHARE_MESSAGE = "Hey come play Print Stack Trace with your friend!";
	private TextDialogBox prompt;

	public PlayerShareButton(GamePlayer gamePlayer) {
		super(gamePlayer);
		
	}
	
	@Override
	void doAction() {
		prompt = new TextDialogBox(new TextField());
		prompt.submitButton.setOnAction(e->sendTextTo(prompt.submit()));
	}
	
	void sendTextTo(String result) {
		try {
			PSTTwillioCore.sendText(result, SHARE_MESSAGE);
			prompt.close();
		} catch (PSTTwillioException e) {
			ViewController.displayError(e.getMessage());
		}
	}

}
