package com.print_stack_trace.voogasalad.controller.guiElements;

import java.util.HashMap;
import java.util.HashSet;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class LevelBar extends MenuBar{
	private Menu levelMenu;
	private HashMap<LevelObject, MenuItem> myLevelMap=new HashMap<LevelObject, MenuItem>();
	private SimpleObjectProperty<LevelObject> myCurrentLevel=new SimpleObjectProperty<LevelObject>();
	private SimpleObjectProperty<LevelObject> myAddLevel=new SimpleObjectProperty<LevelObject>();
	private SimpleObjectProperty<EventHandler> myAddEvent=new SimpleObjectProperty<EventHandler>();
	public LevelBar (double x, double y,double width, double height, SimpleObjectProperty<LevelObject> currentLevel,
			SimpleObjectProperty<LevelObject> addLevel, SimpleObjectProperty<EventHandler> myEvent){
		this.setPrefSize(width, height);
		this.relocate(x, y);
		myAddLevel=addLevel;
		addLevel();
		myCurrentLevel=currentLevel;
		myAddEvent=myEvent;
		currentLevelProperty();
		levelMenu=new Menu("Levels");
		this.getMenus().add(levelMenu);
	}
	public void addLevel(){
		myAddLevel.addListener(new ChangeListener<LevelObject>(){
			@Override
			public void changed(ObservableValue<? extends LevelObject> arg0,
					LevelObject arg1, LevelObject current) {
				MenuItem myLevel=new MenuItem(current.getCharacteristics().getName());
				myLevel.setOnAction(myAddEvent.getValue());
				levelMenu.getItems().add(myLevel);
				myLevelMap.put(current, myLevel);
			}
		});
	}
	private void currentLevelProperty(){
		myCurrentLevel.addListener(new ChangeListener<LevelObject>(){

			@Override
			public void changed(ObservableValue<? extends LevelObject> arg0,
					LevelObject arg1, LevelObject current) {
				myLevelMap.get(current).setText(current.getCharacteristics().getName());
				levelMenu.setText(myLevelMap.get(current).getText());
			}
		});
	}
}
