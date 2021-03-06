package com.print_stack_trace.voogasalad.controller.guiElements.topFileMenuBar;

import java.io.File;
import java.util.Map;

import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor.ViewObjectDelegate;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameWorldObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GoalObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.LevelObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.SpriteObject;
import com.print_stack_trace.voogasalad.controller.guiElements.layout.AbstractViewDelegate;
import com.print_stack_trace.voogasalad.model.GameWorldCharacteristics;
import com.print_stack_trace.voogasalad.model.GoalCharacteristics;
import com.print_stack_trace.voogasalad.model.LevelCharacteristics;
import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameWorldModel;
import com.print_stack_trace.voogasalad.model.engine.authoring.LevelModel;
import com.print_stack_trace.voogasalad.utilities.fileloading.FileLoadUtility;


public class OpenMenuItem extends AbstractMenuItem{

	public OpenMenuItem(String name){
		super(name);
	}
	
	public OpenMenuItem(String name, AbstractViewDelegate delegate, ViewObjectDelegate game){
		super(name, delegate, game);
	}
	
	public void doAction() {
		loadGame();	
	}
	
	public void loadGame() {
		GameWorldModel gameWorldModel = loadGameWorldModelFromFile();
		if (gameWorldModel == null)
			return;
		GameWorldCharacteristics gameWorldCharacteristics = gameWorldModel.getGameWorldCharacteristics();
		GameWorldObject gameWorldObject = new GameWorldObject("", myGame);
		gameWorldObject.setCharacteristics(gameWorldCharacteristics);
		gameWorldObject.update();
		Map<Integer, LevelModel> levelMap = gameWorldModel.getLevelMap();
		for (LevelModel level : levelMap.values()) {
			loadLevel(level);
		}
	}

	private GameWorldModel loadGameWorldModelFromFile() {
		File file = FileLoadUtility.loadFile((System.getProperty("user.dir")
				+ "/src/com/print_stack_trace/voogasalad/model/data/"));
		return (file != null)? (GameWorldModel)myGame.load(file):null;
	}

	private void loadLevel(LevelModel levelModel) {
		if (levelModel == null)
			return;
		LevelCharacteristics levelCharacteristics = levelModel
				.getLevelCharacteristics();
		loadLevelObjectFromLevel(levelCharacteristics);
		loadSpriteObjectsFromLevel(levelModel.getSpriteMap());
		loadGoalObjectsFromLevel(levelModel.getGoalMap());
		myGame.setCamera(levelModel.getCameraType());
		myGame.setPhysics(levelModel.getPhysicsEngine());
	}
	
	private void loadLevelObjectFromLevel(
			LevelCharacteristics levelCharacteristics) {
		LevelObject levelObject = new LevelObject(
				levelCharacteristics.getBackgroundImagePath(), myGame,
				levelCharacteristics);
		myGame.addLevelToEngine(levelObject);
		levelObject.update();
		double width = myGame.getProgramWidth();
		double height = myGame.getProgramHeight();
		int horizontalPaneCount = levelObject.getCharacteristics()
				.getHorizontalPaneCount();
		myGame.setProgramWidth(horizontalPaneCount * myGame.getProgramWidth());
		int verticalPaneCount = levelObject.getCharacteristics()
				.getVerticalPaneCount();
		myGame.setProgramHeight(verticalPaneCount * myGame.getProgramHeight());
		for (int i = 0; i < horizontalPaneCount; i++) {
			for (int j = 0; j < verticalPaneCount; j++) {
				levelObject.createBackgroundImageView(width, height);
				levelObject.getImage().relocate(i * width, j * height);
			}
		}
		
		levelObject.update();
	}

	private void loadSpriteObjectsFromLevel(
			Map<Integer, SpriteCharacteristics> spriteMap) {
		for (SpriteCharacteristics sc : spriteMap.values()) {
			ImageView imageView = new ImageView(sc.getImage());
			SpriteObject spriteObject = (SpriteObject) myGame.createSpriteToBeAdded(imageView,
					sc.getImagePath(),capitalize(sc.getObjectType().name()));
			spriteObject.setCharacteristics(sc);
			spriteObject.initializeImage();
			myGame.update(spriteObject);
		}
	}
	
	private String capitalize(String caps){
		return (caps.charAt(0)+"").toUpperCase()+(caps.substring(1).toLowerCase());
	}
	
	private void loadGoalObjectsFromLevel(
			Map<Integer, GoalCharacteristics> goalMap) {
		for (GoalCharacteristics goalChars : goalMap.values()) {
			GoalObject goalObject = new GoalObject(goalChars.getGoalType(),
					myGame);
			goalObject.setCharacteristics(goalChars);
		}
	}
}





