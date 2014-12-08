package com.print_stack_trace.voogasalad.model.engine.runtime.camera;

import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeModel;

public class ConstantHorizontalScroll implements CameraHandler {

	@Override
	public void updateCamera(RuntimeModel runtimeModel) {
		runtimeModel.camera.x += runtimeModel.getLevelCharacteristics().cameraSpeed;
	}

}
