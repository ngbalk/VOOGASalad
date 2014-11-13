package com.print_stack_trace.voogasalad;

import com.print_stack_trace.voogasalad.controller.ViewController;
import com.print_stack_trace.voogasalad.controller.author.GameAuthor;
import com.print_stack_trace.voogasalad.guiElements.GreenGUI;

public class PSTGameAuthor extends VOOGASalad {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public ViewController getMainGUI() {
		return new GameAuthor(getWidth(), getHeight());
	}
}
