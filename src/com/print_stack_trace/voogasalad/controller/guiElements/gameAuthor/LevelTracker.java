package com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.LevelObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.SpriteObject;

import javafx.beans.property.SimpleObjectProperty;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class LevelTracker {
	private HashMap<LevelObject, HashSet<GameObject>> myLevels=new HashMap<LevelObject, HashSet<GameObject>>();
	private SimpleObjectProperty<LevelObject>currentLevel=new SimpleObjectProperty<LevelObject>(null);
	private SimpleObjectProperty<LevelObject>addLevel=new SimpleObjectProperty<LevelObject>(null);
	private SimpleObjectProperty<EventHandler> myAddEvent=new SimpleObjectProperty<EventHandler>(null);
	public LevelTracker(){}
	public void addLevel(LevelObject newLevel, EventHandler myEvent){
		myLevels.put(newLevel, new HashSet<GameObject>());
		myAddEvent.setValue(myEvent);
		addLevel.setValue(newLevel);
		currentLevel.setValue(newLevel);
	}
	public LevelObject getCurrentLevel(){
		return currentLevel.getValue();
	}
	public SimpleObjectProperty<LevelObject> getAddLevelProperty(){
		return addLevel;
	}
	public SimpleObjectProperty<EventHandler> getEventProperty(){
		return myAddEvent;
	}
	public void setCurrentLevel(LevelObject newLevel){
		currentLevel.setValue(newLevel);
	}
	public SimpleObjectProperty<LevelObject> getCurrentLevelProperty(){
		return currentLevel;
	}
	
	private void  actionToLevelImages(ObjectAction action){
		for (LevelObject isActive: myLevels.keySet()){
			action.doAction(isActive.getImage());
			action.doAction(isActive.getColorPane());
			for (GameObject image: myLevels.get(isActive)){
				action.doAction(image.getImage());
			}
		}
	}
	public void actionToAllLevels(ObjectAction action){
		for (LevelObject isActive: myLevels.keySet()){
			action.doAction(isActive);
		}
	}
	public int getNumberOfLevels(){
		return myLevels.size();
	}
	public void addSprite(SpriteObject sprite){
		myLevels.get(currentLevel.getValue()).add(sprite);
	}
	public void clearNonActiveLevels(ObjectAction remove, ObjectAction add){
		actionToLevelImages(remove);
		currentLevelSprites(add);
	}
	public void currentLevelSprites(ObjectAction action){
		if (myLevels.size()!=0){
			for (GameObject isActive: myLevels.get(currentLevel.getValue())){
				action.doAction(isActive.getImage());
			}
		}		
	}
	public void removeSprite(SpriteObject sprite){
		myLevels.get(currentLevel.getValue()).remove(sprite);
	}
}
