package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.sprite;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.SpriteObject;
import com.print_stack_trace.voogasalad.controller.guiElements.resourceReader.ResourceReader;
import com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.UserInputDropDownMenu;

public class GravityEffect extends BooleanController{
	public GravityEffect(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
	}

	@Override
	protected void linkMovement(String dataValue) {
		((SpriteObject)mySprite).getCharacteristics().setInteractive(Boolean.parseBoolean(dataValue));
		setCurrent(data.get(dataValue));
		mySprite.getDelegate().update((SpriteObject)mySprite);
	}
	@Override
	protected void loadData() {
		myResourceReader=new ResourceReader("./com/print_stack_trace/voogasalad/controller/guiResources/Boolean.Properties");
		data=myResourceReader.getProperties();
	}
	@Override
	protected Object getCharacteristicType() {
		return ((SpriteObject) mySprite).getCharacteristics().isInteractive();
		
	}
}
