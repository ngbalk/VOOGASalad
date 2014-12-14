package com.print_stack_trace.voogasalad.controller.guiElements.splashScreen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import com.print_stack_trace.voogasalad.utilities.reflection.Reflection;
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

public abstract class AbstractUserSplashScreen {
	protected Group myGroup=new Group();
	protected Timeline myTimeline=new Timeline();
	protected int DEFAULT_FPS=300;
	protected HashMap<String, String> myData;
	protected Scene myScene;
	protected HashMap<Integer,SplashScreenObject> myNodes=new HashMap<Integer,SplashScreenObject>();
	protected EventHandler myEvent;
	
	public AbstractUserSplashScreen(String resourceName, Number width, Number height){
		this(resourceName, width, height, null);
		
	}
	public AbstractUserSplashScreen(String resource, Number width, Number height, EventHandler event){
		
		this.initialize(width.doubleValue(), height.doubleValue());
		myData=new ResourceReader(resource).getProperties();
		myEvent=event;
		
		KeyFrame myKeyFrame=new KeyFrame(Duration.millis(1000/DEFAULT_FPS), e->update());
		myTimeline.setCycleCount(Timeline.INDEFINITE);
		myTimeline.getKeyFrames().add(myKeyFrame);
		myTimeline.play();
		
		makeNode();
		add();
		update();
	}
	
	public Scene getScene(){
		return myScene;
	}
	
	public Scene initialize(double width, double height){
		myScene=new Scene(myGroup,width, height);
		return myScene;	
	}
	
	private EventHandler stopAnimation(){
		return myEvent;
	}
	
	private void update(){
		int count=0;
		for (Integer node: myNodes.keySet()){
			if (!myNodes.get(node).update()){
				myNodes.get(node).addEnd(stopAnimation());
				count++;
			}
		}
		if (count==myNodes.keySet().size()){
			myTimeline.stop();
		}
	}
	
	private void add(){
		int max=0;
		for (Integer index: myNodes.keySet()){
			max=Math.max(max, index);
		}
		for (int i=0; i<=max; i++){
			if (myNodes.containsKey(i)){
				myGroup.getChildren().add(myNodes.get(i).getNode());
			}
		}
	}
	
	private void makeNode(){
		for (String key: myData.keySet()){
			String [] values=myData.get(key).split(";");
			String value=values[0];
			String className=values[1];
			SplashScreenObject newSplashScreenObject= (SplashScreenObject) Reflection.createInstance(className, value, myScene.getWidth(), myScene.getHeight(), myGroup);
			myNodes.put(Integer.parseInt(values[2]), newSplashScreenObject);
		}
	}

}
