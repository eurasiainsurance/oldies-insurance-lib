package kz.theeurasia.esbdproxy.service.ejbimpl.test.osgpovts;

import static kz.theeurasia.esbdproxy.service.ejbimpl.test.TestConstants.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import javax.naming.NamingException;

import org.junit.Test;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.VehicleAgeClassDict;
import kz.theeurasia.esbdproxy.service.ejbimpl.test.GeneralServiceTestCase;
import kz.theeurasia.esbdproxy.services.InvalidInputParameter;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.osgpovts.VehicleAgeClassServiceDAO;

public class VehicleAgeClassServiceTestCase extends GeneralServiceTestCase {

    @Test
    public void testGetAll() throws NamingException {
	VehicleAgeClassServiceDAO service = getVehicleAgeClassServiceEntityWS();
	List<VehicleAgeClassDict> all = service.getAll();
	assertThat(all,
		allOf(
			not(nullValue()),
			contains(VehicleAgeClassDict.values())));
    }

    @Test
    public void testGetById() throws NamingException, InvalidInputParameter {
	VehicleAgeClassServiceDAO service = getVehicleAgeClassServiceEntityWS();
	VehicleAgeClassDict[] list = VehicleAgeClassDict.values();
	for (VehicleAgeClassDict i : list) {
	    try {
		VehicleAgeClassDict res = service.getById(i.getId());
		assertThat(res, allOf(not(nullValue()), equalTo(i)));
	    } catch (NotFound e) {
		fail(e.getMessage());
	    }
	}
    }

    @Test(expected = NotFound.class)
    public void testGetById_NotFound() throws NamingException, NotFound, InvalidInputParameter {
	VehicleAgeClassServiceDAO service = getVehicleAgeClassServiceEntityWS();
	service.getById(INVALID_VEHICLE_AGE_CLASS_ID);
    }

}
