package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.goal;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor.ObjectAction;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GoalObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.SpriteObject;
import com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.UserInputDropDownMenu;
import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;


public class GoalObjectiveID extends UserInputDropDownMenu{
	protected HashMap<String, ArrayList<SpriteObject>> mySpriteData=new HashMap<String, ArrayList<SpriteObject>>();
	public GoalObjectiveID (String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
		createDataMap();
		addMenus();
	}

	@Override
	protected void linkMovement(String dataValue) {
		for (SpriteObject sprite: mySpriteData.get(dataValue)){
			((GoalObject)mySprite).getCharacteristics().getObjectiveID().add(sprite.getID());
			mySprite.update();
		}

	}
	private void createDataMap(){
		mySprite.getDelegate().actionToCurrentLevelSprites((type)->addData(type));
	}
	private void addData(Object type){
		if (type instanceof SpriteObject){
			SpriteObject myObject=(SpriteObject)type;
			if (myObject.getType().toUpperCase().equals(SpriteType.REWARD.name())){
				String myCode=myObject.getID()+"";
				if (!myObject.getCode().equals("")){
					myCode=myObject.getCode();
				}
				data.put(myCode,myCode);
				if (!mySpriteData.containsKey(myCode))
					mySpriteData.put(myCode, new ArrayList<SpriteObject>());
				mySpriteData.get(myCode).add(myObject);
			}
		}

	}
}

	