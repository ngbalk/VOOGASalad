package com.print_stack_trace.voogasalad;

import com.print_stack_trace.voogasalad.view.GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VOOGASalad extends Application {

	@Override
	public void start(Stage arg0) throws Exception {
		Scene scene = GUI.init(58*12, 58*7);
		arg0.setScene(scene);
		arg0.show();
	}

}
