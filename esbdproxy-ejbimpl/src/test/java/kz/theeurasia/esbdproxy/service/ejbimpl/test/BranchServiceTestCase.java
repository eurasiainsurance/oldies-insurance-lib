package kz.theeurasia.esbdproxy.service.ejbimpl.test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import javax.naming.NamingException;

import org.junit.Test;

import kz.theeurasia.esbdproxy.domain.entities.BranchEntity;
import kz.theeurasia.esbdproxy.services.BranchServiceDAO;
import kz.theeurasia.esbdproxy.services.NotFound;

public class BranchServiceTestCase extends GeneralServiceTestCase {

    private static final long INVALID_ID = -99999l;

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
    public void testGetById() throws NamingException {
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
    public void testGetById_NotFound() throws NamingException, NotFound {
	BranchServiceDAO service = getBranchServiceEntityWS();
	service.getById(INVALID_ID);
    }

}
