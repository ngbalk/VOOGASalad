package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.goal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GoalObject;
import com.print_stack_trace.voogasalad.controller.guiElements.resourceReader.ResourceReader;
import com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.UserInputDropDownMenu;
import com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.UserInputType;
import com.print_stack_trace.voogasalad.model.environment.GoalFactory.GoalType;
import com.print_stack_trace.voogasalad.utilities.Reflection;










import javafx.scene.control.Label;


public class GoalTypesMenu extends UserInputDropDownMenu {
	public GoalTypesMenu(String[] values,  double width, double height, double x, double y, GameObject object){
		super(values, width, height, x, y, object);
		currentMenu.setText("Pick type of Goal");
		myResourceReader=new ResourceReader("./com/print_stack_trace/voogasalad/controller/guiResources/GoalTypes.Properties");
		data=myResourceReader.getProperties();
		addMenus();
		
		
		
	}
	protected void linkMovement(String myName){
		for (GoalType name: GoalType.values()){
			if (name.name().equals(myName)){
				((GoalObject) mySprite).setCharacteristics(name);
				mySprite.getDelegate().update((GoalObject)mySprite);
				this.setCurrent(myName);
				Iterator<String> myIterator;
				UserInputType myType=null;
				Label myLabel=null;
				if (this.canSplit(data.get(myName))){
					myIterator=Arrays.asList(data.get(myName).split(";")).iterator();
					myIterator.next();
					String className=myIterator.next();
					if (root.size()>=2){
						this.myPanes.getChildren().remove(this.root.get(root.size()-1));
					}
					myType=(UserInputType) new Reflection().createInstance(className, value, myWidth, myHeight, myX, myY, mySprite);
					this.makeLabel(myName,value[1],myWidth,myHeight, myX, myY, myType);
				}
				else{
					if (root.size()>=2){
						this.myPanes.getChildren().remove(this.root.get(root.size()-1));
					}
				}
			}
		}
	}


}
