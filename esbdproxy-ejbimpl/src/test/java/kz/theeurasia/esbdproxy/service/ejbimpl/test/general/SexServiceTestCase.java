package kz.theeurasia.esbdproxy.service.ejbimpl.test.general;

import static kz.theeurasia.esbdproxy.service.ejbimpl.test.TestConstants.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import javax.naming.NamingException;

import org.junit.Test;

import kz.theeurasia.esbdproxy.domain.dict.general.SexDict;
import kz.theeurasia.esbdproxy.service.ejbimpl.test.GeneralServiceTestCase;
import kz.theeurasia.esbdproxy.services.InvalidInputParameter;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.general.SexServiceDAO;

public class SexServiceTestCase extends GeneralServiceTestCase {

    @Test
    public void testGetAll() throws NamingException {
	SexServiceDAO service = getSexServiceEntityWS();
	List<SexDict> all = service.getAll();
	assertThat(all,
		allOf(
			not(nullValue()),
			contains(SexDict.values())));
    }

    @Test
    public void testGetById() throws NamingException, InvalidInputParameter {
	SexServiceDAO service = getSexServiceEntityWS();
	SexDict[] list = SexDict.values();
	for (SexDict i : list) {
	    try {
		SexDict res = service.getById(i.getId());
		assertThat(res, allOf(not(nullValue()), equalTo(i)));
	    } catch (NotFound e) {
		fail(e.getMessage());
	    }
	}
    }

    @Test(expected = NotFound.class)
    public void testGetById_NotFound() throws NamingException, NotFound, InvalidInputParameter {
	SexServiceDAO service = getSexServiceEntityWS();
	service.getById(INVALID_SEX_ID);
    }

}
