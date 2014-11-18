package com.print_stack_trace.voogasalad.controller.guiElements;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class LevelBar extends MenuBar{
	public LevelBar (double x, double y,double width, double height){
		this.setPrefSize(width, height);
		this.relocate(x, y);
		Menu levelMenu=new Menu("Levels");
		this.getMenus().add(levelMenu);
	}
	public void addLevel(){
		MenuItem myLevel=new MenuItem();
		//TO DO IMPLEMENT
	}
}
