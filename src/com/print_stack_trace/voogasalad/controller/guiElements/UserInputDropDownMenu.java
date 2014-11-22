package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.scene.control.MenuBar;

public class UserInputDropDownMenu extends UserInputType{
	public UserInputDropDownMenu(){
		myNode=new MenuBar();
	}
	public UserInputDropDownMenu(GameObject object){
		this();
		mySprite=object;
	}
}
