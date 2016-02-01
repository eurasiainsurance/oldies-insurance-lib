package kz.theeurasia.esbdproxy.services;

public class TooMany extends Exception {

    private static final long serialVersionUID = -7567890573656824988L;

    public TooMany() {
	super();
    }

    public TooMany(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
    }

    public TooMany(String message, Throwable cause) {
	super(message, cause);
    }

    public TooMany(String message) {
	super(message);
    }

    public TooMany(Throwable cause) {
	super(cause);
    }

}
