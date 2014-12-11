package com.print_stack_trace.voogasalad.controller.guiElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.SpriteType;

public class NextLevelProperty extends UserInputDropDownMenu{
	public NextLevelProperty (String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
		createDataMap();
	}

	@Override
	protected void linkMovement(String dataValue) {
		((LevelObject)mySprite).getCharacteristics().setNextLevel(Integer.parseInt(dataValue));
		((LevelObject) mySprite).getDelegate().update(((LevelObject)mySprite));


	}
	private void createDataMap(){

		if (mySprite.getDelegate()!=null){
			mySprite.getDelegate().currentLevelProperty().addListener(new ChangeListener<LevelObject>(){

				@Override
				public void changed(
						ObservableValue<? extends LevelObject> arg0,
						LevelObject arg1, LevelObject arg2) {
					for(GameObject object: (Set<GameObject>) mySprite.getDelegate().getLevelsAvailable()){
						if (object instanceof LevelObject){
							LevelObject myObject=(LevelObject)object;

							data.put(myObject.getID()+"",myObject.getCharacteristics().getName());
							addMenu(myObject.getID()+"");

						}
					}

				}

			});

		}
	}

}






