package com.print_stack_trace.voogasalad.model.engine.runtime.camera;

import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeModel;

public class ConstantVerticalScroll implements CameraHandler {

	@Override
	public void updateCamera(RuntimeModel runtimeModel) {
		runtimeModel.camera.y -= runtimeModel.getLevelCharacteristics().cameraSpeed;
	}

}
