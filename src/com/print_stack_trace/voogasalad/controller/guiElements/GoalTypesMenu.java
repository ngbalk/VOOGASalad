package com.print_stack_trace.voogasalad.controller.guiElements;

import java.util.HashMap;

import com.print_stack_trace.voogasalad.model.environment.GoalFactory.GoalType;

import javafx.scene.control.CheckMenuItem;

public class GoalTypesMenu extends UserInputDropDownMenu {
	private HashMap<String, String> myGoals=new HashMap<String, String>();
	public GoalTypesMenu(GameObject myObject){
		super(myObject);
		myResourceReader=new ResourceReader("./com/print_stack_trace/voogasalad/controller/guiResources/GoalTypes.Properties");
		myGoals=myResourceReader.getProperties();
		addMenus();
	}
	public void addMenus(){
		for (String menuName: myGoals.keySet()){
			CheckMenuItem currentMenuItem=new CheckMenuItem(myGoals.get(menuName));
			currentMenuItem.setOnAction(e->linkAction(myGoals.get(menuName)));
			this.currentMenu.getItems().add(currentMenuItem);
		}
	}
	public void linkAction(String myName){
		for (GoalType name: GoalType.values()){
			if (name.name().equals(myName)){
				((GoalObject) mySprite).setCharacteristics(name);
				mySprite.getDelegate().update((GoalObject)mySprite);
				this.setCurrent(myName);
			}
		}
	}
	

}
