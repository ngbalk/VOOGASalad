package com.print_stack_trace.voogasalad.exceptions;

public class GamePlayerException extends RuntimeException implements VoogaException {
	
	private static final long serialVersionUID = -3534124694409416195L;

	public GamePlayerException() {
		super();
	}

	public GamePlayerException(Exception e) {
		super(e);
	}

	public GamePlayerException(String s) {
		super(s);
	}
	
	public String printMessage() {
		// TODO Move to property List
		return "GamePlayerException";
	}
}
