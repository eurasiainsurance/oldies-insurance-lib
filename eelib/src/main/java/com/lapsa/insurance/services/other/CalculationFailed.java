package com.lapsa.insurance.services.other;

public class CalculationFailed extends Exception {
    private static final long serialVersionUID = -7898813067807134927L;

    public CalculationFailed() {
	super();
    }

    public CalculationFailed(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
    }

    public CalculationFailed(String message, Throwable cause) {
	super(message, cause);
    }

    public CalculationFailed(String message) {
	super(message);
    }

    public CalculationFailed(Throwable cause) {
	super(cause);
    }

}
