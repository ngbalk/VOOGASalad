package com.print_stack_trace.voogasalad;

import com.print_stack_trace.voogasalad.controller.GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VOOGASalad extends Application {
	private static final int WIDTH = 58*20;
	private static final int HEIGHT = 58*11;

	@Override
	public void start(Stage arg0) throws Exception {
		Scene scene = GUI.init(WIDTH, HEIGHT);
		arg0.setScene(scene);
		arg0.show();
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
