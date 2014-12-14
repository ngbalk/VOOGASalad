package com.print_stack_trace.voogasalad.controller.guiElements.splashScreen;
import com.print_stack_trace.voogasalad.utilities.reflection.Reflection;
import com.print_stack_trace.voogasalad.controller.guiElements.resourceReader.ResourceReader;
import com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes.UserInputDropDownMenu;
import com.print_stack_trace.voogasalad.controller.popUpPanes.MessagePopUp;

import javafx.scene.Group;

public class TypeOfSplashScreenAnimation extends UserInputDropDownMenu{
	private Group root;
	private double splashScreenWidth;
	private double splashScreenHeight;
	public TypeOfSplashScreenAnimation(String source, double width, double height, Group myGroup){
		super();
		myResourceReader=new ResourceReader("./com/print_stack_trace/voogasalad/controller/guiResources/SplashScreenAnimations.Properties");
		data=myResourceReader.getProperties();
		splashScreenWidth=width;
		splashScreenHeight=height;
		addMenus();
	}

	@Override
	protected void linkMovement(String dataValue) {
		String text=new MessagePopUp(myStyle).showInputDialog("What would you like the label to be:");
		SplashScreenObject object=(SplashScreenObject) Reflection.createInstance(data.get(dataValue), splashScreenWidth, splashScreenHeight, root);
		root.getChildren().add(object.getNode());
	}
}
