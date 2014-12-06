package com.print_stack_trace.voogasalad.controller.guiElements;

import java.util.HashMap;
import java.util.HashSet;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class LevelBar extends MenuBar{
	private Menu levelMenu;
	private HashMap<LevelObject, MenuItem> myLevelMap=new HashMap<LevelObject, MenuItem>();
	private LevelObject currentLevel;
	public LevelBar (double x, double y,double width, double height){
		this.setPrefSize(width, height);
		this.relocate(x, y);
		levelMenu=new Menu("Levels");
		this.getMenus().add(levelMenu);
	}
	public MenuItem addLevel(String myName, LevelObject currentLevel){
		MenuItem myLevel=new MenuItem(myName);
		levelMenu.getItems().add(myLevel);
		myLevelMap.put(currentLevel, myLevel);
		return myLevel;
	}
	public void setCurrentLevel(LevelObject current){
		currentLevel=current;
		myLevelMap.get(current).setText(current.getCharacteristics().getName());
		levelMenu.setText(myLevelMap.get(current).getText());
	}
	public LevelObject getCurrentLevel(){
		return currentLevel;
	}
	public HashSet<ImageView> getNonActiveLevels(){
		HashSet<ImageView> nonActiveLevels=new HashSet<ImageView>();
		for (LevelObject isActive: myLevelMap.keySet()){
			
				nonActiveLevels.add(isActive.getImage());
			
		}
		return nonActiveLevels;
	}
	public HashSet<Pane> getNonActiveColors(){
		HashSet<Pane> nonActiveLevels=new HashSet<Pane>();
		for (LevelObject isActive: myLevelMap.keySet()){
				nonActiveLevels.add(isActive.getColorPane());	
		}
		return nonActiveLevels;
	}
	public HashSet getLevels(){
		return  (HashSet) myLevelMap.keySet();
	}
}
