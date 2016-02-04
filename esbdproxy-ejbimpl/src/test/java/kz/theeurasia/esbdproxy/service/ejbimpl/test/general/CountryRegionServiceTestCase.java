package kz.theeurasia.esbdproxy.service.ejbimpl.test.general;

import static kz.theeurasia.esbdproxy.service.ejbimpl.test.TestConstants.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import javax.naming.NamingException;

import org.junit.Test;

import kz.theeurasia.esbdproxy.domain.dict.general.CountryRegionDict;
import kz.theeurasia.esbdproxy.service.ejbimpl.test.GeneralServiceTestCase;
import kz.theeurasia.esbdproxy.services.InvalidInputParameter;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.general.CountryRegionServiceDAO;

public class CountryRegionServiceTestCase extends GeneralServiceTestCase {

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
    public void testGetById() throws NamingException, InvalidInputParameter {
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
    public void testGetById_NotFound() throws NamingException, NotFound, InvalidInputParameter {
	CountryRegionServiceDAO service = getCountryRegionServiceEntityWS();
	service.getById(INVALID_COUNTRY_REGION_ID);
    }

}
