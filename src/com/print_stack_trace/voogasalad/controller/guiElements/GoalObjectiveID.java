package com.print_stack_trace.voogasalad.controller.guiElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

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
            ((GoalObject)mySprite).getCharacteristics().getObjectiveID().clear();
                for (SpriteObject sprite: mySpriteData.get(dataValue)){
                        ((GoalObject)mySprite).getCharacteristics().getObjectiveID().add(sprite.getId());
                        ((GoalObject) mySprite).getDelegate().update(((GoalObject)mySprite));
                }

        }
        
	private void createDataMap(){
		for(GameObject object: (HashSet<GameObject>)mySprite.getDelegate().getCurrentLevelSprites()){
			if (object instanceof SpriteObject){
				SpriteObject myObject=(SpriteObject)object;
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

}



