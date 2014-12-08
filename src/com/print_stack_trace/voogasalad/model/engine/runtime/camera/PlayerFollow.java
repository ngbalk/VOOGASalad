package com.print_stack_trace.voogasalad.model.engine.runtime.camera;

import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeModel;
import com.print_stack_trace.voogasalad.model.engine.runtime.RuntimeSpriteCharacteristics;

public class PlayerFollow implements CameraHandler {

	@Override
	public void updateCamera(RuntimeModel runtimeModel) {
		RuntimeSpriteCharacteristics mainChar = runtimeModel.getRuntimeSpriteMap().get(runtimeModel.getMainCharacter());
		runtimeModel.camera.x = (int) (mainChar.getX()-runtimeModel.viewport.width);
		runtimeModel.camera.y = (int) (mainChar.getY()-runtimeModel.viewport.height);
	}

}
