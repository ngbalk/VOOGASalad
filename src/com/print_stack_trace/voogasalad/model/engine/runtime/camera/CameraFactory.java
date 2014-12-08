package com.print_stack_trace.voogasalad.model.engine.runtime.camera;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class CameraFactory {

	public static final String cameraPath = "com.print_stack_trace.voogasalad.model.engine.runtime.camera.";


	public enum CameraType {
		ConstantHorizontalScroll,
		ConstantVerticalScroll,
		PlayerFollow
	}

	public static CameraHandler buildCameraHandler(CameraType myCameraType){
		Constructor<?> con = null;
		CameraHandler newCamera = null;

		try {
			String objectType = myCameraType.toString();
			System.out.println(cameraPath+objectType);
			Class<?> newCameraClass = Class.forName(cameraPath + objectType);
			try {
				con = newCameraClass.getConstructor();
			} catch (NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				newCamera = (CameraHandler) con.newInstance();
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return newCamera;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}

}

