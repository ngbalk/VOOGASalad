package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameObject {
	protected ImageView myImage;
	protected ViewObjectDelegate myDelegate;
	public GameObject(ImageView image){
		this(image, null);
	}
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
}
