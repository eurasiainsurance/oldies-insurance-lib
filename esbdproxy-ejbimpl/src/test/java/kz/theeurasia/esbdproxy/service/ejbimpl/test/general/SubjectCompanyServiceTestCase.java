package kz.theeurasia.esbdproxy.service.ejbimpl.test.general;

import static kz.theeurasia.esbdproxy.service.ejbimpl.test.TestConstants.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import javax.naming.NamingException;

import org.junit.Test;

import kz.theeurasia.esbdproxy.domain.entities.general.SubjectCompanyEntity;
import kz.theeurasia.esbdproxy.service.ejbimpl.test.GeneralServiceTestCase;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.general.SubjectCompanyServiceDAO;

public class SubjectCompanyServiceTestCase extends GeneralServiceTestCase {

    @Test
    public void testGetById() throws NamingException {
	SubjectCompanyServiceDAO service = getSubjectCompanyServiceEntityWS();
	try {
	    for (long validSubjectId : VALID_SUBJECT_SUBJECT_IDS) {
		SubjectCompanyEntity res = service.getById(validSubjectId);
		assertThat(res, not(nullValue()));
	    }
	} catch (NotFound e) {
	    fail(e.getMessage());
	}
    }

    @Test
    public void testGetById_NotFound() throws NamingException {
	SubjectCompanyServiceDAO service = getSubjectCompanyServiceEntityWS();
	for (long invalidSubjectId : INVALID_SUBJECT_SUBJECT_IDS) {
	    try {
		service.getById(invalidSubjectId);
		fail("Not found exception Expected");
	    } catch (NotFound e) {
	    }
	}
    }
}
