package kz.theeurasia.esbdproxy.service.ejbimpl.test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import javax.naming.NamingException;

import org.hamcrest.Matchers;
import org.junit.Test;

import kz.theeurasia.esbdproxy.domain.entities.CityEntity;
import kz.theeurasia.esbdproxy.services.CityServiceDAO;
import kz.theeurasia.esbdproxy.services.NotFound;

public class CityServiceTestCase extends GeneralServiceTestCase {

    @Test
    public void testGetAll() throws NamingException {
	CityServiceDAO cityServiceService = getCityService();
	List<CityEntity> all = cityServiceService.getAll();
	assertThat(all,
		allOf(
			not(nullValue()),
			not(empty())));
    }

    @Test(expected = NotFound.class)
    public void testGetById() throws NamingException, NotFound {
	CityServiceDAO cityServiceService = getCityService();
	List<CityEntity> list = cityServiceService.getAll();
	for (CityEntity i : list) {
	    try {
		CityEntity res = cityServiceService.getById(i.getId());
		assertThat(res, allOf(not(nullValue()), equalTo(i)));
	    } catch (NotFound e) {
		fail(e.getMessage());
	    }
	}
	// try {
	cityServiceService.getById(-99999l);
	// fail("Expected a NotFound to be thrown");
	// } catch (NotFound e) {
	// }

    }
}
