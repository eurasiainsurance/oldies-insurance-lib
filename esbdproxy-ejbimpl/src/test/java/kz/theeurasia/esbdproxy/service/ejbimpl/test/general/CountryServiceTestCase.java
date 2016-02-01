package kz.theeurasia.esbdproxy.service.ejbimpl.test.general;

import static kz.theeurasia.esbdproxy.service.ejbimpl.test.TestConstants.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import javax.naming.NamingException;

import org.junit.Test;

import kz.theeurasia.esbdproxy.domain.dict.general.CountryDict;
import kz.theeurasia.esbdproxy.service.ejbimpl.test.GeneralServiceTestCase;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.general.CountryServiceDAO;

public class CountryServiceTestCase extends GeneralServiceTestCase {

    @Test
    public void testGetAll() throws NamingException {
	CountryServiceDAO service = getCountryServiceEntityWS();
	List<CountryDict> all = service.getAll();
	assertThat(all,
		allOf(
			not(nullValue()),
			contains(CountryDict.values())));
    }

    @Test
    public void testGetById() throws NamingException {
	CountryServiceDAO service = getCountryServiceEntityWS();
	CountryDict[] list = CountryDict.values();
	for (CountryDict i : list) {
	    try {
		CountryDict res = service.getById(i.getId());
		assertThat(res, allOf(not(nullValue()), equalTo(i)));
	    } catch (NotFound e) {
		fail(e.getMessage());
	    }
	}
    }

    @Test(expected = NotFound.class)
    public void testGetById_NotFound() throws NamingException, NotFound {
	CountryServiceDAO service = getCountryServiceEntityWS();
	service.getById(INVALID_COUNTRY_ID);
    }

}
