package com.print_stack_trace.voogasalad.controller.guiElements;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import com.google.gson.JsonSyntaxException;
import com.print_stack_trace.voogasalad.model.GameWorldCharacteristics;
import com.print_stack_trace.voogasalad.model.GoalCharacteristics;
import com.print_stack_trace.voogasalad.model.LevelCharacteristics;
import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.GameEngine;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;
import com.print_stack_trace.voogasalad.model.engine.authoring.LevelModel;
import com.print_stack_trace.voogasalad.model.engine.physics.PhysicsEngine;
import com.print_stack_trace.voogasalad.model.engine.physics.SoloPhysicsGenerator.ProgramPhysicEngine;
import com.print_stack_trace.voogasalad.model.engine.runtime.camera.CameraFactory;
import com.print_stack_trace.voogasalad.model.environment.Goal;

public class GamePane extends Pane implements ViewObjectDelegate {
	private double myWidth;
	private double myHeight;
	private GameEngine myGameEngine;
	private ImageView background;
	private HashMap<String, HashSet<SpriteObject>> myData;
	public boolean doubleclick = true;
	public SimpleObjectProperty<SpriteObject> changedSprite = new SimpleObjectProperty<SpriteObject>();
	private HashSet<SpriteObject> userObjects = new HashSet<SpriteObject>();
	public ObservableSet<SpriteObject> myObservableData = FXCollections
			.observableSet(userObjects);
	private LevelTracker levelTracker;
	private SimpleDoubleProperty xVal = new SimpleDoubleProperty(0);
	private SimpleDoubleProperty yVal = new SimpleDoubleProperty(0);
	private String myStyle = "./com/print_stack_trace/voogasalad/controller/guiResources/SpritePane.css";
	private GameWorldCharacteristics gameWorld = new GameWorldCharacteristics();

	public GamePane(double width, double height, GameEngine gameEngine) {
		myWidth = width;
		myHeight = height;
		levelTracker = new LevelTracker();
		this.setWidth(Double.POSITIVE_INFINITY);
		this.setHeight(Double.POSITIVE_INFINITY);
		myData = new HashMap<String, HashSet<SpriteObject>>();
		this.setPrefSize(width, height);
		myGameEngine = gameEngine;
		this.getStylesheets().add(myStyle);

	}

	public void setXProperty(double val) {
		xVal.setValue(val);
	}

	public void setYProperty(double val) {
		yVal.setValue(val);
	}

	public void addGameObject(ImageView gameObjectImageView, String imagePath) {
		if (imagePath != null) {
			String myMessage = new MessagePopUp(myStyle).showDropDownDialog(
					"What type of object would you like this image to be: ",
					spriteTypeNames());
			if (new BlankSpaceTextChecker().checkText(myMessage)) {
				addSpriteObject(gameObjectImageView, imagePath, myMessage);
			}
		}
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

	private SpriteObject addSpriteObject(ImageView gameObjectImageView,
			String imagePath, String type) {
		SpriteObject myGameObject = new SpriteObject(0, imagePath, type, this);
		myGameObject.getCharacteristics().setHeight(
				myGameObject.getImage().getFitHeight());
		myGameObject.getCharacteristics().setWidth(
				myGameObject.getImage().getFitWidth());
		myGameObject.getCharacteristics().setX(
				myGameObject.getImage().getLayoutX());
		myGameObject.getCharacteristics().setY(
				myGameObject.getImage().getLayoutY());
		Integer myID = myGameEngine.addObjectToLevel(myGameObject
				.getCharacteristics());
		myGameObject.setID(myID);
		DraggableItem copyNode = new DraggableItem(myGameObject, getWidth(),
				getHeight(), xVal, yVal);
		if (myData.get(myGameObject.getCode()) == null)
			myData.put(myGameObject.getCode(), new HashSet<SpriteObject>());
		myData.get(myGameObject.getCode()).add(myGameObject);
		SimpleObjectProperty<SpriteObject> currentSprite = new SimpleObjectProperty<SpriteObject>(
				myGameObject);
		this.getChildren().add(myGameObject.getImage());
		levelTracker.addSprite(myGameObject);
		return myGameObject;
	}

	public void addExistingObjectToOtherPane(SpriteObject newSprite) {
		newSprite.getImage().setFitHeight(
				newSprite.getCharacteristics().getHeight());
		newSprite.getImage().setFitWidth(
				newSprite.getCharacteristics().getWidth());
		SpriteObject spriteOnBoard = this.addSpriteObject(newSprite.getImage(),
				newSprite.getImagePath(), newSprite.getType());
		spriteOnBoard.setCharacteristics(newSprite.getCharacteristics());
		spriteOnBoard.getImage().setFitHeight(
				spriteOnBoard.getCharacteristics().getHeight());
		spriteOnBoard.getImage().setFitWidth(
				spriteOnBoard.getCharacteristics().getWidth());
		spriteOnBoard.getImage().setRotate(
				spriteOnBoard.getCharacteristics().getOrientation());

	}

	public boolean isReady() {
		if (levelTracker.getLevels().size() > 0) {
			return true;
		}
		return false;
	}

	public double getGridWidth() {
		return myWidth;
	}

	public double getGridHeight() {
		return myHeight;
	}

	public void addBackground(ImageView imgView, String imagePath) {
		LevelObject levelBackground = levelTracker.getCurrentLevel();
		this.getChildren().remove(levelBackground.getImage());
		levelBackground.setImageView(imgView);
		levelBackground.setImagePath(imagePath);
		levelBackground.getCharacteristics().setBackgroundImagePath(imagePath);
		levelBackground.getColorPane().setVisible(false);
		this.getChildren().add(0, imgView);
		ImageView background = levelBackground.getImage();
		background.setFitWidth(getWidth());
		background.setFitHeight(getHeight() - 10);
		background.setFitWidth(getWidth() - 10);
		background.setSmooth(true);
		background.setPreserveRatio(false);
		background.relocate(5, 5);
		levelBackground.getCharacteristics().setBackground(
				background.getImage());
		levelChange(levelBackground);

	}

	public void update(SpriteObject myObject) {
		SpriteCharacteristics characteristics = myObject.getCharacteristics();
		if (myData.get(myObject.getCode()) == null) {
			myData.put(myObject.getCode(), new HashSet<SpriteObject>());
			myData.get(myObject.getCode()).add(myObject);
		} else {
			if (!myData.get(myObject.getCode()).contains(myObject)) {
				myData.get(myObject.getCode()).add(myObject);
			}
		}
		if (new BlankSpaceTextChecker().checkText(myObject.getCode())) {
			for (SpriteObject sprite : myData.get(myObject.getCode())) {
				sprite.setCharacteristics(characteristics);
				sprite.getCharacteristics().setWidth(
						sprite.getImage().getFitWidth());
				sprite.getCharacteristics().setHeight(
						sprite.getImage().getFitHeight());
				sprite.getCharacteristics().setOrientation(
						sprite.getCharacteristics().getOrientation());
				sprite.setImage(myObject.getImage().getImage());
				sprite.getCharacteristics().setImagePath(sprite.getImagePath());
				myGameEngine.updateObject(sprite.getId(),
						sprite.getCharacteristics());
			}
		} else {
			myGameEngine.updateObject(myObject.getId(),
					myObject.getCharacteristics());
		}
		SpriteObject temp = new SpriteObject(0, myObject.getImagePath(),
				myObject.getType(), myObject.getDelegate());
		temp.setCharacteristics(myObject.getCharacteristics());
		changedSprite.set(temp);

	}

	public void update(LevelObject currentLevel) {
		levelChange(currentLevel);
	}

	public void addLevelUpdate(LevelObject myObject) {
		myObject.setDelegate(this);

		String name = new MessagePopUp(myStyle)
				.showInputDialog("Name of Level:");
		if (new BlankSpaceTextChecker().checkText(name)) {
			myObject.getCharacteristics().setName(name);
			levelTracker.addLevel(myObject, e -> levelChange(myObject));
			levelChange(myObject);
		}
	}

	private void levelChange(LevelObject currentLevel) {
		background = currentLevel.getImage();
		levelTracker.setCurrentLevel(currentLevel);
		this.getChildren().removeAll(levelTracker.getNonActiveLevels());
		this.getChildren().removeAll(levelTracker.getNonActiveColors());
		this.getChildren().removeAll(levelTracker.removableSprites());
		this.getChildren().addAll(levelTracker.activeSprites());
		this.getChildren().add(0, currentLevel.getImage());
		this.getChildren().add(1, sizePane(currentLevel.getColorPane()));
		myGameEngine.setLevelCharacteristics(currentLevel.getCharacteristics());
	}

	public ImageView getBackgroundImage() {
		return background;
	}

	public Pane sizePane(Pane toBeSize){
		toBeSize.setPrefSize(this.getPrefWidth(), this.getPrefHeight());


		return toBeSize;
	}

	public void saveLevel() {

	}

	public void update(GoalObject myObject) {
		myGameEngine
				.updateGoal(myObject.getID(), myObject.getCharacteristics());
	}

	public void addGoalToLevel(GoalObject myObject) {
		myGameEngine.addGoalToLevel(myObject.getCharacteristics());
	}

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

	public void setCamera(CameraFactory.CameraType cameratype) {
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
	public void removeSpriteOBjects(SpriteObject myObject) {
		if (myData.get(myObject.getCode()).contains(myObject)) {
			myData.get(myObject.getCode()).remove(myObject);
		}
	}

	@Override
	public Set getLevelsAvailable() {
		return levelTracker.getLevels();
	}

	public void saveGame() {
		try {
			myGameEngine.saveGame();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteObject(SpriteObject object) {
		myGameEngine.deleteObject(object.getId());
		this.getChildren().remove(object.getImage());
		this.levelTracker.removeSprite(object);
	}

	public void extendRight() {

		LevelCharacteristics levelCharacteristics = levelTracker
				.getCurrentLevel().getCharacteristics();
		int newHorizontalPaneCount = levelCharacteristics
				.incrementHorizontalPaneCount();
		int currentVerticalPaneCount = levelCharacteristics
				.getVerticalPaneCount();
		this.setPrefWidth(this.getBackgroundImage().getFitWidth()
				* newHorizontalPaneCount);

		for (int i = 0; i <= currentVerticalPaneCount; i++) {
			// DUPLICATE BACKGROUND IMAGE
			ImageView backgroundImageView = this.getBackgroundImage();
			ImageView backgroundImageViewCopy = new ImageView(
					backgroundImageView.getImage());
			backgroundImageViewCopy.setFitHeight(backgroundImageView
					.getFitHeight());
			backgroundImageViewCopy.setFitWidth(backgroundImageView
					.getFitWidth());
			backgroundImageViewCopy.setSmooth(true);
			backgroundImageViewCopy.relocate(backgroundImageView.getFitWidth()
					* (newHorizontalPaneCount - 1),
					backgroundImageView.getFitHeight() * i);
			this.getChildren().add(0, backgroundImageViewCopy);
		}

	}

	@Override
	public void extendDown() {
		LevelCharacteristics levelCharacteristics = levelTracker
				.getCurrentLevel().getCharacteristics();
		int newVerticalPaneCount = levelCharacteristics
				.incrementVerticalPaneCount();
		int currentHorizontalPaneCount = levelCharacteristics
				.getHorizontalPaneCount();
		this.setPrefHeight(this.getBackgroundImage().getFitHeight()
				* newVerticalPaneCount);

		for (int i = 0; i <= currentHorizontalPaneCount; i++) {
			// DUPLICATE BACKGROUND IMAGE
			ImageView backgroundImageView = this.getBackgroundImage();
			ImageView backgroundImageViewCopy = new ImageView(
					backgroundImageView.getImage());
			backgroundImageViewCopy.setFitHeight(backgroundImageView
					.getFitHeight());
			backgroundImageViewCopy.setFitWidth(backgroundImageView
					.getFitWidth());
			backgroundImageViewCopy.setSmooth(true);
			backgroundImageViewCopy.relocate(backgroundImageView.getFitWidth()
					* i, backgroundImageView.getFitHeight()
					* (newVerticalPaneCount - 1));
			this.getChildren().add(0, backgroundImageViewCopy);
		}
	}

	// TODO: consider adding to the AbstractGUI shitz
	public void loadLevel() {

		// load in level from game data
		LevelModel levelModel = loadLevelModelFromFile();
		if (levelModel == null)
			return;
		Integer first = levelModel.getSpriteMap().keySet().iterator().next();
		levelModel.setMainCharacter(first);
		LevelCharacteristics levelCharacteristics = levelModel
				.getLevelCharacteristics();
		// transfer general level data in
		loadLevelObjectFromLevel(levelCharacteristics);
		// transfer sprite data in
		loadSpriteObjectsFromLevel(levelModel.getSpriteMap());
		// transfer goal data in
		loadGoalObjectsFromLevel(levelModel.getGoalMap());
		// transfer other things in
		setCamera(levelModel.getCameraType());
		setPhysics(levelModel.getPhysicsEngine());

		// TODO: add more here if necessary
	}

	private LevelModel loadLevelModelFromFile() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Load level");
		fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")
				+ "/src/com/print_stack_trace/voogasalad/model/data/"));
		Stage newStage = new Stage();
		File file = fileChooser.showOpenDialog(newStage);
		if (file != null) {
			try {
				return myGameEngine.loadLevelForEditing(file);
			} catch (IOException | JsonSyntaxException | ClassNotFoundException ex) {
				new MessagePopUp(myStyle).showMessageDialog((ex.getMessage()));
			}
		}
		return null;
	}

	private void loadLevelObjectFromLevel(
			LevelCharacteristics levelCharacteristics) {
		LevelObject levelObject = new LevelObject(
				levelCharacteristics.getBackgroundImagePath(), this,
				levelCharacteristics);
		levelObject.getCharacteristics()
				.setName(levelCharacteristics.getName());
		levelTracker.addLevel(levelObject, e -> levelChange(levelObject));
		levelObject.update();
		double width = this.getPrefWidth();
		double height = this.getPrefHeight();
		int horizontalPaneCount = levelObject.getCharacteristics()
				.getHorizontalPaneCount();
		this.setPrefWidth(horizontalPaneCount * this.getPrefWidth());
		int verticalPaneCount = levelObject.getCharacteristics()
				.getVerticalPaneCount();
		this.setPrefHeight(verticalPaneCount * this.getPrefHeight());
		for (int i = 0; i < horizontalPaneCount; i++) {
			for (int j = 0; j < verticalPaneCount; j++) {
				ImageView levelImageView = new ImageView(levelObject.getImage()
						.getImage());
				levelImageView.setFitHeight(height);
				levelImageView.setFitWidth(width);
				levelImageView.relocate(i * width, height * j);
				this.getChildren().add(0, levelImageView);
			}
		}
		levelChange(levelObject);
	}

	private void loadSpriteObjectsFromLevel(
			Map<Integer, SpriteCharacteristics> spriteMap) {
		for (SpriteCharacteristics sc : spriteMap.values()) {
			ImageView imageView = new ImageView(sc.getImage());

			SpriteObject spriteObject = addSpriteObject(imageView,
					sc.getImagePath(), capitalize(sc.getObjectType().name()));
			spriteObject.setCharacteristics(sc);
			spriteObject.getImage().relocate(sc.getX(), sc.getY());
			spriteObject.getImage().setFitWidth(sc.getWidth());
			spriteObject.getImage().setFitHeight(sc.getHeight());
			spriteObject.getImage().setRotate(sc.getOrientation());
			myGameEngine.updateObject(spriteObject.getId(),
					spriteObject.getCharacteristics());
		}
	}

	private void loadGoalObjectsFromLevel(
			Map<Integer, GoalCharacteristics> goalMap) {
		for (GoalCharacteristics goal : goalMap.values()) {
			GoalObject goalObject = new GoalObject(goal.myGoalType, this);
			goalObject.setCharacteristics(goal);
			addGoalToLevel(goalObject);
			goalObject.update();
		}
	}

	private String capitalize(String line) {
		/*
		 * String[] strArray = line.split(" "); String capitalizedString = "";
		 * for(int i=0; i<strArray.length; i++) capitalizedString +=
		 * Character.toUpperCase
		 * (strArray[i].charAt(0))+strArray[i].substring(1).toLowerCase() + " ";
		 * return capitalizedString
		 */
		return Character.toUpperCase(line.charAt(0))
				+ line.substring(1).toLowerCase();
	}

	// private void loadGoalObjectsFromLevel(Map<Integer,Goal> goalMap) {
	// for(Goal goal : goalMap.values()){
	// GoalObject goalObject = new GoalObject(goal.getGoalType(),this);
	// goalObject.setCharacteristics(goal.getGoalCharacteristics());
	// >>>>>>> c324255721f46eff4ab50040883387b89e926517

	@Override
	public HashSet<GameObject> getCurrentLevelSprites() {
		return levelTracker.currentLevelSprites();
	}
}
