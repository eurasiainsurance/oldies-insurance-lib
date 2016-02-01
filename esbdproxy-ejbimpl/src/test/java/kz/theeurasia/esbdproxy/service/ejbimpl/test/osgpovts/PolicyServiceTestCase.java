package kz.theeurasia.esbdproxy.service.ejbimpl.test.osgpovts;

import static kz.theeurasia.esbdproxy.service.ejbimpl.test.TestConstants.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import javax.naming.NamingException;

import org.junit.Test;

import kz.theeurasia.esbdproxy.domain.entities.osgpovts.PolicyEntity;
import kz.theeurasia.esbdproxy.service.ejbimpl.test.GeneralServiceTestCase;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.osgpovts.PolicyServiceDAO;

public class PolicyServiceTestCase extends GeneralServiceTestCase {

    @Test
    public void testGetById() throws NamingException {
	PolicyServiceDAO service = getPolicyServiceEntityWS();
	try {
	    PolicyEntity entity = service.getById(VALID_POLICY_ID);
	    assertThat(entity, not(nullValue()));
	    assertThat(entity.getId(), is(VALID_POLICY_ID));
	} catch (NotFound e) {
	    fail(e.getMessage());
	}
    }

    @Test(expected = NotFound.class)
    public void testGetById_NotFound() throws NamingException, NotFound {
	PolicyServiceDAO service = getPolicyServiceEntityWS();
	service.getById(INVALID_POLICY_ID);
    }

    @Test
    public void testGetByPolicyNumber() throws NamingException {
	PolicyServiceDAO service = getPolicyServiceEntityWS();
	try {
	    PolicyEntity entity = service.getByNumber(VALID_POLICY_NUMBER);
	    assertThat(entity, not(nullValue()));
	    assertThat(entity.getNumber(), is(VALID_POLICY_NUMBER));
	} catch (NotFound e) {
	    fail(e.getMessage());
	}
    }

    @Test(expected = NotFound.class)
    public void testGetByPolicyNumber_NotFound() throws NamingException, NotFound {
	PolicyServiceDAO service = getPolicyServiceEntityWS();
	service.getByNumber(INVALID_POLICY_NUMBER);
    }

}
