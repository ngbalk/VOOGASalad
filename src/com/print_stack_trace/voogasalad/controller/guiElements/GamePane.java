package com.print_stack_trace.voogasalad.controller.guiElements;

import java.util.HashMap;





import com.print_stack_trace.voogasalad.model.engine.GameEngine;

import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class GamePane extends Pane implements ViewObjectDelegate{
	private double myWidth;
	private double myHeight;
	private GameEngine myGameEngine;
	private HashMap<ImageView, Number> myData;
	private PaneChooser myPaneChooser=new PaneChooser();
	private LevelBar myLevelBar;
	public GamePane(double width, double height){
		myWidth=width;
		myHeight=height;
		this.setWidth(width);
		this.setHeight(height);
		myData=new HashMap<ImageView, Number>();
		this.setPrefSize(width, height);
	}
	public void addGameObject(ImageView gameObjectImageView){
		if (gameObjectImageView!=null){
			String myMessage=new InputMessage().showInputDialog("What type of object would you like this image to be: (hero, obstacle, enemy, platform or reward");
			SpriteObject myGameObject=new SpriteObject(0, gameObjectImageView, myMessage, this);
			Integer myID=myGameEngine.addObjectToLevel(myGameObject.getCharacteristics());
			myGameObject.setID(myID);
			myGameObject.getCharacteristics().setHeight(myGameObject.getImage().getFitHeight());
			myGameObject.getCharacteristics().setWidth(myGameObject.getImage().getFitWidth());
			gameObjectImageView.setOnMouseClicked(event->createPane(myGameObject));
			DraggableItem copyNode=new DraggableItem(myGameObject, getWidth(), getHeight());
			myData.put(gameObjectImageView, 0);
			this.getChildren().add(gameObjectImageView);
		}
	}
	public double getGridWidth(){
		return myWidth;
	}
	public double getGridHeight(){
		return myHeight;
	}
	public void createPane(GameObject object){
		Pane myNewPane=myPaneChooser.createPane(((SpriteObject)object).getType(), object);
		((GeneralPane) myNewPane).openPane();
	}
	public void addBackground(ImageView imgView){
		LevelObject levelBackground=myLevelBar.getCurrentLevel();
		this.getChildren().remove(levelBackground.getImage());
		levelBackground.setImageView(imgView);
		levelBackground.getColorPane().setVisible(false);
		this.getChildren().add(0,imgView);
		ImageView background=levelBackground.getImage();
		background.setFitWidth(getWidth());
		background.setFitHeight(getHeight()-10);
		background.setFitWidth(getWidth()-10);
		background.setSmooth(true);
		background.setPreserveRatio(false);
		background.relocate(5, 5);
		levelBackground.getCharacteristics().setBackground(background.getImage());
		levelUpdate(levelBackground);
		levelBackground.getImage().setOnMouseClicked(e->createLevelPane(levelBackground));
		levelBackground.getColorPane().setOnMouseClicked(e->createLevelPane(levelBackground));
	}
	public void createLevelPane(LevelObject myLevel){
			Pane myNewPane=myPaneChooser.createPane("level background", myLevel);
			((GeneralPane) myNewPane).openPane();
	}
	public void addGameEngine(GameEngine gameEngine){
		myGameEngine=gameEngine;
	}
	public void update(SpriteObject myObject){
		myGameEngine.updateObject(myObject.getId(),myObject.getCharacteristics());
	}
	public void addLevelBar(LevelBar levelBar){
		myLevelBar=levelBar;
	}
	public void update(LevelObject currentLevel){
		levelUpdate(currentLevel);
	}
	public void addLevelUpdate(LevelObject myObject){
		myObject.setDelegate(this);
		String name=new InputMessage().showInputDialog("Name of Level:");
		myLevelBar.addLevel(name, myObject).setOnAction(e->levelUpdate(myObject));
		myObject.getCharacteristics().setName(name);
		myLevelBar.setCurrentLevel(myObject);
	}
	public void levelUpdate(LevelObject currentLevel){
		myLevelBar.setCurrentLevel(currentLevel);
		this.getChildren().removeAll(myLevelBar.getNonActiveLevels());
		this.getChildren().removeAll(myLevelBar.getNonActiveColors());
		this.getChildren().add(0, currentLevel.getImage());
		this.getChildren().add(1, sizePane(currentLevel.getColorPane()));
		myGameEngine.setLevelCharacteristics(currentLevel.getCharacteristics());
	}
	public Pane sizePane(Pane toBeSize){
		toBeSize.setPrefSize(this.getWidth(), this.getHeight());
		return toBeSize;
	}
	public void saveLevel(){
		
	}
	public void update(GoalObject myObject){
		myGameEngine.addGoalToLevel(myObject.getCharacteristics());
		
	}

}
