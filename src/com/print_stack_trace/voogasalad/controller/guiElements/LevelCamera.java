package com.print_stack_trace.voogasalad.controller.guiElements;

import com.print_stack_trace.voogasalad.model.engine.runtime.camera.CameraFactory;
import com.print_stack_trace.voogasalad.model.engine.runtime.camera.CameraFactory.CameraType;

public class LevelCamera extends UserInputDropDownMenu{
	public LevelCamera(GameObject myObject){
		super(myObject);
		currentMenu.setText("Pick Types of Movement");
		myResourceReader=new ResourceReader("./com/print_stack_trace/voogasalad/"
				+ "controller/guiResources/CameraTypes.Properties");
		data=myResourceReader.getProperties();
		addMenus();
	}

	@Override
	protected void linkMovement(String dataValue) {
		CameraFactory.CameraType scroll=null;
		for (CameraFactory.CameraType camera: CameraFactory.CameraType.values()){
			if (camera.name().equals(dataValue));
				this.setCurrent(data.get(dataValue));
				scroll=camera;
				mySprite.getDelegate().setCamera(camera);
				break;
		}	
	}
}
