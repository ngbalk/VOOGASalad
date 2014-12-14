package com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import com.google.gson.JsonSyntaxException;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.DraggableItem;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameWorldObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GoalObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.LevelObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.SpriteObject;
import com.print_stack_trace.voogasalad.controller.guiElements.resourceReader.BlankSpaceTextChecker;
import com.print_stack_trace.voogasalad.controller.guiElements.resourceReader.ResourceReader;
import com.print_stack_trace.voogasalad.controller.popUpPanes.MessagePopUp;
import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.GameEngine;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;
import com.print_stack_trace.voogasalad.model.engine.physics.PhysicsEngine;
import com.print_stack_trace.voogasalad.model.engine.physics.SoloPhysicsGenerator.ProgramPhysicEngine;
import com.print_stack_trace.voogasalad.model.engine.runtime.camera.CameraFactory.CameraType;

public class GamePane extends Pane implements ViewObjectDelegate {
	private GameEngine myGameEngine;
	private HashMap<String, HashSet<SpriteObject>> myData;
	private SimpleObjectProperty<SpriteObject> changedSprite = new SimpleObjectProperty<SpriteObject>();
	private LevelTracker levelTracker;
	private SimpleDoubleProperty xVal = new SimpleDoubleProperty(0);
	private SimpleDoubleProperty yVal = new SimpleDoubleProperty(0);
	private String myStyle = "./com/print_stack_trace/voogasalad/controller/guiResources/SpritePane.css";
	private HashMap<String,String> myMessages;

	public GamePane(double width, double height, GameEngine gameEngine) {
		size(width, height);
		levelTracker = new LevelTracker();
		myData = new HashMap<String, HashSet<SpriteObject>>();
		myGameEngine = gameEngine;
		myMessages=new ResourceReader("./com/print_stack_trace/voogasalad/controller/guiResources/GUIMessages.Properties").getProperties();
		this.getStylesheets().add(myStyle);
	}
	
	//Sizing methods (ACCESSORS AND MUTATORS)
	private void size(double width, double height){
		setProgramWidth(width);
		setProgramHeight(height);
	}
	public double getProgramWidth(){
		return getPrefWidth();
	}
	public double getProgramHeight(){
		return getPrefHeight();
	}
	public void setProgramWidth(Number width){
		setPrefWidth(width.doubleValue());
	}
	public void setProgramHeight(Number height){
		setPrefHeight(height.doubleValue());
	}
	
	//Properties
	public void setXProperty(double val) {
		xVal.setValue(val);
	}
	public void setYProperty(double val) {
		yVal.setValue(val);
	}
	public SimpleObjectProperty<LevelObject> currentLevelProperty() {
		return levelTracker.getCurrentLevelProperty();
	}
	public SimpleObjectProperty<LevelObject> addLevelProperty() {
		return levelTracker.getAddLevelProperty();
	}
	public SimpleObjectProperty<EventHandler> eventLevelProperty() {
		return levelTracker.getEventProperty();
	}
	
	public SimpleObjectProperty<String> levelNameProperty() {
		return levelTracker.nameProperty();
	}

	/**
	 * Adds a sprite to the GamePane
	 * @param gameObjectImageView		ImageView of object toAdd
	 * @param imagePath					ImagePath of the Image to Add
	 */
	public void addSpriteObject(ImageView gameObjectImageView, String imagePath) {
		if (imagePath != null) {
			String myMessage = new MessagePopUp(myStyle).showDropDownDialog(myMessages.get("addSprite"),
					spriteTypeNames());
			if (new BlankSpaceTextChecker().checkText(myMessage)) {
				createSpriteToBeAdded(gameObjectImageView, imagePath, myMessage);
			}
		}
	}

	public Object createSpriteToBeAdded(ImageView gameObjectImageView,
			String imagePath, String type) {
		SpriteObject myGameObject = new SpriteObject(0, imagePath, type, this);
		myGameObject.initializeSprite();
		DraggableItem copyNode = new DraggableItem(myGameObject, this.prefWidthProperty(),
				this.prefHeightProperty(), xVal, yVal);
		addSpriteToLevel(myGameObject);
		return myGameObject;
	}

	/**
	 * Adds the SpriteObject to a specific level
	 * @param sprite sprite to be Added
	 */
	private void addSpriteToLevel(SpriteObject sprite){
		sprite.setID(myGameEngine.addObjectToLevel(sprite
				.getCharacteristics()));
		if (!myData.containsKey(sprite.getCode()))
			myData.put(sprite.getCode(), new HashSet<SpriteObject>());
		myData.get(sprite.getCode()).add(sprite);
		getChildren().add(sprite.getImage());
		levelTracker.addSprite(sprite);
	}

	/**
	 * Adds a sprite with characterisitcs that has already been set from UserObjectsLibrary
	 * @param newSprite 	sprite to be Added
	 */
	public void addExistingObjectToOtherPane(SpriteObject newSprite) {
		newSprite.initializeImage();
		SpriteObject spriteOnBoard = (SpriteObject) this.createSpriteToBeAdded(newSprite.getImage(),
				newSprite.getImagePath(), newSprite.getType());
		spriteOnBoard.setCharacteristics(newSprite.getCharacteristics());
		spriteOnBoard.initializeImage();
		removeSpriteObjects(spriteOnBoard);
		myData.get(spriteOnBoard.getCode()).add(spriteOnBoard);
	}

	/**
	 * 
	 * @return if the first level has been created
	 */
	public boolean isReady() {
		return levelTracker.getNumberOfLevels() > 0;
	}

	
	public void addBackground(ImageView imgView, String imagePath) {
		LevelObject levelBackground = levelTracker.getCurrentLevel();
		this.getChildren().remove(levelBackground.getImage());
		levelBackground.setImageViewWithImage(imgView, imagePath);
		this.getChildren().add(0, 
				levelBackground.createBackgroundImageView(getPrefWidth(), getPrefHeight()));
		levelChange(levelBackground);
	}

	
	public void update(SpriteObject myObject) {
		String spriteCode=myObject.getCode();
		SpriteCharacteristics characteristics = myObject.getCharacteristics();
		if (!myData.containsKey(spriteCode)) 
			myData.put(spriteCode, new HashSet<SpriteObject>());
		myData.get(spriteCode).add(myObject);

		if (new BlankSpaceTextChecker().checkText(spriteCode)) {
			for (SpriteObject sprite : myData.get(spriteCode)) {
				sprite.setCharacteristics(characteristics);
				sprite.setLocation();
				sprite.initializeSprite();
				sprite.setImage(sprite.getCharacteristics().getImagePath());
				myGameEngine.updateObject(sprite.getID(),
						sprite.getCharacteristics());
			}
		} else {
			myGameEngine.updateObject(myObject.getID(),
					myObject.getCharacteristics());
		}
		SpriteObject temp = new SpriteObject(0, myObject.getImagePath(),
				myObject.getType(), myObject.getDelegate());
		temp.setCharacteristics(myObject.getCharacteristics());
		getChangedSprite().setValue(temp);
	}

	
	public void update(LevelObject currentLevel) {
		levelChange(currentLevel);
	}

	public void addNewLevel(Object level) {
		LevelObject levelObject=(LevelObject) level;
		levelObject.setDelegate(this);
		String name = new MessagePopUp(myStyle)
		.showInputDialog("Name of Level:");
		if (new BlankSpaceTextChecker().checkText(name)) {
			levelObject.getCharacteristics().setName(name);
			levelObject.getCharacteristics()
			.setID(levelTracker.getNumberOfLevels());
			addLevelToEngine(levelObject);

		}
	}
	
	
	public void addLevelToEngine(Object level){
		levelTracker.addLevel((LevelObject) level, e -> levelChange((LevelObject)level));
		myGameEngine.addLevel(levelTracker.getNumberOfLevels(),
				((LevelObject)level).getCharacteristics());
		levelChange((LevelObject)level);
	}

	/**
	 * Switches the Pane's view to the current level
	 * @param currentLevel current level of the game
	 */
	private void levelChange(LevelObject currentLevel) {
		levelTracker.setCurrentLevel(currentLevel);
		levelTracker.clearNonActiveLevels((type)->this.getChildren().remove(type),
				(type)->this.getChildren().add((Node)type));
		this.getChildren().add(0, currentLevel.getImage());
		this.getChildren().add(1, sizePane(currentLevel.getColorPane()));
		myGameEngine.setCurrentLevel(currentLevel.getCharacteristics().getID());
		myGameEngine.setLevelCharacteristics(currentLevel.getCharacteristics());
	}

	
	public void update(GameWorldObject gameWorld){
		myGameEngine.setGameWorldCharacteristics(gameWorld.getCharacteristics());
	}
	/**
	 * 
	 * @param toBeSized 	Pane to be sized
	 * @return			a pane with the height and width of the GamePane
	 */
	public Pane sizePane(Pane toBeSized) {
		toBeSized.setPrefSize(this.getPrefWidth(), this.getPrefHeight());
		return toBeSized;
	}

	public void update(GoalObject myObject) {
		myGameEngine.updateGoal(myObject.getID(), myObject.getCharacteristics());
	}

	public void addGoalToLevel(GoalObject myObject) {
		myGameEngine.addGoalToLevel(myObject.getCharacteristics());
	}

	/**
	 * 
	 * @return String[] with all the names of the types of sprites from a properties file
	 */
	public String[] spriteTypeNames() {
		String spriteNames = "./com/print_stack_trace/voogasalad/controller/guiResources/PaneTypes.Properties";
		ResourceReader resourceRead = new ResourceReader(spriteNames);
		HashMap<String, String> mySpriteMap = resourceRead.getProperties();
		String[] sprites = new String[SpriteType.values().length];
		for (int i = 0; i < SpriteType.values().length; i++) {
			if (mySpriteMap.get(SpriteType.values()[i].name()) != null) {
				String[] nameOfSprite = mySpriteMap.get(
						SpriteType.values()[i].name()).split(";");
				sprites[i] = nameOfSprite[0];
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
	public void setPhysics(PhysicsEngine physicsEngine) {
		myGameEngine.setPhysicsEngine(physicsEngine);
	}

	@Override
	public void removeSpriteObjects(SpriteObject myObject) {
		myData.get(myObject.getCode()).remove(myObject);
	}

	public void saveGame() {
		try {
			myGameEngine.saveGame();
		} catch (IOException e) {
			new MessagePopUp(myStyle).showMessageDialog(myMessages.get("saveGame"));
		}
	}
	@Override
	public void deleteObject(SpriteObject object) {
		myGameEngine.deleteObject(object.getID());
		this.getChildren().remove(object.getImage());
		this.levelTracker.removeSprite(object);
	}

	public void extendRight() {
		new ExtendDirection(levelTracker.getCurrentLevel(), this, getBackgroundPane()).extendRight();
	}
	@Override
	public void extendDown() {
		new ExtendDirection(levelTracker.getCurrentLevel(), this, getBackgroundPane()).extendDown();
	}
	@Override
	public void extendUp() {
		new ExtendDirection(levelTracker.getCurrentLevel(), this, getBackgroundPane()).extendUp();
	}

	@Override
	public void actionToCurrentLevelSprites(ObjectAction action) {
		levelTracker.currentLevelSprites(action);
	}
	public SimpleObjectProperty<SpriteObject> getChangedSprite() {
		return changedSprite;
	}
	@Override
	public void actionToAllLevels(ObjectAction object) {
		levelTracker.actionToAllLevels(object);
	}

	/**
	 * Used in loading in a preexisting file level
	 */
	@Override
	public Object load(File file) {
		try {
			return myGameEngine.loadGameFromFile(file);
		} catch (JsonSyntaxException | ClassNotFoundException | IOException e) {
			new MessagePopUp(myStyle).showMessageDialog(myMessages.get("cannotLoad"));
			return null;
		}
	}

	//Background
	@Override
	public void addBackground(Node level) {
		this.getChildren().add(0, level);
	}
	private Node getBackgroundPane(){
		return this.getChildren().get(0);
	}

}
