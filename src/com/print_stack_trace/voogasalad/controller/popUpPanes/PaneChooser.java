package com.print_stack_trace.voogasalad.controller.popUpPanes;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javafx.scene.layout.Pane;

import javax.swing.JOptionPane;

import com.print_stack_trace.voogasalad.controller.guiElements.gameObjects.GameObject;
import com.print_stack_trace.voogasalad.controller.guiElements.resourceReader.ResourceReader;

public class PaneChooser {
	private Map<String, String> myTypes;
	public PaneChooser(){
		myTypes = new HashMap<String, String>();
		createMap();
	}
	
	public Pane createPane(String myType, GameObject myObject){
		return (myTypes.get(myType)==null)? null: new PopUpPane(myTypes.get(myType), myObject);
	}
	
	private void createMap(){
		HashMap<String, String> resource=new ResourceReader
				("./com/print_stack_trace/voogasalad/controller/guiResources/AllPaneTypes.Properties").getProperties();
		for(String typeName : resource.keySet()){
			String values[]=resource.get(typeName).split(";");
			myTypes.put(values[0],  values[1]);
		}
	}
}



