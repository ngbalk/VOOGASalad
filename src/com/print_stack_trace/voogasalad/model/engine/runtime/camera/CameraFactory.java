package com.print_stack_trace.voogasalad.model.engine.runtime.camera;

import com.print_stack_trace.voogasalad.model.engine.physics.CollisionHandler;

public class CameraFactory {

	public enum CameraType {
		ConstantHorizonalScroll,
		ConstantVerticalScroll,
		PlayerFollow
	}
	
	public static CameraHandler buildCameraHandler(CameraType myCameraType){
		return null;
		
	}

}