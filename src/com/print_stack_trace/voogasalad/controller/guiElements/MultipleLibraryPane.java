package com.print_stack_trace.voogasalad.controller.guiElements;

import java.io.InputStream;
import java.util.Properties;

import javax.swing.JOptionPane;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class MultipleLibraryPane extends TabPane{
	private double myWidth;
	private double myHeight;
	private Pane myMainPane;
	private String DEFAULT_RESOURCE="./com/print_stack_trace/voogasalad/controller/guiResources/Tabs.Properties";
	private String STYLE_RESOURCE="./com/print_stack_trace/voogasalad/controller/guiResources/SpritePane.css";
	public MultipleLibraryPane(Number width, Number height, Pane gamePane) {
		myWidth=width.doubleValue();
		myHeight= height.doubleValue();
		myMainPane=gamePane;
		loadAndAddTabs();
		this.getStylesheets().add(STYLE_RESOURCE);
		this.getStyleClass().add("tabPaneTemplate");
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
				AbstractLibraryPane myLibrary=(AbstractLibraryPane) myClass.getConstructor(Number.class, Number.class, Pane.class).newInstance(myWidth, myHeight, myMainPane);
				ScrollBarPane myPane=new ScrollBarPane(myWidth, myHeight, myLibrary);
				myNewTab.setContent(myPane);
				myNewTab.setClosable(false);
				myNewTab.getStyleClass().add("tabTemplate");
				myNewTab.getStyleClass().add("tabLabelTemplate");
				this.getTabs().add(myNewTab);
			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "File not found");
		}
	}
	
}
