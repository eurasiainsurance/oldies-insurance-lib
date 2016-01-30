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

    @Test
    public void testGetAll() throws NamingException {
	CancelationReasonServiceDAO cancelationReasonService = getCancelationReasonService();
	List<CancelationReasonDict> all = cancelationReasonService.getAll();
	assertThat(all,
		allOf(
			not(nullValue()),
			contains(CancelationReasonDict.values())));
    }

    @Test
    public void testGetById() throws NamingException {
	CancelationReasonServiceDAO cancelationReasonService = getCancelationReasonService();
	CancelationReasonDict[] list = CancelationReasonDict.values();
	for (CancelationReasonDict i : list) {
	    try {
		CancelationReasonDict res = cancelationReasonService.getById(i.getId());
		assertThat(res, allOf(not(nullValue()), equalTo(i)));
	    } catch (NotFound e) {
		fail(e.getMessage());
	    }
	}
    }

    @Test(expected = NotFound.class)
    public void testGetById_NotFOund() throws NamingException, NotFound {
	CancelationReasonServiceDAO cancelationReasonService = getCancelationReasonService();
	cancelationReasonService.getById(-99999l);
    }

}
