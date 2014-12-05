package com.print_stack_trace.voogasalad.controller.guiElements;

import java.util.Set;

import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.CameraType;
import com.print_stack_trace.voogasalad.model.engine.physics.SoloPhysicsGenerator.ProgramPhysicEngine;

public interface ViewObjectDelegate {
	public void update(SpriteObject myObject);
	public void update(LevelObject myObject);
	public void update(GoalObject myObject);
	public void setCamera(CameraType cameratype);
	public void setPhysics(ProgramPhysicEngine typeOfGravity);
	public void removeSpriteOBjects(SpriteObject myObject);
	public Set getLevelsAvailable();
	public void saveGame();
}
