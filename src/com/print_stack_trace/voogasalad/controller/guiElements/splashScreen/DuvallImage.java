package com.print_stack_trace.voogasalad.controller.guiElements.splashScreen;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DuvallImage extends SplashScreenObject{
	private ImageView myImageView;
	public DuvallImage(String source, double width, double height, Group group) {
		super(source, width, height, group);
		myNode=new ImageView(new Image(source));
		myImageView=(ImageView) myNode;
	}

	@Override
	public boolean update() {
		int speed=1;
		if(myImageView.getFitWidth()<=300){
			myImageView.setVisible(true);
			myImageView.setFitHeight(myImageView.getFitHeight()+speed);
			myImageView.relocate(myWidth/2-myImageView.getFitWidth()/2, myHeight/2-myImageView.getFitHeight()/2);
			myImageView.setFitWidth(myImageView.getFitWidth()+speed);
			myImageView.setRotate(myImageView.getRotate()+speed);
		}
		else if (myImageView.getRotate()<=360){
			myImageView.setRotate(myImageView.getRotate()+speed);
		}
		
		return (myImageView.getFitHeight()<=300||myImageView.getRotate()<=300);
	}

	@Override
	public void addEnd(EventHandler event) {
		Button startButton=new Button("Start");
		startButton.relocate(myWidth-200, myHeight-300);
		startButton.setPrefSize(100, 100);
		startButton.setOnAction(event);
		startButton.getStylesheets().add(myStyle);
		root.getChildren().add(startButton);

	}
}
