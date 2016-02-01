package kz.theeurasia.esbdproxy.service.ejbimpl.test.general;

import static kz.theeurasia.esbdproxy.service.ejbimpl.test.TestConstants.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import javax.naming.NamingException;

import org.junit.Test;

import kz.theeurasia.esbdproxy.domain.dict.general.CancelationReasonDict;
import kz.theeurasia.esbdproxy.service.ejbimpl.test.GeneralServiceTestCase;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.general.CancelationReasonServiceDAO;

public class CancelationReasonServiceTestCase extends GeneralServiceTestCase {

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
	service.getById(INVALID_CANCELATION_REASON_ID);
    }

}
