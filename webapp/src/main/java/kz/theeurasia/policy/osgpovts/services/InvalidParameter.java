package kz.theeurasia.policy.osgpovts.services;

public class InvalidParameter extends Exception {

    private static final long serialVersionUID = 249410103135764057L;

    public InvalidParameter() {
	super();
    }

    public InvalidParameter(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
    }

    public InvalidParameter(String message, Throwable cause) {
	super(message, cause);
    }

    public InvalidParameter(String message) {
	super(message);
    }

    public InvalidParameter(Throwable cause) {
	super(cause);
    }

    
}
