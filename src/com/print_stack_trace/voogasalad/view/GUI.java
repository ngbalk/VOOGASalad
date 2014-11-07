package com.print_stack_trace.voogasalad.view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUI {
	public static Scene init(double width, double height) {
		Group root = new Group();
		//TODO: @pdiddy Add Tab Pane to root, and then tabs
		Scene myScene = new Scene(root, width, height);
		return myScene;
	}
}