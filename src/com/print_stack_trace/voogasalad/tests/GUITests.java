package com.print_stack_trace.voogasalad.tests;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import org.junit.Test;

import com.print_stack_trace.voogasalad.controller.guiElements.SpriteLocationController;
import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;

public class GUITests {


	@Test
	public void testInputLabels(){
//		Group myRoot = new Group();
//		Stage myStage = new Stage();
//		myStage.setWidth(500);
//		myStage.setHeight(500);
//		Scene myScene = new Scene(myRoot, 500,500);
		ImageView testImageView = new ImageView();
		SpriteLocationController controller = new SpriteLocationController(testImageView, new SpriteCharacteristics(null));

		
	}
}
