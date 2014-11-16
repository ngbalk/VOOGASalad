package com.print_stack_trace.voogasalad.guiElements;
import javafx.scene.layout.Pane;
import com.print_stack_trace.voogasalad.controller.author.Sprite;
public class AbstractPopUpPane extends Pane {
	private GameObject myData;
	public AbstractPopUpPane(GameObject gameObject){
		myData=gameObject;
	}
	private void loadData(){
		
	}
}
