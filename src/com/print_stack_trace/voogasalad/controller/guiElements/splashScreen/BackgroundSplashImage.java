package com.print_stack_trace.voogasalad.controller.guiElements.splashScreen;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BackgroundSplashImage extends SplashScreenObject {
	private ImageView myView;
	public BackgroundSplashImage(String source, double width, double height,
			Group group) {
		super(source, width, height, group);
		myView=new ImageView(new Image(source));
		setUpImage(width, height);	
	}
	
	private void setUpImage(double width, double height){
		myNode=myView;
		myView.setFitWidth(width);
		myView.setFitHeight(height);
		myView.setSmooth(true);
	}
	
	@Override
	public boolean update() {
		return false;
		
	}

	@Override
	public void addEnd(EventHandler event) {
		// TODO Auto-generated method stub
		
	}

}
