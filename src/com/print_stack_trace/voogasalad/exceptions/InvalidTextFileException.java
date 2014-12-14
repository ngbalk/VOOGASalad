package com.print_stack_trace.voogasalad.exceptions;

import java.io.IOException;

public class InvalidTextFileException extends IOException implements VoogaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5536348023689753986L;

	@Override
	public String printMessage() {
		return "Please upload an appropriate text file";
	}

}
