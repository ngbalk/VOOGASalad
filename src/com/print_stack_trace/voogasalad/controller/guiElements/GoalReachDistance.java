package com.print_stack_trace.voogasalad.controller.guiElements;


import java.util.HashMap;
import java.util.Iterator;


public class GoalReachDistance extends GoalCharacteristicController {
	private String direction;
	public GoalReachDistance(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
		direction=new MessagePopUp(myStyle).showDropDownDialog("Pick the Directon: ", getResource());
	}
	@Override
	protected void populateDefaultText() {
		this.setObservable(((GoalObject) mySprite).getCharacteristics().getPointsProperty());
	}

	@Override
	protected void setCharacteristic(String newValue) {
		double dest = ((GoalObject)mySprite).getCharacteristics().getDestination();
		try{
			dest =Double.parseDouble(newValue);
		}
		catch(NumberFormatException e){

		}
		if (direction.equals("UP")){
			((GoalObject) mySprite).getCharacteristics().setHorizontalDestination(false);
			((GoalObject)mySprite).getCharacteristics().setDestination(dest);
		}
		else if (direction.equals("DOWN")){
			((GoalObject) mySprite).getCharacteristics().setHorizontalDestination(false);
			((GoalObject)mySprite).getCharacteristics().setDestination(-1*dest);
		}
		else if (direction.equals("RIGHT")){
			((GoalObject) mySprite).getCharacteristics().setHorizontalDestination(true);
			((GoalObject)mySprite).getCharacteristics().setDestination(dest);
		}
		else {
			((GoalObject) mySprite).getCharacteristics().setHorizontalDestination(true);
			((GoalObject)mySprite).getCharacteristics().setDestination(-1*dest);
		}		

		mySprite.getDelegate().update((GoalObject) mySprite);

	}

	private String[] getResource(){
		ResourceReader myResourceReader=new ResourceReader("./com/print_stack_trace/voogasalad/controller/guiResources/TypeOfDistancesToReach.Properties");
		HashMap<String, String> myDataMap=myResourceReader.getProperties();
		System.out.println(myDataMap.size());
		Iterator<String> myIterator=myDataMap.keySet().iterator();
		String[] menuNames=new String[myDataMap.keySet().size()];
		for (int i=0; i<menuNames.length; i++){
			menuNames[i]=myIterator.next();
		}
		return menuNames;
	}

}

