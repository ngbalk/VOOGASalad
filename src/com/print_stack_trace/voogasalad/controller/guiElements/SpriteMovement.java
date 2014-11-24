package com.print_stack_trace.voogasalad.controller.guiElements;

import java.util.HashMap;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class SpriteMovement extends UserInputDropDownMenu{
	private HashMap<String, String> movements=new HashMap<String, String>();
	public enum PossibleSpriteAction {UP, DOWN, RIGHT, LEFT, JUMP, CROUCH}
	public SpriteMovement(GameObject sprite){
		super(sprite);
		currentMenu.setText("Pick Types of Movement");
		myResourceReader=new ResourceReader("./com/print_stack_trace/voogasalad/"
				+ "controller/guiResources/MovementTypes.Properties");
		movements=myResourceReader.getProperties();
		addMenus();
	}
	protected void addMenus(){
		for (String menuName: movements.keySet()){
			CheckMenuItem currentMenuItem=new CheckMenuItem(movements.get(menuName));
			currentMenuItem.setOnAction(e->linkMovement(movements.get(menuName)));
			this.currentMenu.getItems().add(currentMenuItem);
		}
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
	private void linkMovement(String movementType){
		Stage myStage=new Stage();
		myStage.setHeight(175);
		myStage.setWidth(305);
		Scene myNewScene=new Scene(makePopUpPane(movementType, myStage), 305,175);
		myStage.setScene(myNewScene);
		myStage.show();
		System.out.println(mySprite.getDelegate());
		mySprite.getDelegate().update((SpriteObject)mySprite);
	}
	private void linkKeys(String type, KeyCode key, Stage keyStage){
		keyStage.close();
		//how to link
		PossibleSpriteAction mySpriteAction=null;
		for (PossibleSpriteAction myAction: PossibleSpriteAction.values()){
			if (myAction.name().equals(type))
				mySpriteAction=myAction;
		}
		((SpriteObject)mySprite).getCharacteristics().addMovement(mySpriteAction, key);
		mySprite.getDelegate().update((SpriteObject)mySprite);
	}
	private Pane makePopUpPane(String movementType, Stage stage){
		Pane smallPane=new Pane();
		smallPane.setStyle("-fx-background-color: BLACK");
		Label movementLabel=new Label("    Pick the Key for the Movement");
		movementLabel.setPrefSize(290, 100);
		movementLabel.setTextAlignment(TextAlignment.CENTER);
		movementLabel.relocate(0, 0);
		movementLabel.getStylesheets().add("./com/print_stack_trace/voogasalad/controller/guiResources/SpritePane.css");
		movementLabel.getStyleClass().add("keylabel1");
		MenuBar moveMentFunction=new MenuBar();
		moveMentFunction.setPrefWidth(290);
		moveMentFunction.setPrefHeight(75);
		moveMentFunction.relocate(0, 100);
		Menu myMovement=new Menu("Key Options");
		addKeyMenus(movementType, myMovement, stage);
		moveMentFunction.getMenus().addAll(myMovement);
		smallPane.getChildren().addAll(movementLabel, moveMentFunction);
		return smallPane;
	}
	 
}
