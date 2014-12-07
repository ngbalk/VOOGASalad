

package com.print_stack_trace.voogasalad.controller.guiElements;

public class ChangeRightAndLeftLayout extends AbstractMenuItem{

	public ChangeRightAndLeftLayout(String name, AbstractViewDelegate delegate) {
		super(name, delegate);
		// TODO Auto-generated constructor stub
	}

	public ChangeRightAndLeftLayout(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doAction() {
		if (myDelegate!=null){
			myDelegate.switchRightAndLeftNode();
		}

	}


}
