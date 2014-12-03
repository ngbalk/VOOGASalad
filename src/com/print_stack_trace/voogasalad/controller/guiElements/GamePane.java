package com.print_stack_trace.voogasalad.controller.guiElements;

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
		this.setWidth(width);
		this.setHeight(height);
		myData=new HashMap<String,HashSet<SpriteObject>>();
		this.setPrefSize(width, height);
		myGameEngine=gameEngine;
		this.getStylesheets().add(myStyle);
		
	}
	public void addGameObject(ImageView gameObjectImageView){
		if (gameObjectImageView!=null){
			String myMessage=new MessagePopUp(myStyle).showDropDownDialog("What type of object would you like this image to be: ",spriteTypeNames());
			if (new BlankSpaceTextChecker().checkText(myMessage)){
				 addSpriteObject(gameObjectImageView, myMessage);
			}
		}
	}
	private SpriteObject addSpriteObject(ImageView gameObjectImageView, String type){
		SpriteObject myGameObject=new SpriteObject(0, gameObjectImageView,type, this);
		Integer myID=myGameEngine.addObjectToLevel(myGameObject.getCharacteristics());
		myGameObject.setID(myID);
		myGameObject.getCharacteristics().setHeight(myGameObject.getImage().getFitHeight());
		myGameObject.getCharacteristics().setWidth(myGameObject.getImage().getFitWidth());
		DraggableItem copyNode=new DraggableItem(myGameObject, getWidth(), getHeight());
		
		if (myData.get(myGameObject.getCode())==null)
			myData.put(myGameObject.getCode(), new HashSet<SpriteObject>());
		myData.get(myGameObject.getCode()).add(myGameObject);
		SimpleObjectProperty<SpriteObject> currentSprite=new SimpleObjectProperty<SpriteObject>(myGameObject);
		this.getChildren().add(myGameObject.getImage());
		return myGameObject;
	}
	public void addExistingObjectToOtherPane(SpriteObject newSprite){
		newSprite.changeImageView(newSprite.getImage());
		SpriteObject spriteOnBoard=this.addSpriteObject(newSprite.getImage(), newSprite.getType());
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
		for (SpriteObject sprite: myData.get(myObject.getCode())){
			sprite.setCharacteristics(characteristics);
			sprite.getCharacteristics().setX(sprite.getImage().getLayoutX());
			sprite.getCharacteristics().setY(sprite.getImage().getLayoutY());
			sprite.getCharacteristics().setWidth(sprite.getImage().getFitWidth());
			sprite.getCharacteristics().setHeight(sprite.getImage().getFitHeight());
			sprite.getCharacteristics().setOrientation(sprite.getImage().getFitWidth());
			sprite.setImage(myObject.getImage().getImage());
			myGameEngine.updateObject(sprite.getId(), sprite.getCharacteristics());
		}
		SpriteObject temp=new SpriteObject(0,new ImageView(myObject.getImage().getImage()),myObject.getType(),myObject.getDelegate());
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
}
