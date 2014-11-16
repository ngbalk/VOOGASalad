package com.print_stack_trace.voogasalad.guiElements;

import java.io.InputStream;
import java.util.Properties;

import javax.swing.JOptionPane;

public class ResourceReader {
	public ResourceReader(){
	}
	public void doActionOnResources(ResourceAction myAction){
		try{
			Properties prop = new Properties();
			InputStream stream = getClass().getClassLoader().getResourceAsStream("./com/print_stack_trace/voogasalad/guiResources/SpritePane.Properties");
			prop.load(stream);
			for(Object object : prop.keySet()){
				myAction.doAction(object);
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "File not found");
		}
	}
}
