package com.print_stack_trace.voogasalad.controller.guiElements;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javafx.beans.property.SimpleObjectProperty;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class LevelTracker {
	private HashMap<LevelObject, HashSet<GameObject>> myLevels=new HashMap<LevelObject, HashSet<GameObject>>();
	private SimpleObjectProperty<LevelObject>currentLevel=new SimpleObjectProperty<LevelObject>(null);
	private SimpleObjectProperty<LevelObject>addLevel=new SimpleObjectProperty<LevelObject>(null);
	private SimpleObjectProperty<EventHandler> myAddEvent=new SimpleObjectProperty<EventHandler>(null);
	public LevelTracker(){

	}
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
	public HashSet<ImageView> getNonActiveLevels(){
		HashSet<ImageView> nonActiveLevels=new HashSet<ImageView>();
		for (LevelObject isActive: myLevels.keySet()){
			nonActiveLevels.add(isActive.getImage());
		}
		return nonActiveLevels;
	}
	public HashSet<Pane> getNonActiveColors(){
		HashSet<Pane> nonActiveLevels=new HashSet<Pane>();
		for (LevelObject isActive: myLevels.keySet()){
			nonActiveLevels.add(isActive.getColorPane());	
		}
		return nonActiveLevels;
	}
	public Set getLevels(){
		return   myLevels.keySet();
	}
	public void addSprite(SpriteObject sprite){
		myLevels.get(currentLevel.getValue()).add(sprite);
	}
	public HashSet<ImageView> removableSprites(){
		HashSet<ImageView> nonActiveSprites=new HashSet<ImageView>();
		for (LevelObject isActive: myLevels.keySet()){
			for (GameObject image: myLevels.get(isActive)){
				nonActiveSprites.add(image.getImage());
			}
		}
		return nonActiveSprites;
	}
	public HashSet<ImageView> activeSprites(){
		HashSet<ImageView> activeSprites=new HashSet<ImageView>();
		for (GameObject isActive: myLevels.get(currentLevel.getValue())){
				activeSprites.add(isActive.getImage());
		}
		return activeSprites;
	}
	public void removeSprite(SpriteObject sprite){
		myLevels.get(currentLevel.getValue()).remove(sprite);
	}


}
