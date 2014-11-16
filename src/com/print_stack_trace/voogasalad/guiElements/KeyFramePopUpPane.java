package com.print_stack_trace.voogasalad.guiElements;

import java.util.Collection;

public class KeyFramePopUpPane extends GeneralPane{
	public KeyFramePopUpPane(){
		super();
		this.getChildren().add(new KeyFrameBox(this.getWidth(), this.getHeight()));
		
	}

	@Override
	public void createTextFields() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void makeObservable(Collection toObserve) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadInData(Collection myData) {
		// TODO Auto-generated method stub
		
	}

}
