package kz.theeurasia.esbd.services.ejbimpl;

import java.util.logging.Logger;

import javax.ejb.Singleton;

import kz.theeurasia.asb.esbd.jaxws.IICWebServiceSoap;
import kz.theeurasia.asb.esbd.jaxws.User;

@Singleton
public class ESBDWSSession {
    private static final String ESBD_WS_USER_NAME = "EUR.SSL.GORDOVA";
    private static final String ESBD_WS_USER_PASSWORD = "Be$tKe7";

    private Logger logger = Logger.getAnonymousLogger();

    private String sessionId;

    public String getSessionId() {
	return sessionId;
    }

    public void checkSession(IICWebServiceSoap soapService) {
	if (sessionId == null || sessionId.equals("") || !soapService.sessionExists(sessionId, ESBD_WS_USER_NAME)) {
	    logger.fine("Establishing new ESBD session for user " + ESBD_WS_USER_NAME);
	    User user = soapService.authenticateUser(ESBD_WS_USER_NAME, ESBD_WS_USER_PASSWORD);
	    sessionId = user.getSessionID();
	    logger.fine("ESBD session established aSessionID = " + sessionId);
	}
    }

}
