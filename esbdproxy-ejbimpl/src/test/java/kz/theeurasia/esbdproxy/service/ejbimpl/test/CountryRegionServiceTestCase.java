package kz.theeurasia.esbdproxy.service.ejbimpl.test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import javax.naming.NamingException;

import org.junit.Test;

import kz.theeurasia.esbdproxy.domain.dict.CountryRegionDict;
import kz.theeurasia.esbdproxy.services.CountryRegionServiceDAO;
import kz.theeurasia.esbdproxy.services.NotFound;

public class CountryRegionServiceTestCase extends GeneralServiceTestCase {

    private static final long INVALID_ID = -99999l;

    @Test
    public void testGetAll() throws NamingException {
	CountryRegionServiceDAO service = getCountryRegionServiceEntityWS();
	List<CountryRegionDict> all = service.getAll();
	assertThat(all,
		allOf(
			not(nullValue()),
			contains(CountryRegionDict.values())));
    }

    @Test
    public void testGetById() throws NamingException {
	CountryRegionServiceDAO service = getCountryRegionServiceEntityWS();
	CountryRegionDict[] list = CountryRegionDict.values();
	for (CountryRegionDict i : list) {
	    try {
		CountryRegionDict res = service.getById(i.getId());
		assertThat(res, allOf(not(nullValue()), equalTo(i)));
	    } catch (NotFound e) {
		fail(e.getMessage());
	    }
	}
    }

    @Test(expected = NotFound.class)
    public void testGetById_NotFound() throws NamingException, NotFound {
	CountryRegionServiceDAO service = getCountryRegionServiceEntityWS();
	service.getById(INVALID_ID);
    }

}
