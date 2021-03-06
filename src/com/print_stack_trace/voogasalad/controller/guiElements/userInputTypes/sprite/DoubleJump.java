package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.sprite;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

import javax.swing.JOptionPane;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.SpriteObject;
import com.print_stack_trace.voogasalad.controller.guiElements.resourceReader.ResourceReader;
import com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.UserInputDropDownMenu;

public class DoubleJump extends BooleanController{
	public DoubleJump(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
	}
	@Override
	protected void linkMovement(String dataValue) {
		((SpriteObject)mySprite).getCharacteristics().setDoubleJump(Boolean.parseBoolean(dataValue));
		setCurrent(data.get(dataValue));
		mySprite.getDelegate().update((SpriteObject)mySprite);
	}
	protected Object getCharacteristicType(){
		return ((SpriteObject) mySprite).getCharacteristics().canDoubleJump();
	}
	@Override
	protected void loadData() {
		myResourceReader=new ResourceReader("./com/print_stack_trace/voogasalad/controller/guiResources/Boolean.Properties");
		data=myResourceReader.getProperties();		
	}
	
}

