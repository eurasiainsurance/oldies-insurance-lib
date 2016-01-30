package kz.theeurasia.esbdproxy.service.ejbimpl.test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import javax.naming.NamingException;

import org.junit.Test;

import kz.theeurasia.esbdproxy.domain.dict.CancelationReasonDict;
import kz.theeurasia.esbdproxy.services.CancelationReasonServiceDAO;
import kz.theeurasia.esbdproxy.services.NotFound;

public class CancelationReasonServiceTestUnit extends GeneralServiceTestUnit {

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
	try {
	    cancelationReasonService.getById(-99999l);
	    fail("Expected a NotFound to be thrown");
	} catch (NotFound e) {
	}

    }

}
