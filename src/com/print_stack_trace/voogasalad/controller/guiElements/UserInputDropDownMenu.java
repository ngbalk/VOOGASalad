package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

public class UserInputDropDownMenu extends UserInputType{
	protected MenuBar myMenuBar;
	protected Menu currentMenu=new Menu("\t\t\t");
	protected ResourceReader myResourceReader;
	public UserInputDropDownMenu(){
		myNode=new MenuBar();
		myMenuBar=(MenuBar)myNode;
		myMenuBar.getMenus().add(currentMenu);
	}
	public UserInputDropDownMenu(GameObject object){
		this();
		mySprite=object;
	}
	protected void addMenus(){};
	protected void setCurrent(String myName){
		currentMenu.setText(myName);
	}
}
