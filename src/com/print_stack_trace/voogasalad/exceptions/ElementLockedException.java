package com.print_stack_trace.voogasalad.exceptions;

public class ElementLockedException extends RuntimeException implements VoogaException{


	/**
	 * 
	 */
	private static final long serialVersionUID = 3433298473816623380L;

	@Override
	public String printMessage() {
		// TODO Move to property List
		return "This element is currently locked.";
	}

}
