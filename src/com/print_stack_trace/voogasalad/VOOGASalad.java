package com.print_stack_trace.voogasalad;

import com.print_stack_trace.voogasalad.controller.ViewController;
import com.print_stack_trace.voogasalad.model.engine.GameEngine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class VOOGASalad extends Application {
	public static final int DEFAULT_WIDTH = 58*20; //Default Width is 58*20
	public static final int DEFAULT_HEIGHT = 58*11; //Default Height is 58*20
	protected Stage mainStage;

	@Override
	public void start(Stage arg0) throws Exception {
		mainStage = arg0;
		GameEngine gameEngine = new GameEngine();
		ViewController authorGUI = getMainGUI();
		Scene scene = new Scene(authorGUI.initialize(gameEngine), getWidth(), getHeight());
		mainStage.setScene(scene);
		mainStage.show();
	}
	
	public abstract ViewController getMainGUI();
	
	public double getWidth() {
		return DEFAULT_WIDTH;
	}
	
	public double getHeight() {
		return DEFAULT_HEIGHT;
	}
}
