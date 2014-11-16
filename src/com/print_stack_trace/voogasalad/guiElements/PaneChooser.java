package com.print_stack_trace.voogasalad.guiElements;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Properties;

import javafx.scene.layout.Pane;

import javax.swing.JOptionPane;

public class PaneChooser {
		private HashMap<String, String> myTypes=new HashMap<String, String>();
		public PaneChooser(){
			createMap();
		}
		public Pane createPane(String myType){
			if (myTypes.get(myType)==null){
				return null;
			}
			PopUpPane mySpecificType = new PopUpPane(myTypes.get(myType));
			
			return mySpecificType;
		}
		private void createMap(){
			try{
				Properties prop = new Properties();
				InputStream stream = getClass().getClassLoader().getResourceAsStream("./com/print_stack_trace/voogasalad/guiResources/PaneTypes.Properties");
				prop.load(stream);
				for(Object typeName : prop.keySet()){
					String values[]=prop.getProperty((String) typeName).split(";");
					myTypes.put(values[0],  values[1]);
				}
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null, "File not found");
			}
		}
	}
		


