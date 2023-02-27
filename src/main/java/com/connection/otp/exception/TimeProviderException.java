package com.connection.otp.exception;

public class TimeProviderException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TimeProviderException(String message) {
        super(message);
    }
    public TimeProviderException(String message, Throwable cause) {
        super(message, cause);
    }
}

