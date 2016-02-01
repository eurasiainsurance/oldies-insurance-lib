package kz.theeurasia.esbdproxy.service.ejbimpl.test.general;

import static kz.theeurasia.esbdproxy.service.ejbimpl.test.TestConstants.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import javax.naming.NamingException;

import org.junit.Test;

import kz.theeurasia.esbdproxy.domain.dict.general.IdentityCardTypeDict;
import kz.theeurasia.esbdproxy.service.ejbimpl.test.GeneralServiceTestCase;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.general.IdentityCardTypeServiceDAO;

public class IdentityCardTypeServiceTestCase extends GeneralServiceTestCase {

    @Test
    public void testGetAll() throws NamingException {
	IdentityCardTypeServiceDAO service = getIdentityCardTypeServiceEntityWS();
	List<IdentityCardTypeDict> all = service.getAll();
	assertThat(all,
		allOf(
			not(nullValue()),
			contains(IdentityCardTypeDict.values())));
    }

    @Test
    public void testGetById() throws NamingException {
	IdentityCardTypeServiceDAO service = getIdentityCardTypeServiceEntityWS();
	IdentityCardTypeDict[] list = IdentityCardTypeDict.values();
	for (IdentityCardTypeDict i : list) {
	    try {
		IdentityCardTypeDict res = service.getById(i.getId());
		assertThat(res, allOf(not(nullValue()), equalTo(i)));
	    } catch (NotFound e) {
		fail(e.getMessage());
	    }
	}
    }

    @Test(expected = NotFound.class)
    public void testGetById_NotFound() throws NamingException, NotFound {
	IdentityCardTypeServiceDAO service = getIdentityCardTypeServiceEntityWS();
	service.getById(INVALID_IDENTITY_CARD_TYPE_ID);
    }

}
