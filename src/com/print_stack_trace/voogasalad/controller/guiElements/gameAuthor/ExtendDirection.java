package com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.LevelObject;
import com.print_stack_trace.voogasalad.model.LevelCharacteristics;

public class ExtendDirection {
	private LevelCharacteristics myLevelCharacteristics;
	private ViewObjectDelegate myGame;
	private ImageView myBackground;
	public ExtendDirection(LevelObject level, ViewObjectDelegate gamePane, ImageView background){
		myLevelCharacteristics=(level!=null)? level.getCharacteristics(): null;
		myBackground=background;
		myGame=gamePane;
	}
	public void extendRight(){
		if (!isLevelNull()){
			int newHorizontalPaneCount = myLevelCharacteristics
					.incrementHorizontalPaneCount();
			int currentVerticalPaneCount = myLevelCharacteristics
					.getVerticalPaneCount();
			myGame.setProgramWidth(myBackground.getFitWidth()
					* newHorizontalPaneCount);
			extend(newHorizontalPaneCount, currentVerticalPaneCount,
					(view, horizontal, vertical)->extendHorizontal(view, horizontal, vertical));
		}
	}
	public void extendDown(){
		if (!isLevelNull()){
			int newVerticalPaneCount =myLevelCharacteristics
					.incrementVerticalPaneCount();
			int currentHorizontalPaneCount = myLevelCharacteristics
					.getHorizontalPaneCount();
			myGame.setProgramHeight(myBackground.getFitHeight()
					* newVerticalPaneCount);
			extend(currentHorizontalPaneCount, newVerticalPaneCount,
					(view, horizontal, vertical)->extendVertical(view, horizontal, vertical));
		}
	}

	private void extendHorizontal(Node view, int horizontal, int vertical){
		view.relocate(((ImageView) view).getFitWidth()
				* (horizontal - 1),
				((ImageView) view).getFitHeight() * (vertical-1));
	}
	private void extendVertical(Node view, int horizontal, int vertical){
		view.relocate(((ImageView) view).getFitWidth()
				* (horizontal-1), ((ImageView) view).getFitHeight()
				* (vertical - 1));
	}

	private void extend(int numToExtend, int notChanged, Extend toExtend){
		myGame.setProgramHeight(myBackground.getFitHeight()
				* notChanged);
		for (int i = 1; i <= numToExtend; i++) {
			ImageView copyView = duplicateBackgroundImage();
			toExtend.extend(copyView,i, notChanged);
			myGame.addBackground(copyView);
		}
	}

	private ImageView duplicateBackgroundImage(){
		ImageView backgroundImageView = myBackground;
		ImageView backgroundImageViewCopy = new ImageView(
				backgroundImageView.getImage());
		backgroundImageViewCopy.setFitHeight(backgroundImageView
				.getFitHeight());
		backgroundImageViewCopy.setFitWidth(backgroundImageView
				.getFitWidth());
		backgroundImageViewCopy.setSmooth(true);
		return backgroundImageViewCopy;
	}
	private boolean isLevelNull(){
		return (myLevelCharacteristics!=null)? (myLevelCharacteristics.getBackgroundImagePath()==""):true;
	}

}
