package com.print_stack_trace.voogasalad.controller.guiElements;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

import javax.swing.JOptionPane;

public class DoubleJump extends UserInputDropDownMenu{
	public DoubleJump(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
		myResourceReader=new ResourceReader("./com/print_stack_trace/voogasalad/controller/guiResources/Boolean.Properties");
		data=myResourceReader.getProperties();
		addMenus();
	}

	@Override
	protected void linkMovement(String dataValue) {
		((SpriteObject)mySprite).getCharacteristics().setDoubleJump(Boolean.parseBoolean(dataValue));
		mySprite.getDelegate().update((SpriteObject)mySprite);
	}
	
	

}

