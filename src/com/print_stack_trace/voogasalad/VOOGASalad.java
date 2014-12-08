package com.print_stack_trace.voogasalad;

import java.awt.Dimension;

import com.print_stack_trace.voogasalad.controller.ViewController;
import com.print_stack_trace.voogasalad.controller.guiElements.AbstractSplashScreen;
import com.print_stack_trace.voogasalad.controller.guiElements.AuthorSplashScreen;
import com.print_stack_trace.voogasalad.controller.guiElements.GameAuthorSplashScreen;
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
		
		GameEngine gameEngine = new GameEngine(new Dimension((int)getWidth(), (int)getHeight()));
		ViewController authorGUI = getMainGUI();
		Scene scene = new Scene(authorGUI.initialize(gameEngine), getWidth(), getHeight());
		AuthorSplashScreen mySplashScreen=new AuthorSplashScreen(null, getWidth(), getHeight(), e->start(scene));
		mainStage.setScene(mySplashScreen.getScene());
		mainStage.show();
	}
	
	public abstract ViewController getMainGUI();
	
	public double getWidth() {
		return DEFAULT_WIDTH;
	}
	
	public double getHeight() {
		return DEFAULT_HEIGHT;
	}
	private void start(Scene scene){
		mainStage.setScene(scene);
	}
}
