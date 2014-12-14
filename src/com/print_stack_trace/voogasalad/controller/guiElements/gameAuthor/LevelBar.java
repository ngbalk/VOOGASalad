package com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor;

import java.util.HashMap;
import java.util.HashSet;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.LevelObject;
import com.print_stack_trace.voogasalad.controller.guiElements.resourceReader.ResourceReader;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class LevelBar extends MenuBar{
	private Menu levelMenu;
	private HashMap<LevelObject, MenuItem> myLevelMap=new HashMap<LevelObject, MenuItem>();
	SimpleObjectProperty<EventHandler> addEventProperty=new SimpleObjectProperty<EventHandler>();
	private String DEFAULT_RESOURCE="./com/print_stack_trace/voogasalad/controller/guiResources/MenuAndButtonLabels.Properties";
	private HashMap<String, String> myResource;
	
	public LevelBar (double x, double y,double width, double height, SimpleObjectProperty<LevelObject> currentLevel,
			SimpleObjectProperty<LevelObject> addLevel, SimpleObjectProperty<EventHandler> myEvent, SimpleObjectProperty<String> name){
		this.setPrefSize(width, height);
		this.relocate(x, y);
		myResource=new ResourceReader(DEFAULT_RESOURCE).getProperties();
		addEventProperty=myEvent;
		addProperty(currentLevel, (type)->currentLevel(type));
		addProperty(addLevel, (type)->add(type));
		changeName(name);
		levelMenu=new Menu(myResource.get("level"));
		this.getMenus().add(levelMenu);
	}

	private void add(Object myObject){
		LevelObject current=(LevelObject) myObject;
		MenuItem myLevel=new MenuItem(current.getCharacteristics().getName());
		myLevel.setOnAction(addEventProperty.getValue());
		levelMenu.getItems().add(myLevel);
		myLevelMap.put(current, myLevel);
	}
	
	private void changeName(SimpleObjectProperty name){
		name.addListener(new ChangeListener<String>(){

			@Override
			public void changed(ObservableValue<? extends String> arg0,
					String old, String current) {
				for (LevelObject level: myLevelMap.keySet()){
					if (level.getCharacteristics().getName().equals(current)){
						levelMenu.setText(current);
						myLevelMap.get(level).setText(level.getCharacteristics().getName());
					}
				}
				
			}
		});
	}

	private void currentLevel(Object myObject){
		LevelObject current=(LevelObject) myObject;
		myLevelMap.get(current).setText(current.getCharacteristics().getName());
		levelMenu.setText(myLevelMap.get(current).getText());
	}

	private void addProperty(SimpleObjectProperty prop, ObjectAction action){
		prop.addListener(new ChangeListener<LevelObject>(){
			@Override
			public void changed(ObservableValue<? extends LevelObject> arg0,
					LevelObject arg1, LevelObject current) {
				action.doAction(current);
			}
		});
	}
}
