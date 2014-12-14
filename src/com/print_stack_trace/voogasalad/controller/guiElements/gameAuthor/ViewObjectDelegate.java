package com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameWorldObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GoalObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.LevelObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.SpriteObject;
import com.print_stack_trace.voogasalad.model.engine.physics.PhysicsEngine;
import com.print_stack_trace.voogasalad.model.engine.physics.SoloPhysicsGenerator.ProgramPhysicEngine;
import com.print_stack_trace.voogasalad.model.engine.runtime.camera.CameraFactory;
import com.print_stack_trace.voogasalad.model.engine.runtime.camera.CameraFactory.CameraType;

public interface ViewObjectDelegate {
	void update(SpriteObject myObject);
	void update(LevelObject myObject);
	void update(GoalObject myObject);
	void setCamera(CameraFactory.CameraType cameratype);
	void setPhysics(ProgramPhysicEngine typeOfGravity);
	void removeSpriteObjects(SpriteObject myObject);
	void saveGame();
	void deleteObject(SpriteObject object);
	void extendRight();
	void extendDown();
	void extendUp();
	public SimpleObjectProperty<LevelObject> currentLevelProperty();
	void actionToCurrentLevelSprites(ObjectAction action);
	void actionToAllLevels(ObjectAction object);
	void setPhysics(PhysicsEngine physicsEngine);
	Object load(File file);
	void addLevelToEngine(Object level);
	double getProgramHeight();
	double getProgramWidth();
	void setProgramHeight(Number width);
	void setProgramWidth(Number height);
	Object createSpriteToBeAdded(ImageView sprite, String imgPath, String type);
	void addBackground(Node level);
	void addNewLevel(Object level);
	void update(GameWorldObject gameWorld);
}
