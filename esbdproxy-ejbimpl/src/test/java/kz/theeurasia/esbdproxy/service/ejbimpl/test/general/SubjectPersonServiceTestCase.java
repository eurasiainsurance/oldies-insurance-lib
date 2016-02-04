package kz.theeurasia.esbdproxy.service.ejbimpl.test.general;

import static kz.theeurasia.esbdproxy.service.ejbimpl.test.TestConstants.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import javax.naming.NamingException;

import org.junit.Test;

import kz.theeurasia.esbdproxy.domain.entities.general.SubjectPersonEntity;
import kz.theeurasia.esbdproxy.service.ejbimpl.test.GeneralServiceTestCase;
import kz.theeurasia.esbdproxy.services.InvalidInputParameter;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.general.SubjectPersonServiceDAO;

public class SubjectPersonServiceTestCase extends GeneralServiceTestCase {

    @Test
    public void testGetById() throws NamingException, InvalidInputParameter {
	SubjectPersonServiceDAO service = getSubjectPersonServiceEntityWS();
	try {
	    for (long valid : VALID_SUBJECT_PERSON_IDS) {
		SubjectPersonEntity res = service.getById(valid);
		assertThat(res, not(nullValue()));
	    }
	} catch (NotFound e) {
	    fail(e.getMessage());
	}
    }

    @Test
    public void testGetById_NotFound() throws NamingException, InvalidInputParameter {
	SubjectPersonServiceDAO service = getSubjectPersonServiceEntityWS();
	for (long invalid : INVALID_SUBJECT_PERSON_IDS) {
	    try {
		service.getById(invalid);
		fail("Not found exception Expected");
	    } catch (NotFound e) {
	    }
	}
    }

    @Test
    public void testGetByIIN() throws NamingException, InvalidInputParameter {
	SubjectPersonServiceDAO service = getSubjectPersonServiceEntityWS();
	try {
	    for (String valid : VALID_SUBJECT_PERSON_IINS) {
		SubjectPersonEntity res = service.getByIIN(valid);
		assertThat(res, not(nullValue()));
	    }
	} catch (NotFound e) {
	    fail(e.getMessage());
	}
    }

    @Test
    public void testGetByIIN_NotFound() throws NamingException, InvalidInputParameter {
	SubjectPersonServiceDAO service = getSubjectPersonServiceEntityWS();
	for (String invalid : INVALID_SUBJECT_PERSON_IINS) {
	    try {
		service.getByIIN(invalid);
		fail("Not found exception Expected");
	    } catch (NotFound e) {
	    }
	}
    }

}
