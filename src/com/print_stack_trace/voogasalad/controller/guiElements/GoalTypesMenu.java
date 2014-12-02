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
	
	protected void linkMovement(String myName){
		for (GoalType name: GoalType.values()){
			if (name.name().equals(myName)){
				((GoalObject) mySprite).setCharacteristics(name);
				mySprite.getDelegate().update((GoalObject)mySprite);
				this.setCurrent(myName);
			}
		}
	}
	

}
