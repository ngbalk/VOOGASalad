package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.goal;


import java.util.HashMap;
import java.util.Iterator;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GoalObject;
import com.print_stack_trace.voogasalad.controller.guiElements.resourceReader.ResourceReader;
import com.print_stack_trace.voogasalad.controller.popUpPanes.MessagePopUp;


public class GoalReachDistance extends GoalCharacteristicController {
	private String direction;
	public GoalReachDistance(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
		direction=new MessagePopUp(myStyle).showDropDownDialog("Pick the Directon: ", getResource());
	}
	@Override
	protected void populateDefaultText() {
		this.setObservable(((GoalObject) mySprite).getPointsProperty());
	}

	@Override
	protected void setCharacteristic(String newValue) {
		double dest = ((GoalObject)mySprite).getCharacteristics().getDestination();
		try{
			dest =Double.parseDouble(newValue);
		}
		catch(NumberFormatException e){
			new MessagePopUp().showMessageDialog("NOT A NUMBER");
		}
		if (direction.equals("UP") || direction.equals("DOWN")){
			((GoalObject) mySprite).getCharacteristics().setHorizontalDestination(false);
			((GoalObject)mySprite).getCharacteristics().setDestination(dest);
		}
		else {
			((GoalObject) mySprite).getCharacteristics().setHorizontalDestination(true);
			((GoalObject)mySprite).getCharacteristics().setDestination(dest);
		}		
		mySprite.update();
	}

	private String[] getResource(){
		ResourceReader myResourceReader=new ResourceReader("./com/print_stack_trace/voogasalad/controller/guiResources/TypeOfDistancesToReach.Properties");
		HashMap<String, String> myDataMap=myResourceReader.getProperties();
		Iterator<String> myIterator=myDataMap.keySet().iterator();
		String[] menuNames=new String[myDataMap.keySet().size()];
		for (int i=0; i<menuNames.length; i++){
			menuNames[i]=myIterator.next();
		}
		return menuNames;
	}

}

