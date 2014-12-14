package com.print_stack_trace.voogasalad.controller.guiElements.buttons;

import javafx.scene.control.TextField;

import com.print_stack_trace.voogasalad.controller.ViewController;
import com.print_stack_trace.voogasalad.controller.guiElements.resourceReader.TextDialogBox;
import com.print_stack_trace.voogasalad.controller.player.GamePlayer;
import com.print_stack_trace.voogasalad.utilities.twillio.PSTTwillioCore;
import com.print_stack_trace.voogasalad.utilities.twillio.PSTTwillioException;

public class PlayerShareButton extends PlayerActionButton {
	private static final String SHARE_MESSAGE = "Hey come play Print Stack Trace with your friend!";
	private static final String SHARE_SUCCESS_MESSAGE = "Message sent! Tell your friend to check his phone.";
	private static final String SHARE_FAIL_MESSAGE = "Whoops there was an error sending to that number.";
	private TextDialogBox prompt;

	public PlayerShareButton(GamePlayer gamePlayer) {
		super(gamePlayer);
		
	}
	
	@Override
	void doAction() {
		prompt = new TextDialogBox(new TextField());
		prompt.getSubmitButton().setOnAction(e->sendTextTo(prompt.submit()));
	}
	
	void sendTextTo(String result) {
		String resultMsg;
		try {
			int response = PSTTwillioCore.sendText(result, SHARE_MESSAGE);
			prompt.close();
			resultMsg = (response == 201) ? SHARE_SUCCESS_MESSAGE : SHARE_FAIL_MESSAGE;
		} catch (PSTTwillioException e) {
			resultMsg = e.getMessage();
		}
		ViewController.displayError(resultMsg);
	}

}
