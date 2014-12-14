package com.print_stack_trace.voogasalad.controller.guiElements.topFileMenuBar;

import com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor.AbstractViewDelegate;
import com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor.ViewObjectDelegate;

public class ChangeTopAndBottomLayout extends AbstractMenuItem{

	public ChangeTopAndBottomLayout(String name, AbstractViewDelegate delegate, ViewObjectDelegate game) {
		super(name, delegate, game);
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
