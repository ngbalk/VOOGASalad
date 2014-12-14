package com.print_stack_trace.voogasalad.controller.guiElements.splashScreen;

import java.util.HashMap;

import com.print_stack_trace.voogasalad.controller.guiElements.resourceReader.ResourceReader;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class GameAuthorSplashScreen {
	private Group myGroup=new Group();
	private Timeline myTimeline=new Timeline();
	private int DEFAULT_FPS=4;
	private ResourceReader myResourceReader=new ResourceReader("./com/print_stack_trace/voogasalad/"
			+ "controller/guiResources/AuthorSplashScreenImages.Properties");
	private String myStyle="./com/print_stack_trace/voogasalad/"
			+ "controller/guiResources/SplashPane.css";
	private HashMap<String, String> myData;
	private Scene myScene;
	private HashMap<String, Node> myImages=new HashMap<String, Node>();
	private EventHandler myEvent;
	public GameAuthorSplashScreen(Number width, Number height){
		this.initialize(width.doubleValue(), height.doubleValue());
		myTimeline.setCycleCount(Timeline.INDEFINITE);
		KeyFrame myKeyFrame=new KeyFrame(Duration.millis(1000/DEFAULT_FPS), e->update());
		myTimeline.getKeyFrames().add(myKeyFrame);
		myData=myResourceReader.getProperties();
		myGroup.getChildren().add(getBackground());
		myEvent=null;
		myGroup.getStylesheets().add(myStyle);
		
	}
	public GameAuthorSplashScreen(Number width, Number height, EventHandler event){
		this(width, height);
		myEvent=event;
		myTimeline.play();
		myGroup.getChildren().add(getCenter());
		myGroup.getChildren().add(getBottomLabel("PRINT_STACK_TRACE"));
		myGroup.getChildren().add(getTopLabel("CREATE YOUR OWN GAME"));
	}
	public Scene getScene(){
		return myScene;
	}
	public Scene  initialize(double width, double height){
		myScene=new Scene(myGroup,width, height);
		return myScene;	
	}
	private Node getCenter(){
		ImageView myBackground=new ImageView(new Image(myData.get("center")));
		myBackground.setFitHeight(0);
		myBackground.setFitWidth(0);
		myBackground.setSmooth(true);
		myBackground.setPreserveRatio(true);
		myBackground.relocate(myScene.getWidth()/2, myScene.getHeight()/2);
		myImages.put("center", myBackground);
		myBackground.setVisible(false);
		return myBackground;	
	}
	private Node getBackground(){
		ImageView myBackground=new ImageView(new Image(myData.get("background")));
		myBackground.setFitHeight(myScene.getHeight());
		myBackground.setFitWidth(myScene.getWidth());
		myImages.put("background", myBackground);
		return myBackground;	
	}
	private Node getTopLabel(String text){
		Label myLabel=new Label(text);
		myLabel.relocate(myScene.getWidth(),0);
		myLabel.setPrefSize(525, 25);
		myImages.put("top", myLabel);
		myLabel.getStylesheets().add(myStyle);
		return myLabel;
	}
	private Node getBottomLabel(String text){
		Label myLabel=new Label(text);
		myLabel.relocate(0, myScene.getHeight()-100);
		myLabel.setPrefSize(450,25);
		myImages.put("bottom", myLabel);
		myLabel.getStylesheets().add(myStyle);
		return myLabel;
	}
	private void update(){
		int speed=20;
		ImageView myView=(ImageView)myImages.get("center");
		if(myView.getFitWidth()<=300){
			myView.setVisible(true);
			myView.setFitHeight(myView.getFitHeight()+speed);
			myView.relocate(myScene.getWidth()/2-myView.getFitWidth()/2, myScene.getHeight()/2-myView.getFitHeight()/2);
			myView.setFitWidth(myView.getFitWidth()+speed);
			myView.setRotate(myView.getRotate()+speed);
			
		}
		else{
			myTimeline.stop();
			Button startButton=new Button("Start");
			startButton.relocate(myScene.getWidth()-200, myScene.getHeight()-300);
			startButton.setPrefSize(100, 100);
			startButton.setOnAction(myEvent);
			startButton.getStylesheets().add(myStyle);
			myGroup.getChildren().add(startButton);
		}
		Label topLabel=(Label)myImages.get("top");
		if(topLabel.getLayoutX()>=200){
			topLabel.setLayoutX(topLabel.getLayoutX()-speed*2);
		}
		Label bottomLabel=(Label)myImages.get("bottom");
		if(bottomLabel.getLayoutX()<=400){
			bottomLabel.setLayoutX(bottomLabel.getLayoutX()+speed);
		}
	}
	
}
