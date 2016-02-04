package kz.theeurasia.esbdproxy.service.ejbimpl.test.general;

import static kz.theeurasia.esbdproxy.service.ejbimpl.test.TestConstants.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import javax.naming.NamingException;

import org.junit.Test;

import kz.theeurasia.esbdproxy.domain.entities.general.BranchEntity;
import kz.theeurasia.esbdproxy.service.ejbimpl.test.GeneralServiceTestCase;
import kz.theeurasia.esbdproxy.services.InvalidInputParameter;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.general.BranchServiceDAO;

public class BranchServiceTestCase extends GeneralServiceTestCase {

    @Test
    public void testGetAll() throws NamingException {
	BranchServiceDAO service = getBranchServiceEntityWS();
	List<BranchEntity> all = service.getAll();
	assertThat(all,
		allOf(
			not(nullValue()),
			not(empty())));
    }

    @Test
    public void testGetById() throws NamingException, InvalidInputParameter {
	BranchServiceDAO service = getBranchServiceEntityWS();
	List<BranchEntity> list = service.getAll();
	for (BranchEntity i : list) {
	    try {
		BranchEntity res = service.getById(i.getId());
		assertThat(res, allOf(not(nullValue()), is(i)));
	    } catch (NotFound e) {
		fail(e.getMessage());
	    }
	}
    }

    @Test(expected = NotFound.class)
    public void testGetById_NotFound() throws NamingException, NotFound, InvalidInputParameter {
	BranchServiceDAO service = getBranchServiceEntityWS();
	service.getById(INVALID_BRANCH_ID);
    }

}
