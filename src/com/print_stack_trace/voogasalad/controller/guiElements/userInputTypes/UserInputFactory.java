package com.print_stack_trace.voogasalad.controller.guiElements.userInputTypes;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.Array;
import java.util.HashMap;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.resourceReader.ResourceReader;
import com.print_stack_trace.voogasalad.utilities.reflection.Reflection;

import javafx.scene.Node;

public class UserInputFactory {
	private HashMap<String, String> myTypes=new HashMap<String, String>();
	private String DEFAULT_RESOURCE="./com/print_stack_trace/voogasalad/controller/guiResources/InputTypes.Properties";
	public UserInputFactory(){
		createMap();
	}
	
	public UserInputType createUserInput(String myType, String[] values,  double width, double height, double x, double y,GameObject sprite){
		new Reflection();
		return (UserInputType) Reflection.createInstance(myTypes.get(myType),values, width, height, x, y, sprite);
	}
	
	private void createMap(){
		HashMap<String, String> resource=new ResourceReader(DEFAULT_RESOURCE).getProperties();
		for(String typeName : resource.keySet()){
			myTypes.put(typeName,  resource.get(typeName));
		}
	}
}

