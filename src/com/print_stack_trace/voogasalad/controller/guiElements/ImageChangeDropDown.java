package com.print_stack_trace.voogasalad.controller.guiElements;

import java.io.InputStream;
import java.util.Properties;

import javax.swing.JOptionPane;

public class ImageChangeDropDown extends UserInputDropDownMenu{
	public ImageChangeDropDown(){
		
	}
	public addMenus(){
		try{
			Properties prop = new Properties();
			InputStream stream = getClass().getClassLoader().getResourceAsStream("./com/print_stack_trace/voogasalad/controller/guiResources/PaneTypes.Properties");
			prop.load(stream);
			for(Object typeName : prop.keySet()){
				this.
				thisprop.getProperty((String) typeName).split(";");
				
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Pane type not found");
		}
	}
	}
}
