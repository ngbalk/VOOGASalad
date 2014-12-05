package com.print_stack_trace.voogasalad.controller.guiElements;

import java.io.InputStream;
import java.util.Properties;

import javax.swing.JOptionPane;

import javafx.css.CssMetaData;
import javafx.css.Styleable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class FileMenuBar extends MenuBar{
	private final String DEFAULT_MENU_NAMES="./com.print_stack_trace.voogasalad.controller.guiResources/";
	
	public FileMenuBar(){
		this.loadMenuNames();
	}
	
	private void loadMenuItems(Menu menuName){
		try {
			Properties prop = new Properties();
			InputStream stream = getClass().getClassLoader().getResourceAsStream("./com/print_stack_trace/voogasalad/controller/guiResources/FileMenuBarNames.Properties");
			prop.load(stream);
			for(Object menuItemName : prop.keySet()){
				String[] value=prop.getProperty((String) menuItemName).split(";");
				Class menuItemClass=Class.forName(value[1]);
				AbstractMenuItem myItem=(AbstractMenuItem) menuItemClass.getConstructor().newInstance();
				menuName.getItems().add(myItem);

			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "File for MENUBAR not Found");
		}
	}
	
	private void loadMenuNames(){
		try {
			Properties prop = new Properties();
			InputStream stream = getClass().getClassLoader().getResourceAsStream("./com/print_stack_trace/voogasalad/controller/guiResources/FileBarMenu.Properties");
			prop.load(stream);
			for(Object menuName : prop.keySet()){
				Menu myNewMenu=new Menu(prop.getProperty((String)menuName));
				
				this.getMenus().add(myNewMenu);
				loadMenuItems(myNewMenu);
			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "File not Found");
		}
		
	}
}
