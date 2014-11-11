/**
 * @author Pranava Raparla
 * @author Zachary Podbela
 * Date Created: 11/06/14
 * Date Modified: 11/07/14
 */
package com.print_stack_trace.voogasalad.controller;

import com.print_stack_trace.voogasalad.controller.author.GameAuthor;
import com.print_stack_trace.voogasalad.controller.player.GamePlayer;
import com.print_stack_trace.voogasalad.guiElements.GreenGUI;
import com.print_stack_trace.voogasalad.model.engine.GameEngine;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;

public class GUI {
	public static Scene init(double width, double height) {
		//Coded with help from: http://www.java2s.com/Code/Java/JavaFX/AddTabtoTabPane.htm
		TabController[] tabControllers = new TabController[2];
		tabControllers[0] = new GamePlayer();
		tabControllers[1] = new GreenGUI(width, height);
		String[] tabTitles = new String[2];
		tabTitles[0] = "Game Player";
		tabTitles[1] = "Level Builder";
		
		Group root = new Group();
		Scene scene = new Scene(root, width, height);
		GameEngine sharedGameEngine = new GameEngine();

        TabPane tabPane = new TabPane();
        BorderPane borderPane = new BorderPane();
        for (int i = 0; i < tabControllers.length; i++) {
            Tab tab = new Tab();
            tab.setText(tabTitles[i]);
            Group tabContent = tabControllers[i].initialize(sharedGameEngine);
            tab.setContent(tabContent);
            tabPane.getTabs().add(tab);
        }
        // bind to take available space
        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());
        borderPane.setCenter(tabPane);
        root.getChildren().add(borderPane);
		return scene;
	}
	
}