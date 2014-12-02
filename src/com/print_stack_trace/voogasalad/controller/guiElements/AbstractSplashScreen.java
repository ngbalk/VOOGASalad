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
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class AbstractSplashScreen extends VBox {
	
	protected Button loadButton = new Button("Load Game");
	protected Button scoreButton = new Button("View High Scores");
	protected ImageView myBackground = new ImageView("./com/print_stack_trace/voogasalad/controller/images/SpriteImages/luigi.png");
	
	public AbstractSplashScreen(Group root, GameEngine GE, int width, int height){
		this.getChildren().addAll(loadButton, scoreButton, myBackground);
		//root.getChildren().add(myBackground);
		root.getChildren().add(this);
		this.setLayoutX(width/2);
		this.setLayoutY(height/2);
		loadButton.setOnAction(e -> selectLevelFile());//GE.loadGame(selectLevelFile()));
		System.out.println(this.getLayoutX());
	}
	
	//
	//remove this from GamePlayer once this is implemented
	private File selectLevelFile() {
		FileChooser fc = new FileChooser();
		File file = fc.showOpenDialog(new Stage()); 		
		return file; 
	}
	
	private BufferedInputStream loadFromFile(){
		File file = selectLevelFile();
		BufferedInputStream fileStream = null;
		try {
			fileStream = new BufferedInputStream(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			// TODO DISPLAY ERROR HERE
			e.printStackTrace();
		}
		
		return fileStream;
	}
}
