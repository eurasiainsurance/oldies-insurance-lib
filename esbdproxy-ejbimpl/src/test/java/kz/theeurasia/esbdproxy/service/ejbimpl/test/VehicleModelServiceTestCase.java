package kz.theeurasia.esbdproxy.service.ejbimpl.test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import javax.naming.NamingException;

import org.junit.Test;

import kz.theeurasia.esbdproxy.domain.entities.osgpovts.VehicleModelEntity;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.VehicleModelServiceDAO;

public class VehicleModelServiceTestCase extends GeneralServiceTestCase {

    private static final long INVALID_ID = -99999l;

    @Test
    public void testGetAll() throws NamingException {
	VehicleModelServiceDAO service = getVehicleModelServiceEntityWS();
	List<VehicleModelEntity> all = service.getAll();
	assertThat(all,
		allOf(
			not(nullValue()),
			not(empty())));
    }

    @Test
    public void testGetById() throws NamingException {
	VehicleModelServiceDAO service = getVehicleModelServiceEntityWS();
	List<VehicleModelEntity> list = service.getAll();
	for (VehicleModelEntity i : list) {
	    try {
		VehicleModelEntity res = service.getById(i.getId());
		assertThat(res, allOf(not(nullValue()), is(i)));
	    } catch (NotFound e) {
		fail(e.getMessage());
	    }
	}
    }

    @Test(expected = NotFound.class)
    public void testGetById_NotFound() throws NamingException, NotFound {
	VehicleModelServiceDAO service = getVehicleModelServiceEntityWS();
	service.getById(INVALID_ID);
    }

}
