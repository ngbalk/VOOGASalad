package com.print_stack_trace.voogasalad.controller.guiElements;

import com.print_stack_trace.voogasalad.model.environment.GoalFactory.GoalType;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public abstract class GameObject  {
	protected ImageView myImage;
	protected String myImagePath;
	protected ViewObjectDelegate myDelegate;
	private boolean doubleclick=true;
	protected Pane myPane;
	public GameObject(ImageView image, String imagePath){
		this(image, imagePath, null);
	}
	public GameObject (GoalType goal){};
	public GameObject(ImageView image, String imagePath, ViewObjectDelegate delegate){
		myImage=image;
		myImagePath=imagePath;
		myDelegate=delegate;
	}
	
	public ImageView getImage(){
		return myImage;
	}
	
	public void setImage(Image img){
		myImage.setImage(img);
	}
	public void setImagePath(String imagePath){
		myImagePath = imagePath;
	}
	public String getImagePath(){
		return myImagePath;
	}
	public ViewObjectDelegate getDelegate(){
		return myDelegate;
	}
	protected abstract void update();
	public boolean isClicked(){
		doubleclick=(doubleclick)? false:true;
		return doubleclick;
	}
	public void notClicked(){
		doubleclick=true;
	}
	public abstract void createPane();
	public void showPane(){
		if (isClicked()&& !((GeneralPane) myPane).isOpen()){
			((GeneralPane) myPane).openPane();
		}
	}
}
