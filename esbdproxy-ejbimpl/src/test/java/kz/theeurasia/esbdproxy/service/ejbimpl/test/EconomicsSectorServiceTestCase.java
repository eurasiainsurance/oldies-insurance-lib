package kz.theeurasia.esbdproxy.service.ejbimpl.test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import javax.naming.NamingException;

import org.junit.Test;

import kz.theeurasia.esbdproxy.domain.dict.EconomicSectorDict;
import kz.theeurasia.esbdproxy.services.EconomicSectorServiceDAO;
import kz.theeurasia.esbdproxy.services.NotFound;

public class EconomicsSectorServiceTestCase extends GeneralServiceTestCase {

    private static final long INVALID_ID = -99999l;

    @Test
    public void testGetAll() throws NamingException {
	EconomicSectorServiceDAO service = getEconomicSectorServiceEntityWS();
	List<EconomicSectorDict> all = service.getAll();
	assertThat(all,
		allOf(
			not(nullValue()),
			contains(EconomicSectorDict.values())));
    }

    @Test
    public void testGetById() throws NamingException {
	EconomicSectorServiceDAO service = getEconomicSectorServiceEntityWS();
	EconomicSectorDict[] list = EconomicSectorDict.values();
	for (EconomicSectorDict i : list) {
	    try {
		EconomicSectorDict res = service.getById(i.getId());
		assertThat(res, allOf(not(nullValue()), equalTo(i)));
	    } catch (NotFound e) {
		fail(e.getMessage());
	    }
	}
    }

    @Test(expected = NotFound.class)
    public void testGetById_NotFound() throws NamingException, NotFound {
	EconomicSectorServiceDAO service = getEconomicSectorServiceEntityWS();
	service.getById(INVALID_ID);
    }

}
