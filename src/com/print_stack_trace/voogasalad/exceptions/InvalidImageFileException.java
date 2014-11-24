package com.print_stack_trace.voogasalad.exceptions;

import java.io.IOException;

public class InvalidImageFileException extends IOException implements VoogaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8505683230638297984L;

	@Override
	public String printMessage() {
		// TODO Move to property List
		return "Please upload a JPEG or PNG";
	}

}
