

package com.print_stack_trace.voogasalad.controller.guiElements.topFileMenuBar;

import com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor.AbstractViewDelegate;
import com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor.ViewObjectDelegate;

public class ChangeRightAndLeftLayout extends AbstractMenuItem{

	public ChangeRightAndLeftLayout(String name, AbstractViewDelegate delegate, ViewObjectDelegate game) {
		super(name, delegate, game);
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
