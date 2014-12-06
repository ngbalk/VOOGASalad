package com.print_stack_trace.voogasalad.controller.guiElements;

import java.io.IOException;
import java.util.HashMap;








import java.util.HashSet;
import java.util.Set;

import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.GameEngine;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.CameraType;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;
import com.print_stack_trace.voogasalad.model.engine.physics.SoloPhysicsGenerator.ProgramPhysicEngine;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleSetProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class GamePane extends Pane implements ViewObjectDelegate{
	private double myWidth;
	private double myHeight;
	private GameEngine myGameEngine;
	private HashMap<String,HashSet<SpriteObject>> myData;
	public boolean doubleclick=true;
	public SimpleObjectProperty<SpriteObject> changedSprite=new SimpleObjectProperty<SpriteObject>();
	private HashSet<SpriteObject> userObjects=new HashSet<SpriteObject>();
	public ObservableSet<SpriteObject> myObservableData=FXCollections.observableSet(userObjects);
	private PaneChooser myPaneChooser=new PaneChooser();
	private LevelBar myLevelBar;
	private String myStyle="./com/print_stack_trace/voogasalad/controller/guiResources/SpritePane.css";
	public GamePane(double width, double height, GameEngine gameEngine){
		myWidth=width;
		myHeight=height;
		this.setWidth(Double.POSITIVE_INFINITY);
		this.setHeight(Double.POSITIVE_INFINITY);
		myData=new HashMap<String,HashSet<SpriteObject>>();
		this.setPrefSize(width, height);
		myGameEngine=gameEngine;
		this.getStylesheets().add(myStyle);

	}
	public void addGameObject(ImageView gameObjectImageView, String imagePath){
		if (imagePath!=null){
			String myMessage=new MessagePopUp(myStyle).showDropDownDialog("What type of object would you like this image to be: ",spriteTypeNames());
			if (new BlankSpaceTextChecker().checkText(myMessage)){
				addSpriteObject(gameObjectImageView, imagePath, myMessage);
			}
		}
	}
	private SpriteObject addSpriteObject(ImageView gameObjectImageView, String imagePath, String type){
		SpriteObject myGameObject=new SpriteObject(0, gameObjectImageView, imagePath, type, this);
		myGameObject.getCharacteristics().setHeight(myGameObject.getImage().getFitHeight());
		myGameObject.getCharacteristics().setWidth(myGameObject.getImage().getFitWidth());
		myGameObject.getCharacteristics().setX(myGameObject.getImage().getLayoutX());
		myGameObject.getCharacteristics().setY(myGameObject.getImage().getLayoutY());
		Integer myID=myGameEngine.addObjectToLevel(myGameObject.getCharacteristics());
		myGameObject.setID(myID);
		System.out.println(gameObjectImageView);
		DraggableItem copyNode=new DraggableItem(myGameObject, getWidth(), getHeight());
		if (myData.get(myGameObject.getCode())==null)
			myData.put(myGameObject.getCode(), new HashSet<SpriteObject>());
		myData.get(myGameObject.getCode()).add(myGameObject);
		SimpleObjectProperty<SpriteObject> currentSprite=new SimpleObjectProperty<SpriteObject>(myGameObject);
		this.getChildren().add(myGameObject.getImage());
		return myGameObject;
	}
	public void addExistingObjectToOtherPane(SpriteObject newSprite){
		newSprite.getImage().setFitHeight(newSprite.getCharacteristics().getHeight());
		newSprite.getImage().setFitWidth(newSprite.getCharacteristics().getWidth());
		SpriteObject spriteOnBoard=this.addSpriteObject(newSprite.getImage(), newSprite.getImagePath(), newSprite.getType());
		spriteOnBoard.setCharacteristics(newSprite.getCharacteristics());	
		spriteOnBoard.getImage().setFitHeight(spriteOnBoard.getCharacteristics().getHeight());
		spriteOnBoard.getImage().setFitWidth(spriteOnBoard.getCharacteristics().getWidth());
		spriteOnBoard.getImage().setRotate(spriteOnBoard.getCharacteristics().getOrientation());


	}
	public boolean isReady(){
		if (myLevelBar.getMenus().get(0).getItems().size()>=1){
			return true;
		}
		return false;
	}
	public double getGridWidth(){
		return myWidth;
	}
	public double getGridHeight(){
		return myHeight;
	}
	public void addBackground(ImageView imgView, String imagePath){
		LevelObject levelBackground=myLevelBar.getCurrentLevel();
		this.getChildren().remove(levelBackground.getImage());
		levelBackground.setImageView(imgView);
		levelBackground.setImagePath(imagePath);
		levelBackground.getCharacteristics().setBackgroundImagePath(imagePath);
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


	}

	public void update(SpriteObject myObject){
		SpriteCharacteristics characteristics=myObject.getCharacteristics();
		if (myData.get(myObject.getCode())==null){
			myData.put(myObject.getCode(), new HashSet<SpriteObject>());
			myData.get(myObject.getCode()).add(myObject);
		}
		else{
			if (!myData.get(myObject.getCode()).contains(myObject)){
				myData.get(myObject.getCode()).add(myObject);
			}
		}
		if (new BlankSpaceTextChecker().checkText(myObject.getCode())){
			for (SpriteObject sprite: myData.get(myObject.getCode())){
				sprite.setCharacteristics(characteristics);
				sprite.getCharacteristics().setX(sprite.getImage().getX());
				sprite.getCharacteristics().setY(sprite.getImage().getY());
				sprite.getCharacteristics().setWidth(sprite.getImage().getFitWidth());
				sprite.getCharacteristics().setHeight(sprite.getImage().getFitHeight());
				sprite.getCharacteristics().setOrientation(sprite.getCharacteristics().getOrientation());
				sprite.setImage(myObject.getImage().getImage());
				sprite.getCharacteristics().setImagePath(sprite.getImagePath());
				myGameEngine.updateObject(sprite.getId(), sprite.getCharacteristics());
			}
		}
		else{

			myGameEngine.updateObject(myObject.getId(), myObject.getCharacteristics());
		}
		SpriteObject temp=new SpriteObject(0,new ImageView(myObject.getImage().getImage()), myObject.getImagePath(), myObject.getType(),myObject.getDelegate());
		temp.setCharacteristics(myObject.getCharacteristics());
		changedSprite.set(temp);

	}
	public void addLevelBar(LevelBar levelBar){
		myLevelBar=levelBar;
	}
	public void update(LevelObject currentLevel){
		levelUpdate(currentLevel);
	}
	public void addLevelUpdate(LevelObject myObject){
		myObject.setDelegate(this);

		String name=new MessagePopUp(myStyle).showInputDialog("Name of Level:");
		if (new BlankSpaceTextChecker().checkText(name)){
			myLevelBar.addLevel(name, myObject).setOnAction(e->levelUpdate(myObject));
			myObject.getCharacteristics().setName(name);
			levelUpdate(myObject);
		}
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
		myGameEngine.updateGoal(myObject.getID(), myObject.getCharacteristics());
	}
	public void addGoalToLevel(GoalObject myObject){
		myGameEngine.addGoalToLevel(myObject.getCharacteristics());
	}
	public String[] spriteTypeNames(){
		String spriteNames="./com/print_stack_trace/voogasalad/controller/guiResources/PaneTypes.Properties";
		ResourceReader resourceRead=new ResourceReader(spriteNames);
		HashMap<String, String> mySpriteMap=resourceRead.getProperties();
		String[] sprites=new String[SpriteType.values().length];
		for (int i=0; i<SpriteType.values().length;i++){
			if (mySpriteMap.get(SpriteType.values()[i].name())!=null){
				String[] nameOfSprite=mySpriteMap.get(SpriteType.values()[i].name()).split(";");
				sprites[i]=nameOfSprite[0];
			}
		}
		return sprites;
	}

	public void setCamera(CameraType cameratype) {
		myGameEngine.setCameraType(cameratype);

	}
	@Override
	public void setPhysics(ProgramPhysicEngine typeOfGravity) {
		myGameEngine.setProgramPhysicsEngine(typeOfGravity);	
	}
	@Override
	public void removeSpriteOBjects(SpriteObject myObject) {
		if (myData.get(myObject.getCode()).contains(myObject)){
			myData.get(myObject.getCode()).remove(myObject);
		}	
	}
	@Override
	public Set getLevelsAvailable() {
		return myLevelBar.getLevels();
	}
	public void saveGame(){
		try {
			myGameEngine.saveGame();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
