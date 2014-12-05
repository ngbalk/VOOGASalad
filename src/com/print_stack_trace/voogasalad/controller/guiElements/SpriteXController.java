package com.print_stack_trace.voogasalad.controller.guiElements;

public class SpriteXController extends SpriteCharacteristicController{
	public SpriteXController (GameObject sprite){
		super(sprite);
	}
	@Override
	public void setCharacteristic(String newValue){
		double newXValue = mySprite.getImage().getLayoutX();
		try{
			newXValue = Double.parseDouble(newValue);
		}
		catch(NumberFormatException e){
			
		}
		((SpriteObject)mySprite).setMyX(newXValue);
	}
	@Override
	protected void populateDefaultText() {
		this.setObservable(((SpriteObject) mySprite).getObservableX());
	}
}
