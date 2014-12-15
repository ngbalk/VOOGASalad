package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes;

import java.awt.image.BufferedImage;
import java.io.File;

import javafx.scene.control.Button;


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
