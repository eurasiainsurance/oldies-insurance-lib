package com.lapsa.insurance.esbd.services;

public class InvalidInputParameter extends Exception {

    private static final long serialVersionUID = -5483074273661973776L;

    public InvalidInputParameter() {
	super();
    }

    public InvalidInputParameter(String message, Throwable cause, boolean enableSuppression,
	    boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
    }

    public InvalidInputParameter(String message, Throwable cause) {
	super(message, cause);
    }

    public InvalidInputParameter(String message) {
	super(message);
    }

    public InvalidInputParameter(Throwable cause) {
	super(cause);
    }

}
