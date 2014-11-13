package Exceptions;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class VoogaExceptions {

	public static void displayError(String message){
		Stage errorStage = new Stage();
		errorStage.setWidth(500);
		errorStage.setHeight(200);
		errorStage.initStyle(StageStyle.UTILITY);
		Scene s = new Scene(new Group(new Text(20, 20, message)));
		errorStage.setScene(s);
		errorStage.show(); 
	}
	
}
