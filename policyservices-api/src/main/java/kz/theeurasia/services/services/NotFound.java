package kz.theeurasia.services.services;

public class NotFound extends Exception {

    private static final long serialVersionUID = -5820262120860304057L;

    public NotFound() {
	super();
    }

    public NotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
    }

    public NotFound(String message, Throwable cause) {
	super(message, cause);
    }

    public NotFound(String message) {
	super(message);
    }

    public NotFound(Throwable cause) {
	super(cause);
    }

}
