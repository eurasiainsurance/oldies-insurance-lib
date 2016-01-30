package kz.theeurasia.esbdproxy.service.ejbimpl.test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import javax.naming.NamingException;

import org.junit.Test;

import kz.theeurasia.esbdproxy.domain.dict.CancelationReasonDict;
import kz.theeurasia.esbdproxy.services.CancelationReasonServiceDAO;
import kz.theeurasia.esbdproxy.services.NotFound;

public class CancelationReasonServiceTestCase extends GeneralServiceTestCase {

    private static final long INVALID_ID = -99999l;

    @Test
    public void testGetAll() throws NamingException {
	CancelationReasonServiceDAO service = getCancelationReasonService();
	List<CancelationReasonDict> all = service.getAll();
	assertThat(all,
		allOf(
			not(nullValue()),
			contains(CancelationReasonDict.values())));
    }

    @Test
    public void testGetById() throws NamingException {
	CancelationReasonServiceDAO service = getCancelationReasonService();
	CancelationReasonDict[] list = CancelationReasonDict.values();
	for (CancelationReasonDict i : list) {
	    try {
		CancelationReasonDict res = service.getById(i.getId());
		assertThat(res, allOf(not(nullValue()), equalTo(i)));
	    } catch (NotFound e) {
		fail(e.getMessage());
	    }
	}
    }

    @Test(expected = NotFound.class)
    public void testGetById_NotFound() throws NamingException, NotFound {
	CancelationReasonServiceDAO service = getCancelationReasonService();
	service.getById(INVALID_ID);
    }

}
