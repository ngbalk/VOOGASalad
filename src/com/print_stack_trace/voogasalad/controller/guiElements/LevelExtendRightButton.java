package com.print_stack_trace.voogasalad.controller.guiElements;

public class LevelExtendRightButton extends LevelSpaceExtenderButton {

	public LevelExtendRightButton(ViewObjectDelegate viewObjectDelegate) {
		super(viewObjectDelegate);
		
		
	}

	@Override
	protected void behavior() {
		myViewObjectDelegate.extendRight();
	}

	@Override
	protected void setDefaultText() {
		this.setText("Extend Right");
		
	}

}
