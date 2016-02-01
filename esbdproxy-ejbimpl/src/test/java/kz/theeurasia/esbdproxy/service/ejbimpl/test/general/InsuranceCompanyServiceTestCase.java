package kz.theeurasia.esbdproxy.service.ejbimpl.test.general;

import static kz.theeurasia.esbdproxy.service.ejbimpl.test.TestConstants.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import javax.naming.NamingException;

import org.junit.Test;

import kz.theeurasia.esbdproxy.domain.entities.general.InsuranceCompanyEntity;
import kz.theeurasia.esbdproxy.service.ejbimpl.test.GeneralServiceTestCase;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.general.InsuranceCompanyServiceDAO;

public class InsuranceCompanyServiceTestCase extends GeneralServiceTestCase {

    @Test
    public void testGetAll() throws NamingException {
	InsuranceCompanyServiceDAO service = getInsuranceCompanyServiceEntityWS();
	List<InsuranceCompanyEntity> all = service.getAll();
	assertThat(all,
		allOf(
			not(nullValue()),
			not(empty())));
    }

    @Test
    public void testGetById() throws NamingException {
	InsuranceCompanyServiceDAO service = getInsuranceCompanyServiceEntityWS();
	List<InsuranceCompanyEntity> list = service.getAll();
	for (InsuranceCompanyEntity i : list) {
	    try {
		InsuranceCompanyEntity res = service.getById(i.getId());
		assertThat(res, allOf(not(nullValue()), is(i)));
	    } catch (NotFound e) {
		fail(e.getMessage());
	    }
	}
    }

    @Test(expected = NotFound.class)
    public void testGetById_NotFound() throws NamingException, NotFound {
	InsuranceCompanyServiceDAO service = getInsuranceCompanyServiceEntityWS();
	service.getById(INVALID_INSURANCE_COMPANY_ID);
    }

}
