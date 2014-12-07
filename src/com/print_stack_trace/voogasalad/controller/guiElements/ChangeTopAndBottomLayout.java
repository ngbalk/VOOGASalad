package com.print_stack_trace.voogasalad.controller.guiElements;

public class ChangeTopAndBottomLayout extends AbstractMenuItem{

	public ChangeTopAndBottomLayout(String name, AbstractViewDelegate delegate) {
		super(name, delegate);
		// TODO Auto-generated constructor stub
	}

	public ChangeTopAndBottomLayout(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doAction() {
		if (myDelegate!=null){
			myDelegate.switchTopAndBottomNode();
		}

	}


}
