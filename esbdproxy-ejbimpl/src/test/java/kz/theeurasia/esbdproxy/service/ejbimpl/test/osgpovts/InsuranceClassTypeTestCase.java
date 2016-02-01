package kz.theeurasia.esbdproxy.service.ejbimpl.test.osgpovts;

import static kz.theeurasia.esbdproxy.service.ejbimpl.test.TestConstants.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import javax.naming.NamingException;

import org.junit.Test;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.InsuranceClassTypeDict;
import kz.theeurasia.esbdproxy.domain.entities.general.SubjectPersonEntity;
import kz.theeurasia.esbdproxy.service.ejbimpl.test.GeneralServiceTestCase;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.osgpovts.InsuranceClassTypeServiceDAO;

public class InsuranceClassTypeTestCase extends GeneralServiceTestCase {

    @Test
    public void testGetById() throws NamingException {
	InsuranceClassTypeServiceDAO service = getInsuranceClassTypeServiceEntityWS();
	try {
	    InsuranceClassTypeDict res = service.getById(VALID_INSURANCE_CLASS_TYPE_ID);
	    assertThat(res, allOf(not(nullValue()), equalTo(InsuranceClassTypeDict.CLASS_12)));
	} catch (NotFound e) {
	    fail(e.getMessage());
	}
    }

    @Test(expected = NotFound.class)
    public void testGetById_NotFound() throws NamingException, NotFound {
	InsuranceClassTypeServiceDAO service = getInsuranceClassTypeServiceEntityWS();
	service.getById(INVALID_INSURANCE_CLASS_TYPE_ID);
    }

    @Test
    public void testGetByCode() throws NamingException {
	InsuranceClassTypeServiceDAO service = getInsuranceClassTypeServiceEntityWS();
	InsuranceClassTypeDict[] list = InsuranceClassTypeDict.values();
	for (InsuranceClassTypeDict i : list) {
	    try {
		InsuranceClassTypeDict res = service.getByCode(i.getCode());
		assertThat(res, allOf(not(nullValue()), equalTo(i)));
	    } catch (NotFound e) {
		fail(e.getMessage());
	    }
	}
    }

    @Test(expected = NotFound.class)
    public void testGetByCode_NotFound() throws NamingException, NotFound {
	InsuranceClassTypeServiceDAO service = getInsuranceClassTypeServiceEntityWS();
	service.getByCode(INVALID_INSURANCE_CLASS_TYPE_CODE);
    }

    @Test
    public void testGetForSubject() throws NamingException {
	InsuranceClassTypeServiceDAO service = getInsuranceClassTypeServiceEntityWS();
	try {
	    SubjectPersonEntity e = new SubjectPersonEntity();
	    e.setId(VALID_SUBJECT_PERSON_ID);
	    InsuranceClassTypeDict res = service.getForSubject(e);
	    assertThat(res, allOf(not(nullValue()), equalTo(VALID_CLASS_TYPE_FOR_CLIENT)));
	} catch (NotFound e) {
	    fail(e.getMessage());
	}
    }

    @Test(expected = NotFound.class)
    public void testGetForSubject_NotFound() throws NamingException, NotFound {
	InsuranceClassTypeServiceDAO service = getInsuranceClassTypeServiceEntityWS();
	SubjectPersonEntity e = new SubjectPersonEntity();
	e.setId(INVALID_SUBJECT_PERSON_ID);
	service.getForSubject(e);
    }

}
