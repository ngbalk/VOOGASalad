package com.print_stack_trace.voogasalad;

import java.awt.Dimension;

import com.print_stack_trace.voogasalad.controller.ViewController;
import com.print_stack_trace.voogasalad.controller.author.GameAuthor;

public class PSTGameAuthor extends VOOGASalad {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public ViewController getMainGUI() {
		return new GameAuthor(getWidth(), getHeight());
	}
}
