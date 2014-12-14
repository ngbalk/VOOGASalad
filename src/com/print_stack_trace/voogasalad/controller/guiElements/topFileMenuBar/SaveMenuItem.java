package com.print_stack_trace.voogasalad.controller.guiElements.topFileMenuBar;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import com.google.gson.JsonSyntaxException;
import com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor.ViewObjectDelegate;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GoalObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.LevelObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.SpriteObject;
import com.print_stack_trace.voogasalad.controller.guiElements.layout.AbstractViewDelegate;
import com.print_stack_trace.voogasalad.controller.popUpPanes.MessagePopUp;
import com.print_stack_trace.voogasalad.model.GameWorldCharacteristics;
import com.print_stack_trace.voogasalad.model.GoalCharacteristics;
import com.print_stack_trace.voogasalad.model.LevelCharacteristics;
import com.print_stack_trace.voogasalad.model.SpriteCharacteristics;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameWorldModel;
import com.print_stack_trace.voogasalad.model.engine.authoring.LevelModel;

public class SaveMenuItem extends AbstractMenuItem{
	public SaveMenuItem(String name){
		super(name);
	}
	public SaveMenuItem(String name, AbstractViewDelegate delegate, ViewObjectDelegate game){
		super(name, delegate, game);	
	}
	@Override
	public void doAction() {
		myGame.saveGame();
	}
}

	