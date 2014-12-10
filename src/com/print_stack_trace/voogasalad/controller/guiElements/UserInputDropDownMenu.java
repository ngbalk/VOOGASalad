package com.print_stack_trace.voogasalad.controller.guiElements;

import java.util.Arrays;
import java.util.HashMap;

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
	public UserInputDropDownMenu(){
		myNode=new MenuBar();
		myMenuBar=(MenuBar)myNode;
		myMenuBar.getMenus().add(currentMenu);
		this.makeInitialNode();
	}
	public UserInputDropDownMenu(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
		myNode=new MenuBar();
		myMenuBar=(MenuBar)myNode;
		myMenuBar.getMenus().add(currentMenu);
		mySprite=object;
		this.makeInitialNode();
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
		this.currentMenu.getItems().add(currentMenuItem);
	}
	private String returnStringName(String value){
		String toReturn;
		if (canSplit(value))
			toReturn=Arrays.asList(value.split(";")).iterator().next();
		else
			toReturn=value;
		return toReturn;
	}
	protected String[] split(String value){
		return value.split(";");
	}
	protected boolean canSplit(String value){
		if (value.contains(";")){
			return true;
		}
		return false;
	}
	protected void checkCorrectMenu(CheckMenuItem currentItem, String menuName){
		for (MenuItem item: currentMenu.getItems()){
			((CheckMenuItem)item).setSelected(false);
		}
		currentItem.setSelected(true);
		this.linkMovement(menuName);
	}
	protected abstract void linkMovement(String dataValue);
}
