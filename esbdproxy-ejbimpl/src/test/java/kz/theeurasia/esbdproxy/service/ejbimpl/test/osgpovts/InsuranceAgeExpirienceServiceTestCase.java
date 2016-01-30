package kz.theeurasia.esbdproxy.service.ejbimpl.test.osgpovts;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import javax.naming.NamingException;

import org.junit.Test;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.InsuredAgeExpirienceClassDict;
import kz.theeurasia.esbdproxy.service.ejbimpl.test.GeneralServiceTestCase;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.osgpovts.InsuredAgeExpirienceClassServiceDAO;

public class InsuranceAgeExpirienceServiceTestCase extends GeneralServiceTestCase {

    private static final long INVALID_ID = -99999l;

    @Test
    public void testGetAll() throws NamingException {
	InsuredAgeExpirienceClassServiceDAO service = getInsuredAgeExpirienceClassServiceEntityWS();
	List<InsuredAgeExpirienceClassDict> all = service.getAll();
	assertThat(all,
		allOf(
			not(nullValue()),
			contains(InsuredAgeExpirienceClassDict.values())));
    }

    @Test
    public void testGetById() throws NamingException {
	InsuredAgeExpirienceClassServiceDAO service = getInsuredAgeExpirienceClassServiceEntityWS();
	InsuredAgeExpirienceClassDict[] list = InsuredAgeExpirienceClassDict.values();
	for (InsuredAgeExpirienceClassDict i : list) {
	    try {
		InsuredAgeExpirienceClassDict res = service.getById(i.getId());
		assertThat(res, allOf(not(nullValue()), equalTo(i)));
	    } catch (NotFound e) {
		fail(e.getMessage());
	    }
	}
    }

    @Test(expected = NotFound.class)
    public void testGetById_NotFound() throws NamingException, NotFound {
	InsuredAgeExpirienceClassServiceDAO service = getInsuredAgeExpirienceClassServiceEntityWS();
	service.getById(INVALID_ID);
    }

}
