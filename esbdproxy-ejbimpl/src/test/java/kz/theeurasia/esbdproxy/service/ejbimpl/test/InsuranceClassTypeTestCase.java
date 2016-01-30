package kz.theeurasia.esbdproxy.service.ejbimpl.test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import javax.naming.NamingException;

import org.junit.Test;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.InsuranceClassTypeDict;
import kz.theeurasia.esbdproxy.domain.entities.SubjectPersonEntity;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.osgpovts.InsuranceClassTypeServiceDAO;

public class InsuranceClassTypeTestCase extends GeneralServiceTestCase {

    private static final long CORRECT_CLASS_TYPE_ID = 14l;
    private static final String INVALID_CLASS_TYPE_CODE = "QQ";
    private static final long INVALID_CLASS_TYPE_ID = 999999999999999l;

    private static final long INVALID_CLIENT_ID = 999999999l;
    private static final long CORRECT_CLIENT_ID = 14132412; // Evsyukovs ID

    @Test
    public void testGetById() throws NamingException {
	InsuranceClassTypeServiceDAO service = getInsuranceClassTypeServiceEntityWS();
	try {
	    InsuranceClassTypeDict res = service.getById(CORRECT_CLASS_TYPE_ID);
	    assertThat(res, allOf(not(nullValue()), equalTo(InsuranceClassTypeDict.CLASS_12)));
	} catch (NotFound e) {
	    fail(e.getMessage());
	}
    }

    @Test(expected = NotFound.class)
    public void testGetById_NotFound() throws NamingException, NotFound {
	InsuranceClassTypeServiceDAO service = getInsuranceClassTypeServiceEntityWS();
	service.getById(-INVALID_CLASS_TYPE_ID);
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
	service.getByCode(INVALID_CLASS_TYPE_CODE);
    }

    @Test
    public void testGetForSubject() throws NamingException {
	InsuranceClassTypeServiceDAO service = getInsuranceClassTypeServiceEntityWS();
	try {
	    SubjectPersonEntity e = new SubjectPersonEntity();
	    e.setId(CORRECT_CLIENT_ID);
	    InsuranceClassTypeDict res = service.getForSubjcect(e);
	    assertThat(res, allOf(not(nullValue()), equalTo(InsuranceClassTypeDict.CLASS_12)));
	} catch (NotFound e) {
	    fail(e.getMessage());
	}
    }

    @Test(expected = NotFound.class)
    public void testGetForSubject_NotFound() throws NamingException, NotFound {
	InsuranceClassTypeServiceDAO service = getInsuranceClassTypeServiceEntityWS();
	SubjectPersonEntity e = new SubjectPersonEntity();
	e.setId(INVALID_CLIENT_ID);
	service.getForSubjcect(e);
    }

}
