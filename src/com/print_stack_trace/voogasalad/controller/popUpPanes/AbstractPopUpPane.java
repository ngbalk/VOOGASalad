package com.print_stack_trace.voogasalad.controller.popUpPanes;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;

import javafx.scene.layout.Pane;
public class AbstractPopUpPane extends Pane {
	private GameObject myData;
	public AbstractPopUpPane(GameObject gameObject){
		myData=gameObject;
	}
	private void loadData(){
		
	}
}
