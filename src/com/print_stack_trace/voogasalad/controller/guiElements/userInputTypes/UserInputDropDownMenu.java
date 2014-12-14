package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes;

import java.util.Arrays;
import java.util.HashMap;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;

import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public abstract class UserInputDropDownMenu extends UserInputType{
	protected HashMap<String, String> data=new HashMap<String, String>();
	protected MenuBar myMenuBar;
	protected Menu currentMenu=new Menu("\t\t\t");
	protected HashMap<String, CheckMenuItem> menuMap=new HashMap<String, CheckMenuItem>();
	public UserInputDropDownMenu(){
		setUpDropDownMenu();
		makeInitialNode();
	}
	
	public UserInputDropDownMenu(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
		setUpDropDownMenu();
		mySprite=object;
		this.makeInitialNode();
	}
	private void setUpDropDownMenu(){
		myNode=new MenuBar();
		myMenuBar=(MenuBar)myNode;
		myMenuBar.getMenus().add(currentMenu);
	}
	protected void setCurrent(String myName){
		currentMenu.setText(myName);
	}
	
	protected void addMenus(){
		for (String menuName: data.keySet()){
			addMenu(menuName);
		}
	}
	
	protected void addMenu(String menuName){
		CheckMenuItem currentMenuItem=new CheckMenuItem(returnStringName(data.get(menuName)));
		currentMenuItem.setOnAction(e->checkCorrectMenu(currentMenuItem,menuName));
		menuMap.put(menuName, currentMenuItem);
		currentMenu.getItems().add(currentMenuItem);
	}
	
	private String returnStringName(String value){
		String toReturn = value;
		if (canSplit(value))
			toReturn=Arrays.asList(value.split(";")).iterator().next();
		return toReturn;
	}
	
	protected String[] split(String value){
		return value.split(";");
	}
	
	protected boolean canSplit(String value){
		return value.contains(";");
	}
	
	protected void checkCorrectMenu(CheckMenuItem currentItem, String menuName){
		for (MenuItem item: currentMenu.getItems()){
			((CheckMenuItem)item).setSelected(false);
		}
		currentItem.setSelected(true);
		linkMovement(menuName);
	}
	
	protected abstract void linkMovement(String dataValue);
	
	protected void checkSelectBox(String name){
		menuMap.get(name).setSelected(true);
		setCurrent(data.get(name));
	}
	
	protected void uncheckSelectBox(String name){
		menuMap.get(name).setSelected(false);
	}
}
