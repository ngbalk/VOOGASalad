package com.print_stack_trace.voogasalad.controller.guiElements;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.google.gson.JsonSyntaxException;
import com.print_stack_trace.voogasalad.model.engine.GameEngine;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class IntroSplashScreen extends AbstractSplashScreen {
	
	protected Button continueButton = new Button("Continue");
	private static final ImageView myBackground = new ImageView("./com/print_stack_trace/voogasalad/controller/images/marioBackground.jpg");
	private static final String propFileRoot = "./com/print_stack_trace/voogasalad/controller/guiResources/";
	
	public IntroSplashScreen( GameEngine GE, int width, int height){
		super(width, height, myBackground);
		this.getChildren().addAll(continueButton, myBackground);
		continueButton.toFront();    
		continueButton.setLayoutX(width/2);
		continueButton.setLayoutY(height/2);
	}
	
	private void continueFromSplashScreen(GameEngine GE, Group root){
		continueButton.setOnAction(e -> addPlayerToolBarToNewRoot(root, GE));//GE.loadGame(selectLevelFile()));
	}
	
	private void addPlayerToolBarToNewRoot(Group root, GameEngine GE) {
		PlayerToolBar ptb = new PlayerToolBar(GE);
		root.getChildren().add(ptb);
		root.getChildren().remove(this);
	}

	@Override
	public void continueFromSplash(Object... objects) {
		GameEngine GE = (GameEngine) objects[0];
		Group root = (Group) objects[1];
		continueFromSplashScreen(GE, root); 
	}
	
	

}