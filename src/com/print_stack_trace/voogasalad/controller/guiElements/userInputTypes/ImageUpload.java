package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes;

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

import com.print_stack_trace.voogasalad.utilities.fileloading.FileLoadUtility;


public class ImageUpload extends Button {
	public ImageUpload(){
		super();
		setText("Upload Image");
	}
	public File doAction(){
		return FileLoadUtility.loadImageFile("./");
	}
}
