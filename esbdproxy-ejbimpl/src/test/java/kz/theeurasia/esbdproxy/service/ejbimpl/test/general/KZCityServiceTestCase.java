package kz.theeurasia.esbdproxy.service.ejbimpl.test.general;

import static kz.theeurasia.esbdproxy.service.ejbimpl.test.TestConstants.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import javax.naming.NamingException;

import org.junit.Test;

import kz.theeurasia.esbdproxy.domain.dict.general.KZCityDict;
import kz.theeurasia.esbdproxy.service.ejbimpl.test.GeneralServiceTestCase;
import kz.theeurasia.esbdproxy.services.InvalidInputParameter;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.general.KZCityServiceDAO;

public class KZCityServiceTestCase extends GeneralServiceTestCase {

    @Test
    public void testGetAll() throws NamingException {
	KZCityServiceDAO service = getKZCityServiceDictWS();
	List<KZCityDict> all = service.getAll();
	assertThat(all,
		allOf(
			not(nullValue()),
			contains(KZCityDict.values())));
    }

    @Test
    public void testGetById() throws NamingException, InvalidInputParameter {
	KZCityServiceDAO service = getKZCityServiceDictWS();
	KZCityDict[] list = KZCityDict.values();
	for (KZCityDict i : list) {
	    try {
		KZCityDict res = service.getById(i.getId());
		assertThat(res, allOf(not(nullValue()), equalTo(i)));
	    } catch (NotFound e) {
		fail(e.getMessage());
	    }
	}
    }

    @Test(expected = NotFound.class)
    public void testGetById_NotFound() throws NamingException, NotFound, InvalidInputParameter {
	KZCityServiceDAO service = getKZCityServiceDictWS();
	service.getById(INVALID_KZ_CITY_ID);
    }

}
