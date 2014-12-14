package com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.LevelObject;
import com.print_stack_trace.voogasalad.model.LevelCharacteristics;

public class ExtendDirection {
	private LevelObject myLevel;
	private LevelCharacteristics myLevelCharacteristics;
	private ViewObjectDelegate myGame;
	private Node myBackground;
	public ExtendDirection(LevelObject level, ViewObjectDelegate gamePane, Node background){
		myLevel=level;
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
			myGame.setProgramWidth(getWidth()
					* newHorizontalPaneCount);
			extend(newHorizontalPaneCount, currentVerticalPaneCount,
					(view, horizontal, vertical)->extendHorizontal(view, horizontal, vertical));
		}
	}
	
	public void extendDown(){
		if (!isLevelNull()){
			int newVerticalPaneCount=myLevelCharacteristics
					.incrementVerticalPaneCount();
			int currentHorizontalPaneCount = myLevelCharacteristics
					.getHorizontalPaneCount();
			myGame.setProgramHeight(this.getHeight()*
					newVerticalPaneCount);
			extend(currentHorizontalPaneCount, newVerticalPaneCount,
					(view, horizontal, vertical)->extendVertical(view, horizontal, vertical));
		}
	}
	
	public void extendUp() {//TODO: IMPLEMENT THIS
	}

	private void extendHorizontal(Node view, int horizontal, int vertical){
		view.relocate(getWidth()
				* (horizontal - 1),
				getHeight() * (vertical-1));
	}

	private void extendVertical(Node view, int horizontal, int vertical){
		view.relocate(getWidth()
				* (horizontal-1), getHeight()
				* (vertical - 1));
	}
	private void extend(int numToExtend, int notChanged, Extend toExtend){
		for (int i = 1; i <= numToExtend; i++) {
			Node copyView = duplicateBackgroundImage();
			toExtend.extend(copyView,i, notChanged);
			myGame.addBackground(copyView);
		}
	}
	
	private Node duplicateBackgroundImage(){
		if (myBackground instanceof ImageView){
			ImageView backgroundImageView = (ImageView)myBackground;
			ImageView backgroundImageViewCopy = new ImageView(
					backgroundImageView.getImage());
			backgroundImageViewCopy.setFitHeight(backgroundImageView
					.getFitHeight());
			backgroundImageViewCopy.setFitWidth(backgroundImageView
					.getFitWidth());
			backgroundImageViewCopy.setSmooth(true);
			return backgroundImageViewCopy;
		}
		Pane copyPane= new Pane();
		Pane toCopy=(Pane) myBackground;
		copyPane.setPrefSize(toCopy.getWidth(), toCopy.getHeight());
		copyPane.setStyle(toCopy.styleProperty().getValue());
		return copyPane;
	}
	private boolean isLevelNull(){
		return (myLevelCharacteristics!=null)? (myLevelCharacteristics.getBackgroundImagePath()==""):true;
	}
	
	private double getHeight(){
		return (myBackground instanceof ImageView)? ((ImageView)myBackground).getFitHeight(): 
			((Pane) myBackground).getPrefHeight();
	}

	private double getWidth(){
		return (myBackground instanceof ImageView)? ((ImageView)myBackground).getFitWidth()
			: ((Pane) myBackground).getPrefWidth();
	}
}
