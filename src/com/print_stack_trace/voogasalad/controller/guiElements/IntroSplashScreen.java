package com.print_stack_trace.voogasalad.controller.guiElements;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.google.gson.JsonSyntaxException;
import com.print_stack_trace.voogasalad.controller.player.GamePlayer;
import com.print_stack_trace.voogasalad.model.engine.GameEngine;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class IntroSplashScreen extends Pane {
	
	protected Button loadButton = new Button("Continue");
	protected ImageView myBackground = new ImageView("./com/print_stack_trace/voogasalad/controller/images/SpriteImages/luigi.png");
	
	public IntroSplashScreen(int width, int height){
		this.getChildren().addAll(loadButton, myBackground);
		//root.getChildren().add(myBackground);
		//root.getChildren().add(this);
		this.setLayoutX(width/2);
		this.setLayoutY(height/2);
		System.out.println(this.getLayoutX());
	}
	
	public void continueFromSplashScreen(GamePlayer gamePlayer, Group root){
		loadButton.setOnAction(e -> addPlayerToolBarToNewRoot(root, gamePlayer));//GE.loadGame(selectLevelFile()));
	} 
	
	private void addPlayerToolBarToNewRoot(Group root, GamePlayer gamePlayer) {
		PlayerToolBar ptb = new PlayerToolBar(gamePlayer);
		root.getChildren().add(ptb);
		root.getChildren().remove(this);
	}
}