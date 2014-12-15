package com.print_stack_trace.voogasalad.controller.guiElements.resourceReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import com.print_stack_trace.voogasalad.controller.popUpPanes.MessagePopUp;
public class ResourceReader {
	private HashMap<String, String> myProperties=new HashMap<String, String>();
	public ResourceReader(String resource){
		try{
			Properties prop = new Properties();
			InputStream stream = getClass().getClassLoader().getResourceAsStream(resource);
			prop.load(stream);
			for(Object object : prop.keySet()){
				myProperties.put((String)object, prop.getProperty((String) object));
			}
		}
		catch(Exception e){
			new MessagePopUp().showMessageDialog(resource+ "file not found");
		}
	}
	public HashMap<String, String> getProperties(){
		return myProperties;
	}
}
