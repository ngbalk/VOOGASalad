package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;

public abstract class AbstractSplashScreen extends Region {
		
	public AbstractSplashScreen(int width, int height, ImageView pic){
		pic.setX(0);
		pic.setY(0);
		pic.toBack();
	}
	
	public abstract void continueFromSplash(Object ...objects);
}
