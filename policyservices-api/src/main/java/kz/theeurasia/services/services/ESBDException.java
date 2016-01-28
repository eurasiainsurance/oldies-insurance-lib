package kz.theeurasia.services.services;

public class ESBDException extends Exception {

    private static final long serialVersionUID = 8048093108224185054L;

    public ESBDException() {
	super();
    }

    public ESBDException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
    }

    public ESBDException(String message, Throwable cause) {
	super(message, cause);
    }

    public ESBDException(String message) {
	super(message);
    }

    public ESBDException(Throwable cause) {
	super(cause);
    }

}
