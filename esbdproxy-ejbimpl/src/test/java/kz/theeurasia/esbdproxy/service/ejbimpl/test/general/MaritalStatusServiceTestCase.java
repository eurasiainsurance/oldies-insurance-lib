package kz.theeurasia.esbdproxy.service.ejbimpl.test.general;

import static kz.theeurasia.esbdproxy.service.ejbimpl.test.TestConstants.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import javax.naming.NamingException;

import org.junit.Test;

import kz.theeurasia.esbdproxy.domain.dict.general.MaritalStatusDict;
import kz.theeurasia.esbdproxy.service.ejbimpl.test.GeneralServiceTestCase;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.general.MaritalStatusServiceDAO;

public class MaritalStatusServiceTestCase extends GeneralServiceTestCase {

    @Test
    public void testGetAll() throws NamingException {
	MaritalStatusServiceDAO service = getMaritalStatusServiceEntityWS();
	List<MaritalStatusDict> all = service.getAll();
	assertThat(all,
		allOf(
			not(nullValue()),
			contains(MaritalStatusDict.values())));
    }

    @Test
    public void testGetById() throws NamingException {
	MaritalStatusServiceDAO service = getMaritalStatusServiceEntityWS();
	MaritalStatusDict[] list = MaritalStatusDict.values();
	for (MaritalStatusDict i : list) {
	    try {
		MaritalStatusDict res = service.getById(i.getId());
		assertThat(res, allOf(not(nullValue()), equalTo(i)));
	    } catch (NotFound e) {
		fail(e.getMessage());
	    }
	}
    }

    @Test(expected = NotFound.class)
    public void testGetById_NotFound() throws NamingException, NotFound {
	MaritalStatusServiceDAO service = getMaritalStatusServiceEntityWS();
	service.getById(INVALID_MARITAL_STATUS_ID);
    }

}
