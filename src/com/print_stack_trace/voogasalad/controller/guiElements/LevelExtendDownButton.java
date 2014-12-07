package com.print_stack_trace.voogasalad.controller.guiElements;

public class LevelExtendDownButton extends LevelSpaceExtenderButton {

	public LevelExtendDownButton(ViewObjectDelegate viewObjectDelegate) {
		super(viewObjectDelegate);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void setDefaultText() {
		this.setText("Extend Down");

	}

	@Override
	protected void behavior() {
		this.myViewObjectDelegate.extendDown();

	}

}
