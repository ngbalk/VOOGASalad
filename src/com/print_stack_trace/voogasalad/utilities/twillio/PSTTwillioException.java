package com.print_stack_trace.voogasalad.utilities.twillio;

public class PSTTwillioException extends Exception {
	
	/**
	 * Default serial version UID
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Create an exception based on an issue in our code.
     */
    public PSTTwillioException(String message) {
        super(message);
    }

    /**
     * Create an exception based on a caught exception with a different message.
     */
    public PSTTwillioException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /**
     * Create an exception based on a caught exception.
     */
    public PSTTwillioException(Throwable exception) {
        super(exception);
    }
}
