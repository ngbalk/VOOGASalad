package com.print_stack_trace.voogasalad.controller.guiElements;

import com.print_stack_trace.voogasalad.model.environment.GoalFactory.GoalType;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public abstract class GameObject  {
	protected ImageView myImage;
	protected ViewObjectDelegate myDelegate;
	private boolean doubleclick=true;
	protected Pane myPane;
	public GameObject(ImageView image){
		this(image, null);
	}
	public GameObject (GoalType goal){};
	public GameObject(ImageView image, ViewObjectDelegate delegate){
		myImage=image;
		myDelegate=delegate;
	}
	
	public ImageView getImage(){
		return myImage;	
	}
	public void setImage(Image img){
		myImage.setImage(img);
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
		System.out.println("SHOW");
		if (isClicked()&& !((GeneralPane) myPane).isOpen()){
			((GeneralPane) myPane).openPane();
		}
	}
}
