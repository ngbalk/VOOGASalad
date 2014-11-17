package com.print_stack_trace.voogasalad.controller.guiElements;

import java.io.InputStream;
import java.util.Properties;

import javax.swing.JOptionPane;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MultipleLibraryPane extends TabPane{
	private double myWidth;
	private double myHeight;
	private String DEFAULT_RESOURCE="./com/print_stack_trace/voogasalad/controller/guiResources/Tabs.Properties";
	public MultipleLibraryPane(Number width, Number height) {
		myWidth=(double) width;
		myHeight=(double) height;
		loadAndAddTabs();
	}
	private void loadAndAddTabs(){
		try {
			Properties prop = new Properties();
			InputStream stream = getClass().getClassLoader().getResourceAsStream(DEFAULT_RESOURCE);
			prop.load(stream);
			for(Object pictureName : prop.keySet()){
				Tab myNewTab=new Tab();
				myNewTab.setText((String) pictureName);
				Class myClass=Class.forName(prop.getProperty((String) pictureName));
				AbstractLibraryPane myLibrary=(AbstractLibraryPane) myClass.getConstructor(Number.class, Number.class, String.class).newInstance(myWidth, myHeight, null);
				myNewTab.setContent(myLibrary);
				this.getTabs().add(myNewTab);
			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "File not found");
		}
	}
	
}
