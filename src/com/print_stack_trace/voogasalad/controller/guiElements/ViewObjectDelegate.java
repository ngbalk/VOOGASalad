package com.print_stack_trace.voogasalad.controller.guiElements;

import java.util.HashSet;
import java.util.Set;

import javafx.beans.property.SimpleObjectProperty;

import com.print_stack_trace.voogasalad.model.engine.physics.SoloPhysicsGenerator.ProgramPhysicEngine;
import com.print_stack_trace.voogasalad.model.engine.runtime.camera.CameraFactory;
import com.print_stack_trace.voogasalad.model.engine.runtime.camera.CameraFactory.CameraType;

public interface ViewObjectDelegate {
	public void update(SpriteObject myObject);
	public void update(LevelObject myObject);
	public void update(GoalObject myObject);
	public void setCamera(CameraFactory.CameraType cameratype);
	public void setPhysics(ProgramPhysicEngine typeOfGravity);
	public void removeSpriteOBjects(SpriteObject myObject);
	public Set getLevelsAvailable();
	public void saveGame();
	public void deleteObject(SpriteObject object);
	public void extendRight();
	public void extendDown();
	public HashSet<GameObject> getCurrentLevelSprites();
	public SimpleObjectProperty<LevelObject> currentLevelProperty();
}
