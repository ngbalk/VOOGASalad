package com.print_stack_trace.voogasalad.controller.guiElements.libraries;

import java.util.HashSet;

import com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor.GamePane;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class LevelsLibrary extends PictureLibrary{
	HashSet<ImageView> onGamePane=new HashSet<ImageView>();
	public LevelsLibrary(Number width, Number height, Pane otherPane) {
		super(width, height, otherPane);
		myResources="./com/print_stack_trace/voogasalad/controller/guiResources/LevelImages.Properties";
		loadAndAddData();
	}

	@Override
	protected void addToOtherPane(Image image, String imagePath){
		if (((GamePane)myMainPane).isReady()){
			myMainPane.getChildren().removeAll(onGamePane);
			ImageView imageView=(ImageView) makeImageView(image);
			((GamePane) myMainPane).addBackground(imageView, imagePath);
			onGamePane.add(imageView);
		}	
	}
}
