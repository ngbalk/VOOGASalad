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
			Class<?> newCameraClass = Class.forName(cameraPath + objectType);
			try {
				con = newCameraClass.getConstructor();
			} catch (NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			try {
				newCamera = (CameraHandler) con.newInstance();
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			return newCamera;
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		return null;
	}

}

