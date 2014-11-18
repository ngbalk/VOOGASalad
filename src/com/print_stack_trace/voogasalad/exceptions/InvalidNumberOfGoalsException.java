package com.print_stack_trace.voogasalad.exceptions;

public class InvalidNumberOfGoalsException extends RuntimeException implements VoogaException{

	private static final String INVALID_NUMBER_OF_GOALS_STRING = "Invalid number of Goals set";
	/**
	 * 
	 */
	private static final long serialVersionUID = -7664319246034782536L;

	@Override
	public String printMessage() {
		// TODO Auto-generated method stub
		return INVALID_NUMBER_OF_GOALS_STRING;
	}

}
