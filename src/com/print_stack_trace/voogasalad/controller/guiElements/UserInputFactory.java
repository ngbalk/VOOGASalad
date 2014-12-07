package com.print_stack_trace.voogasalad.controller.guiElements;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.Array;
import java.util.HashMap;
import java.util.Properties;

import javax.swing.JOptionPane;

import javafx.scene.Node;

public class UserInputFactory {
	private HashMap<String, Class> myTypes=new HashMap<String, Class>();
	public UserInputFactory(){
		createMap();
	}
	public UserInputType createUserInput(String myType, String[] values,  double width, double height, double x, double y,GameObject sprite){
		Class<? extends UserInputType> typeOfInput=myTypes.get(myType);
		if (typeOfInput==null){
			return null;
		}
		UserInputType mySpecificType;
		System.out.println(typeOfInput);
		try {
			mySpecificType = typeOfInput.getConstructor(String[].class, double.class, double.class, double.class, double.class, GameObject.class).newInstance(values, width, height, x, y, sprite);
			return mySpecificType;
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, typeOfInput+ "does not exist.");
		}
		return null;
	}
	private void createMap(){
		try{
			Properties prop = new Properties();
			InputStream stream = getClass().getClassLoader().getResourceAsStream("./com/print_stack_trace/voogasalad/controller/guiResources/InputTypes.Properties");
			prop.load(stream);
			for(Object typeName : prop.keySet()){
				myTypes.put((String)typeName,  Class.forName((String)prop.get((String)typeName)));
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "User Input Types File Not Found");
		}
	}
}
	
