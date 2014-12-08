package com.print_stack_trace.voogasalad.controller.guiElements;

import java.util.HashMap;

import javafx.event.EventHandler;

public class AuthorSplashScreen extends AbstractUserSplashScreen{
	private static ResourceReader myReader=new ResourceReader("./com/print_stack_trace/voogasalad/"
			+ "controller/guiResources/AuthorSplashScreenImages.Properties");
	private static HashMap<String, String> data=myReader.getProperties();
	public AuthorSplashScreen(HashMap<String, String>resource, Number width, Number height, EventHandler event){
		super(data, width, height, event);
	}
	public AuthorSplashScreen(HashMap<String, String> resource, Number width, Number height) {
		super(data, width, height);
	}
	


}
