package kz.theeurasia.test.esbdproxy.dict;

import org.junit.BeforeClass;

import kz.theeurasia.asb.esbd.jaxws.IICWebService;
import kz.theeurasia.asb.esbd.jaxws.IICWebServiceSoap;
import kz.theeurasia.asb.esbd.jaxws.User;

public class ESBDTestCase {

    private static final String ESBD_WS_USER_NAME = "EUR.SSL.GORDOVA";
    private static final String ESBD_WS_USER_PASSWORD = "Be$tKe7";

    private static IICWebServiceSoap soap;
    private static String sessionId;

    @BeforeClass
    public static void createSession() {
	IICWebService service = new IICWebService();
	soap = service.getIICWebServiceSoap();
	User user = soap.authenticateUser(ESBD_WS_USER_NAME, ESBD_WS_USER_PASSWORD);
	sessionId = user.getSessionID();
    }
    
    protected static String getSessionId() {
	return sessionId;
    }

    protected static IICWebServiceSoap getSoap() {
	return soap;
    }

}
