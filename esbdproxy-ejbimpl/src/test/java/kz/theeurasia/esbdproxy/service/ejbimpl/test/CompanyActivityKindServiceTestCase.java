package kz.theeurasia.esbdproxy.service.ejbimpl.test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import javax.naming.NamingException;

import org.junit.Test;

import kz.theeurasia.esbdproxy.domain.entities.CompanyActivityKindEntity;
import kz.theeurasia.esbdproxy.services.CompanyActivityKindServiceDAO;
import kz.theeurasia.esbdproxy.services.NotFound;

public class CompanyActivityKindServiceTestCase extends GeneralServiceTestCase {

    private static final long INVALID_ID = -99999l;

    @Test
    public void testGetAll() throws NamingException {
	CompanyActivityKindServiceDAO service = getCompanyActivityKindServiceEntityWS();
	List<CompanyActivityKindEntity> all = service.getAll();
	assertThat(all,
		allOf(
			not(nullValue()),
			not(empty())));
    }

    @Test
    public void testGetById() throws NamingException {
	CompanyActivityKindServiceDAO service = getCompanyActivityKindServiceEntityWS();
	List<CompanyActivityKindEntity> list = service.getAll();
	for (CompanyActivityKindEntity i : list) {
	    try {
		CompanyActivityKindEntity res = service.getById(i.getId());
		assertThat(res, allOf(not(nullValue()), is(i)));
	    } catch (NotFound e) {
		fail(e.getMessage());
	    }
	}
    }

    @Test(expected = NotFound.class)
    public void testGetById_NotFound() throws NamingException, NotFound {
	CompanyActivityKindServiceDAO service = getCompanyActivityKindServiceEntityWS();
	service.getById(INVALID_ID);
    }

}
