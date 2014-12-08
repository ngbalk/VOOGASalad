package com.print_stack_trace.voogasalad.controller.guiElements;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javafx.scene.layout.Pane;

import javax.swing.JOptionPane;

public class PaneChooser {
		private Map<String, String> myTypes;
		public PaneChooser(){
			myTypes = new HashMap<String, String>();
			createMap();
		}
		public Pane createPane(String myType, GameObject myObject){
			if (myTypes.get(myType)==null){
				return null;
			}
			PopUpPane mySpecificType = new PopUpPane(myTypes.get(myType), myObject);
			return mySpecificType;
		}
		private void createMap(){
			try{
				Properties prop = new Properties();
				InputStream stream = getClass().getClassLoader().getResourceAsStream("./com/print_stack_trace/voogasalad/controller/guiResources/AllPaneTypes.Properties");
				prop.load(stream);
				for(Object typeName : prop.keySet()){
					String values[]=prop.getProperty((String) typeName).split(";");
					myTypes.put(values[0],  values[1]);
				}
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null, "Pane type not found");
			}
		}
	}
		


