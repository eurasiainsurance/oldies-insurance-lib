package kz.theeurasia.esbdproxy.service.ejbimpl.test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import javax.naming.NamingException;

import org.junit.Test;

import kz.theeurasia.esbdproxy.domain.dict.CountryDict;
import kz.theeurasia.esbdproxy.services.CountryServiceDAO;
import kz.theeurasia.esbdproxy.services.NotFound;

public class CountryServiceTestCase extends GeneralServiceTestCase {

    private static final long INVALID_ID = -99999l;

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
	service.getById(INVALID_ID);
    }

}
