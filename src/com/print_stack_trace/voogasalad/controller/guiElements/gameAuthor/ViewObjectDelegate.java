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
	
	/**
	 * updates the SpriteObject in however way the class
	 * that implements ViewObjectDelegate decides.
	 * @param myObject	the Spriteobject to be updated 
	 * 
	 */
	void update(SpriteObject myObject);
	
	/**
	 * updates the LevelObject in however way the class
	 * that implements ViewObjectDelegate decides.
	 * @param myObject	the LevelObject to be updated 
	 * 
	 */
	void update(LevelObject myObject);
	
	/**
	 * updates the GoalObject in however way the class
	 * that implements ViewObjectDelegate decides.
	 * @param myObject	the GoalObject to be updated 
	 * 
	 */
	void update(GoalObject myObject);
	
	/**
	 * Sets the type of camera for the level
	 * @param cameraType 	type of camera to be set
	 * 
	 */
	void setCamera(CameraType cameraType);
	
	/**
	 * Sets the type of ProgramPhysicsEngine for the level
	 * @param typeOfGravity type of ProgramPhysicsEngine to be set
	 * 
	 */
	void setPhysics(ProgramPhysicEngine typeOfGravity);
	
	/**
	 * Removes the SpriteObject from a map of SpriteObjects
	 * @param myObject	SpriteObject to be removed
	 * 
	 */
	void removeSpriteObjects(SpriteObject myObject);
	
	/**
	 * Saves the level
	 * 
	 */
	void saveGame();
	
	/**
	 * Removes the SpriteObject from the level completely
	 * @param myObject	SpriteObject to be removed
	 * 
	 */
	void deleteObject(SpriteObject object);
	
	/**
	 * Extends the gamePane to the right
	 */
	void extendRight();
	
	/**
	 * Extends the gamePane down
	 * 
	 */
	void extendDown();
	/**
	 * Extends the gamePane up
	 */
	void extendUp();
	
	/**
	 * 
	 * @return the property value of the current Level
	 */
	public SimpleObjectProperty<LevelObject> currentLevelProperty();
	
	/**
	 * Does an action to all the sprites of a current level
	 * @param action The action to be done
	 */
	void actionToCurrentLevelSprites(ObjectAction action);
	
	/**
	 * Does an action to all sprites in the game
	 * @param object	the action to be done
	 */
	void actionToAllLevels(ObjectAction object);
	
	/**
	 * Sets the type of PhysicsEngine for the level
	 * @param physicsEngine type of PhysicsEngine to be set
	 * 
	 */
	void setPhysics(PhysicsEngine physicsEngine);
	
	/**
	 * Loads in a file (saved level) to be loaded by the gameAuthor
	 * @param file	file to be loaded
	 * @return
	 */
	Object load(File file);
	
	/**
	 * Adds a level to the game authoring environment and game
	 * @param level	level to be added
	 * 
	 */
	void addLevelToEngine(Object level);
	
	//accessors and mutators of gamePane width and height
	double getProgramHeight();
	double getProgramWidth();
	void setProgramHeight(Number width);
	void setProgramWidth(Number height);
	
	/**
	 * Adds a sprite to the game
	 * @param sprite		the sprite's imageView
	 * @param imgPath		the image path of the sprite's image
	 * @param type			the String of the type of sprite
	 * @return				the SpriteObject that is added
	 */
	Object createSpriteToBeAdded(ImageView sprite, String imgPath, String type);
	
	/**
	 * sets a node to be the background of the game
	 * @param level		Node to be set as the background
	 */
	void addBackground(Node level);
	
	/**
	 * Adds a new level to the game
	 * @param level level to be added
	 */
	void addNewLevel(Object level);
	
	/**
	 * Sets the GameWorldCharacteristics in the GameEngine
	 * @param gameWorld	GameWorldObject to be updated
	 */
	void update(GameWorldObject gameWorld);
}
