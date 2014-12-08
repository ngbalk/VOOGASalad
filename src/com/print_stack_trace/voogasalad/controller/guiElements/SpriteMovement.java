package com.print_stack_trace.voogasalad.controller.guiElements;

import java.util.HashMap;

import com.print_stack_trace.voogasalad.model.engine.runtime.keyboard.KeyApplicatorFactory.KeyResult;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class SpriteMovement extends UserInputDropDownMenu{
	
	public SpriteMovement(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
		currentMenu.setText("Pick Types of Movement");
		myResourceReader=new ResourceReader("./com/print_stack_trace/voogasalad/"
				+ "controller/guiResources/MovementTypes.Properties");
		data=myResourceReader.getProperties();
		addMenus();
	}
	private void addKeyMenus(String movementType, Menu current, Stage keyStage){
		for (KeyCode key: KeyCode.values()){
			if (key.isArrowKey()||key.isLetterKey()){
			CheckMenuItem currentMenuItem=new CheckMenuItem(key.getName());
			current.getItems().add(currentMenuItem);
			currentMenuItem.setOnAction(e->linkKeys(movementType, key, keyStage));
			}
		}
	}
	protected void linkMovement(String movementTypeName){
		String movementType=data.get(movementTypeName);
		Stage myStage=new Stage();
		myStage.setHeight(100);
		myStage.setWidth(305);
		Scene myNewScene=new Scene(makePopUpPane(movementType, myStage), 305,175);
		myStage.setScene(myNewScene);
		myStage.show();
		mySprite.getDelegate().update((SpriteObject)mySprite);
	}
	private void linkKeys(String type, KeyCode key, Stage keyStage){
		keyStage.close();
		KeyResult mySpriteAction=null;
		for (KeyResult myAction: KeyResult.values()){
			if (myAction.name().trim().equals(type.trim()))
				mySpriteAction=myAction;
		}
		((SpriteObject)mySprite).getCharacteristics().addMovement(mySpriteAction, key);
		mySprite.getDelegate().update((SpriteObject)mySprite);
	}
	private Pane makePopUpPane(String movementType, Stage stage){
		VBox smallPane=new VBox();
		smallPane.setStyle("-fx-background-color: BLACK");
		Label movementLabel=new Label(" Pick the Key for the Movement");
		movementLabel.setPrefSize(290, 70);
		movementLabel.setTextAlignment(TextAlignment.CENTER);
		//movementLabel.relocate(0, 0);
		movementLabel.getStylesheets().add("./com/print_stack_trace/voogasalad/controller/guiResources/SpritePane.css");
		movementLabel.getStyleClass().add("keylabel1");
		MenuBar moveMentFunction=new MenuBar();
		//moveMentFunction.relocate(0, 70);
		moveMentFunction.setPrefWidth(290);
		moveMentFunction.setPrefHeight(75);
		moveMentFunction.getStylesheets().add("./com/print_stack_trace/voogasalad/controller/guiResources/SpritePane.css");
		Menu myMovement=new Menu("Key Options");
		addKeyMenus(movementType, myMovement, stage);
		moveMentFunction.getMenus().addAll(myMovement);
		smallPane.getChildren().addAll(movementLabel, moveMentFunction);
		return smallPane;
	}
	 
}
