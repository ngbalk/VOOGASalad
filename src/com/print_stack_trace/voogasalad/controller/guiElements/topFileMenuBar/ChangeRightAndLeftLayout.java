

package com.print_stack_trace.voogasalad.controller.guiElements.topFileMenuBar;

import com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor.ViewObjectDelegate;
import com.print_stack_trace.voogasalad.controller.guiElements.layout.AbstractViewDelegate;

public class ChangeRightAndLeftLayout extends AbstractMenuItem{

	public ChangeRightAndLeftLayout(String name, AbstractViewDelegate delegate, ViewObjectDelegate game) {super(name, delegate, game);}

	public ChangeRightAndLeftLayout(String name) {super(name);}
	@Override
	public void doAction() {
		if (myDelegate!=null){
			myDelegate.switchRightAndLeftNode();
		}
	}
}
