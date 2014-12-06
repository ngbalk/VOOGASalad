package com.print_stack_trace.voogasalad.controller.guiElements;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;


public class ImageUpload extends UserInputButton {
	public ImageUpload(){
		super();
		((Button) myNode).setText("Upload Image");
	}
	public File doAction(){
		Stage stage=new Stage();
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Select Image");
		fileChooser.setInitialDirectory(new File("./"));
		File file = fileChooser.showOpenDialog(stage);
		if(file != null&&(file.getName().toUpperCase().contains(".JPG")||file.getName().toUpperCase().contains(".PNG")||file.getName().toUpperCase().contains(".JPEG"))){
			return file;
		}
		return null;
	}
}
