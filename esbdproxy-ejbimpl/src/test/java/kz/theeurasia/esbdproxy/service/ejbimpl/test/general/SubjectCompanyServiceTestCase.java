package kz.theeurasia.esbdproxy.service.ejbimpl.test.general;

import static kz.theeurasia.esbdproxy.service.ejbimpl.test.TestConstants.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import javax.naming.NamingException;

import org.junit.Test;

import kz.theeurasia.esbdproxy.domain.entities.general.SubjectCompanyEntity;
import kz.theeurasia.esbdproxy.service.ejbimpl.test.GeneralServiceTestCase;
import kz.theeurasia.esbdproxy.services.InvalidInputParameter;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.general.SubjectCompanyServiceDAO;

public class SubjectCompanyServiceTestCase extends GeneralServiceTestCase {

    @Test
    public void testGetById() throws NamingException, InvalidInputParameter {
	SubjectCompanyServiceDAO service = getSubjectCompanyServiceEntityWS();
	try {
	    for (long valid : VALID_SUBJECT_COMPANY_IDS) {
		SubjectCompanyEntity res = service.getById(valid);
		assertThat(res, not(nullValue()));
	    }
	} catch (NotFound e) {
	    fail(e.getMessage());
	}
    }

    @Test
    public void testGetById_NotFound() throws NamingException, InvalidInputParameter {
	SubjectCompanyServiceDAO service = getSubjectCompanyServiceEntityWS();
	for (long invalid : INVALID_SUBJECT_COMPANY_IDS) {
	    try {
		service.getById(invalid);
		fail("Not found exception Expected");
	    } catch (NotFound e) {
	    }
	}
    }

    @Test
    public void testGetByBIN() throws NamingException, InvalidInputParameter {
	SubjectCompanyServiceDAO service = getSubjectCompanyServiceEntityWS();
	try {
	    for (String valid : VALID_SUBJECT_COMPANY_BINS) {
		SubjectCompanyEntity res = service.getByBIN(valid);
		assertThat(res, not(nullValue()));
	    }
	} catch (NotFound e) {
	    fail(e.getMessage());
	}
    }

    @Test
    public void testGetByBIN_NotFound() throws NamingException, InvalidInputParameter {
	SubjectCompanyServiceDAO service = getSubjectCompanyServiceEntityWS();
	for (String invalid : INVALID_SUBJECT_COMPANY_BINS) {
	    try {
		service.getByBIN(invalid);
		fail("Not found exception Expected");
	    } catch (NotFound e) {
	    }
	}
    }
}
