package com.print_stack_trace.voogasalad.controller.guiElements;

import com.print_stack_trace.voogasalad.model.engine.authoring.GameAuthorEngine.CameraType;

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
		CameraType scroll=null;
		for (CameraType camera: CameraType.values()){
			if (camera.name().equals(dataValue));
				this.setCurrent(data.get(dataValue));
				scroll=camera;
				mySprite.getDelegate().setCamera(camera);
				break;
		}	
	}
}