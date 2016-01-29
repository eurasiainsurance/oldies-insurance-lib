package kz.theeurasia.esbdproxy.services;

public class MoreThanOneRecordFound extends Exception {

    private static final long serialVersionUID = 3134180382713780719L;

    public MoreThanOneRecordFound() {
	super();
    }

    public MoreThanOneRecordFound(String message, Throwable cause, boolean enableSuppression,
	    boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
    }

    public MoreThanOneRecordFound(String message, Throwable cause) {
	super(message, cause);
    }

    public MoreThanOneRecordFound(String message) {
	super(message);
    }

    public MoreThanOneRecordFound(Throwable cause) {
	super(cause);
    }
}
