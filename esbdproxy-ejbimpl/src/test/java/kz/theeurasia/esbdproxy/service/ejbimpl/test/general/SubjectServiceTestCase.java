package kz.theeurasia.esbdproxy.service.ejbimpl.test.general;

import static kz.theeurasia.esbdproxy.service.ejbimpl.test.TestConstants.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import javax.naming.NamingException;

import org.junit.Test;

import kz.theeurasia.esbdproxy.domain.entities.general.SubjectEntity;
import kz.theeurasia.esbdproxy.domain.enums.general.SubjectTypeEnum;
import kz.theeurasia.esbdproxy.service.ejbimpl.test.GeneralServiceTestCase;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.general.SubjectServiceDAO;

public class SubjectServiceTestCase extends GeneralServiceTestCase {

    @Test
    public void testGetById() throws NamingException {
	SubjectServiceDAO service = getSubjectServiceEntityWS();
	try {
	    for (int i = 0; i < VALID_SUBJECT_IDS.length; i++) {
		long validSubjectId = VALID_SUBJECT_IDS[i];
		SubjectTypeEnum validSubjectType = VALID_SUBJECT_TYPES[i];
		Class<?> validSubjectClass = VALID_SUBJECT_CLASSES[i];
		SubjectEntity res = service.getById(validSubjectId);
		assertThat(res, allOf(not(nullValue()), instanceOf(validSubjectClass)));
		assertThat(res.getSubjectType(), allOf(not(nullValue()), is(validSubjectType)));
		System.out.println(res.getId() + " " + res.getIdNumber());
	    }
	} catch (NotFound e) {
	    fail(e.getMessage());
	}
    }

    @Test(expected = NotFound.class)
    public void testGetById_NotFound() throws NamingException, NotFound {
	SubjectServiceDAO service = getSubjectServiceEntityWS();
	service.getById(INVALID_SUBJECT_ID);
    }

    @Test
    public void testGetByIDNumber() throws NamingException {
	SubjectServiceDAO service = getSubjectServiceEntityWS();
	try {
	    for (int i = 0; i < VALID_SUBJECT_ID_NUMBERS.length; i++) {
		String subjecdIdNumber = VALID_SUBJECT_ID_NUMBERS[i];
		SubjectTypeEnum validSubjectType = VALID_SUBJECT_TYPES[i];
		Class<?> validSubjectClass = VALID_SUBJECT_CLASSES[i];
		SubjectEntity res = service.getByIdNumber(subjecdIdNumber);
		assertThat(res, allOf(not(nullValue()), instanceOf(validSubjectClass)));
		assertThat(res.getSubjectType(), allOf(not(nullValue()),
			is(validSubjectType)));
		assertThat(res.getIdNumber(), allOf(not(nullValue()), equalTo(subjecdIdNumber)));
	    }
	} catch (NotFound e) {
	    fail(e.getMessage());
	}
    }

    @Test(expected = NotFound.class)
    public void testGetByIDNumber_NotFound() throws NamingException, NotFound {
	SubjectServiceDAO service = getSubjectServiceEntityWS();
	service.getByIdNumber(INVALID_SUBJECT_ID_NUMBER);
    }

}
