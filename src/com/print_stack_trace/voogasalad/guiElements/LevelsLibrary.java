package com.print_stack_trace.voogasalad.guiElements;

import java.util.HashSet;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class LevelsLibrary extends PictureLibrary{
	HashSet<ImageView> onGamePane=new HashSet<ImageView>();
	public LevelsLibrary(Number width, Number height, Pane otherPane) {
		super(width, height, otherPane);
		myResources="./com/print_stack_trace/voogasalad/guiResources/LevelImages.Properties";
		loadAndAddData();
	}
	
	@Override
	protected void addToOtherPane(Image myImage){
		myMainPane.getChildren().removeAll(onGamePane);
		DraggableItem copyNode=new DraggableItem((ImageView) makeImageView(myImage), myMainPane.getWidth(), myMainPane.getHeight());
		ImageView background=(ImageView)copyNode.getMyItem();
		background.setFitWidth(myMainPane.getWidth());
		background.setFitHeight(myMainPane.getHeight()-10);
		background.setFitWidth(myMainPane.getWidth()-10);
		background.setSmooth(true);
		background.setPreserveRatio(false);
		background.relocate(5, 5);
		myMainPane.getChildren().add(0, copyNode.getMyItem());
		onGamePane.add(background);
		
	}
}
