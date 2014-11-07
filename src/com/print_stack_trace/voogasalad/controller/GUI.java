/**
 * @author Pranava Raparla
 * @author Zachary Podbella
 * Date Created: 11/06/14
 * Date Modified: 11/06/14
 */
package com.print_stack_trace.voogasalad.controller;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class GUI {
	public static Scene init(double width, double height) {
		Group root = new Group();
		root.getChildren().add(new TabPane());
		Scene myScene = new Scene(root, width, height);
		return myScene;
	}
}