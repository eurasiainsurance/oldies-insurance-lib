package kz.theeurasia.services.services;

public class ESBDFaultException extends Exception {

    private static final long serialVersionUID = 7550476714513554581L;

    public ESBDFaultException() {
	super();
    }

    public ESBDFaultException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
    }

    public ESBDFaultException(String message, Throwable cause) {
	super(message, cause);
    }

    public ESBDFaultException(String message) {
	super(message);
    }

    public ESBDFaultException(Throwable cause) {
	super(cause);
    }

}
