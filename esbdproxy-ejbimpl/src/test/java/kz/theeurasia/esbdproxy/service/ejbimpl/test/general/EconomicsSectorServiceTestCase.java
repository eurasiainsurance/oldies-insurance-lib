package kz.theeurasia.esbdproxy.service.ejbimpl.test.general;

import static kz.theeurasia.esbdproxy.service.ejbimpl.test.TestConstants.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import javax.naming.NamingException;

import org.junit.Test;

import kz.theeurasia.esbdproxy.domain.dict.general.EconomicSectorDict;
import kz.theeurasia.esbdproxy.service.ejbimpl.test.GeneralServiceTestCase;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.general.EconomicSectorServiceDAO;

public class EconomicsSectorServiceTestCase extends GeneralServiceTestCase {

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
	service.getById(INVALID_ECONOMICS_SECTOR_ID);
    }

}
