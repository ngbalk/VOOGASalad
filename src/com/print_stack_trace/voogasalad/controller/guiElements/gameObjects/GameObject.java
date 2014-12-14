package com.print_stack_trace.voogasalad.controller.guiElements.gameObjects;

import com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor.GeneralPane;
import com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor.ViewObjectDelegate;
import com.print_stack_trace.voogasalad.model.environment.GoalFactory.GoalType;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public abstract class GameObject {
	protected ImageView myImage;
	protected String myImagePath;
	protected ViewObjectDelegate myDelegate;
	private boolean doubleclick = true;
	protected Pane myPane;
	protected int ID;

	public GameObject(String imagePath) {this(imagePath, null);}

	public GameObject(GoalType goal, ViewObjectDelegate delegate) {this("", delegate);}

	public GameObject(String imagePath, ViewObjectDelegate delegate) {
		myImagePath = imagePath;
		myDelegate = delegate;
		myImage= (!(imagePath.equals("") || imagePath.equals(null)))? 
				new ImageView(new Image(imagePath)) : new ImageView();
	}

	public int getID() {
		return ID;
	}

	public void setID(int id) {
		ID = id;
	}

	public ImageView getImage() {
		return myImage;
	}

	public void setImage(String imgPath) {
		myImage.setImage(new Image(imgPath));
		myImagePath = imgPath;
		setImageCharacteristics();
	}

	public String getImagePath() {
		return myImagePath;
	}

	public abstract void setImageCharacteristics();

	public ViewObjectDelegate getDelegate() {
		return myDelegate;
	}
	
	public void setDelegate(ViewObjectDelegate delegate){
		myDelegate=delegate;
	}
	
	protected abstract void update();
	public boolean isClicked() {
		doubleclick = !doubleclick;
		return doubleclick;
	}
	public void notClicked() {
		doubleclick = true;
	}

	public abstract void createPane();

	public void showPane() {
		if (isClicked()&&!((GeneralPane) myPane).isOpen())
			((GeneralPane) myPane).openPane();
	}
	
}
