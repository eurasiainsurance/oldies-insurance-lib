package kz.theeurasia.esbdproxy.service.ejbimpl.test.osgpovts;

import static kz.theeurasia.esbdproxy.service.ejbimpl.test.TestConstants.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import javax.naming.NamingException;

import org.junit.Test;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.VehicleClassDict;
import kz.theeurasia.esbdproxy.service.ejbimpl.test.GeneralServiceTestCase;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.osgpovts.VehicleClassServiceDAO;

public class VehicleClassServiceTestCase extends GeneralServiceTestCase {

    @Test
    public void testGetAll() throws NamingException {
	VehicleClassServiceDAO service = getVehicleClassServiceEntityWS();
	List<VehicleClassDict> all = service.getAll();
	assertThat(all,
		allOf(
			not(nullValue()),
			contains(VehicleClassDict.values())));
    }

    @Test
    public void testGetById() throws NamingException {
	VehicleClassServiceDAO service = getVehicleClassServiceEntityWS();
	VehicleClassDict[] list = VehicleClassDict.values();
	for (VehicleClassDict i : list) {
	    try {
		VehicleClassDict res = service.getById(i.getId());
		assertThat(res, allOf(not(nullValue()), equalTo(i)));
	    } catch (NotFound e) {
		fail(e.getMessage());
	    }
	}
    }

    @Test(expected = NotFound.class)
    public void testGetById_NotFound() throws NamingException, NotFound {
	VehicleClassServiceDAO service = getVehicleClassServiceEntityWS();
	service.getById(INVALID_VEHICLE_CLASS_ID);
    }

}
