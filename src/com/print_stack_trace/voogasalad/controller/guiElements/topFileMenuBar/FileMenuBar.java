package com.print_stack_trace.voogasalad.controller.guiElements.topFileMenuBar;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor.ViewObjectDelegate;
import com.print_stack_trace.voogasalad.controller.guiElements.layout.AbstractViewDelegate;
import com.print_stack_trace.voogasalad.controller.guiElements.resourceReader.ResourceReader;
import com.print_stack_trace.voogasalad.controller.popUpPanes.MessagePopUp;
import com.print_stack_trace.voogasalad.utilities.reflection.Reflection;

import javafx.css.CssMetaData;
import javafx.css.Styleable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class FileMenuBar extends MenuBar{
	private final String DEFAULT_MENU_NAMES="./com.print_stack_trace.voogasalad.controller.guiResources/";
	private AbstractViewDelegate myDelegate;
	private ViewObjectDelegate myGame;
	public FileMenuBar(AbstractViewDelegate delegate, ViewObjectDelegate game){
		myDelegate=delegate;
		myGame=game;
		this.loadMenuNames();
	}

	private void loadMenuItems(Menu menuName){
		HashMap<String, String> resources=new ResourceReader
				("./com/print_stack_trace/voogasalad/controller/guiResources/FileMenuBarNames.Properties").getProperties();
		for(String menuItemName : resources.keySet()){
			String[] value=resources.get(menuItemName).split(";");
			if (value[0].equals(menuName.getText())){
				new Reflection();
				AbstractMenuItem myItem=(AbstractMenuItem) Reflection.createInstance(value[2],
						value[1], myDelegate, myGame);
				menuName.getItems().add(myItem);
			}
		}
	}

	private void loadMenuNames(){
		HashMap<String, String> resources=new ResourceReader(
				"./com/print_stack_trace/voogasalad/controller/guiResources/FileBarMenu.Properties").getProperties();
		for(String name : resources.keySet()){
			Menu myNewMenu=new Menu(resources.get(name));
			getMenus().add(myNewMenu);
			loadMenuItems(myNewMenu);
		}
	}
}
